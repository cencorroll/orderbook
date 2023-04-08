package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ab.entities.Order;
import com.ab.entities.OrderBook;
import com.ab.entities.User;

import jakarta.servlet.http.HttpSession;

public class TradingEngine {

  @Autowired
  OrderService orderService;

  @Autowired
  OrderBookService orderBookservice;

  public String trade(HttpSession session){

    List<Order> buyOrders = orderService.findByType("buy");
    List<Order> sellOrders = orderService.findByType("sell");

    for (Order buyOrder : buyOrders) {
      for (Order sellOrder : sellOrders) {
        if (buyOrder.getPrice() >= sellOrder.getPrice()) {
          if (buyOrder.getAmount() == sellOrder.getAmount()) {
            buyOrder.setStatus("filled");
            sellOrder.setStatus("filled");
            orderService.updateOrder(buyOrder);
            orderService.updateOrder(sellOrder);
          } else if (buyOrder.getAmount() > sellOrder.getAmount()) {
            buyOrder.setStatus("partially filled");
            sellOrder.setStatus("filled");
            buyOrder.setAmount(buyOrder.getAmount() - sellOrder.getAmount());
            orderService.updateOrder(buyOrder);
            orderService.updateOrder(sellOrder);
          } else if (buyOrder.getAmount() < sellOrder.getAmount()) {
            buyOrder.setStatus("filled");
            sellOrder.setStatus("partially filled");
            sellOrder.setAmount(sellOrder.getAmount() - buyOrder.getAmount());
            orderService.updateOrder(buyOrder);
            orderService.updateOrder(sellOrder);
          }
        }
      }
    }


    User user = (User) session.getAttribute("loggedInUser");

    OrderBook orderBook = orderBookservice.findOrderBookByUserId(user);

    for (Order buyOrder : buyOrders) {
      for (Order sellOrder : sellOrders) {
          if (buyOrder.getPrice() >= sellOrder.getPrice()) {
              // Logic to fill, partially fill, or not fill the order
              if (buyOrder.getAmount() == sellOrder.getAmount()) {
                  buyOrder.setStatus("filled");
                  sellOrder.setStatus("filled");
              } else if (buyOrder.getAmount() > sellOrder.getAmount()) {
                  buyOrder.setStatus("partially filled");
                  sellOrder.setStatus("filled");
                  buyOrder.setAmount(buyOrder.getAmount() - sellOrder.getAmount());
              } else if (buyOrder.getAmount() < sellOrder.getAmount()) {
                  buyOrder.setStatus("filled");
                  sellOrder.setStatus("partially filled");
                  sellOrder.setAmount(sellOrder.getAmount() - buyOrder.getAmount());
              }
  
              // Update the order book
              if (buyOrder.getStatus().equals("filled")) {
                  orderBook.removeOrder(buyOrder);
              } else {
                  orderBook.updateOrder(buyOrder);
              }
  
              if (sellOrder.getStatus().equals("filled")) {
                  orderBook.removeOrder(sellOrder);
              } else {
                  orderBook.updateOrder(sellOrder);
              }
          }
      }
  }

  orderBookservice.updateOrderBook(orderBook);


    return "orderbook";

  }


}

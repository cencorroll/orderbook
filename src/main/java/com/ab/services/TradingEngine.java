package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Order;
// import com.ab.entities.OrderBook;
// import com.ab.entities.User;
import com.ab.entities.OrderHistory;

import jakarta.servlet.http.HttpSession;

@Service
public class TradingEngine {

  @Autowired
  OrderService orderService;

  @Autowired
  OrderHistoryService orderHistoryService;

  // @Autowired
  // OrderBookService orderBookservice;

  public String trade(HttpSession session) {

    List<Order> buyOrders = orderService.findByType("buy");
    List<Order> sellOrders = orderService.findByType("sell");

    List<OrderHistory> buyOrderHistoryList = orderHistoryService.findByType("buy");
    List<OrderHistory> sellOrderHistoryList = orderHistoryService.findByType("sell");

    System.out.println("buy orders:");
    for (Order buyOrder : buyOrders) {
        System.out.println(buyOrder);
    }
    
    System.out.println("sell orders:");
    for (Order sellOrder : sellOrders) {
        System.out.println(sellOrder);
    }
    

    boolean orderMatched = false;

    for (Order buyOrder : buyOrders) {
      for (Order sellOrder : sellOrders) {
        if (buyOrder.getOrderPrice() == sellOrder.getOrderPrice()) {
          if (buyOrder.getOrderAmount() == sellOrder.getOrderAmount()) {
            buyOrder.setStatus("filled");
            sellOrder.setStatus("filled");

            // Update Order History
            for (OrderHistory buyOrderHistory : buyOrderHistoryList) {
              if (buyOrderHistory.getOrderHistoryId() == buyOrder.getOrderId()) {
                buyOrderHistory.setOrderStatus("filled");
                orderHistoryService.updateOrderHistory(buyOrderHistory);
              }
            }
            for (OrderHistory sellOrderHistory : sellOrderHistoryList) {
              if (sellOrderHistory.getOrderHistoryId() == sellOrder.getOrderId()) {
                sellOrderHistory.setOrderStatus("filled");
                orderHistoryService.updateOrderHistory(sellOrderHistory);
              }
            }

            orderService.updateOrder(buyOrder);
            orderService.updateOrder(sellOrder);
            orderMatched = true;
            break;

          } else if (buyOrder.getOrderAmount() > sellOrder.getOrderAmount()) {

            buyOrder.setStatus("partially filled");
            sellOrder.setStatus("filled");
            buyOrder.setOrderAmount(buyOrder.getOrderAmount() - sellOrder.getOrderAmount());

            for (OrderHistory buyOrderHistory : buyOrderHistoryList) {
              if (buyOrderHistory.getOrderHistoryId() == buyOrder.getOrderId()) {
                buyOrderHistory.setOrderStatus("partially filled");
                orderHistoryService.updateOrderHistory(buyOrderHistory);
              }
            }
            for (OrderHistory sellOrderHistory : sellOrderHistoryList) {
              if (sellOrderHistory.getOrderHistoryId() == sellOrder.getOrderId()) {
                sellOrderHistory.setOrderStatus("filled");
                orderHistoryService.updateOrderHistory(sellOrderHistory);
              }
            }

            orderService.updateOrder(buyOrder);
            orderService.updateOrder(sellOrder);
            orderMatched = true;
            break;

          } else if (buyOrder.getOrderAmount() < sellOrder.getOrderAmount()) {

            buyOrder.setStatus("filled");
            sellOrder.setStatus("partially filled");
            sellOrder.setOrderAmount(sellOrder.getOrderAmount() - buyOrder.getOrderAmount());

            for (OrderHistory buyOrderHistory : buyOrderHistoryList) {
              if (buyOrderHistory.getOrderHistoryId() == buyOrder.getOrderId()) {
                buyOrderHistory.setOrderStatus("filled");
                orderHistoryService.updateOrderHistory(buyOrderHistory);
              }
            }
            for (OrderHistory sellOrderHistory : sellOrderHistoryList) {
              if (sellOrderHistory.getOrderHistoryId() == sellOrder.getOrderId()) {
                sellOrderHistory.setOrderStatus("partially filled");
                orderHistoryService.updateOrderHistory(sellOrderHistory);
              }
            }
            
            orderService.updateOrder(buyOrder);
            orderService.updateOrder(sellOrder);
            orderMatched = true;
            break;

          }
        }
      }
      if (orderMatched) {
        break;
      }
    }

    return "orderbook";

  }

}
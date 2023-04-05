package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ab.entities.Order;
import com.ab.entities.OrderBook;
import com.ab.entities.User;
import com.ab.services.OrderService;

import jakarta.servlet.http.HttpSession;

public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/orders")
  private String orders() {
    return "orders";
  }

  @GetMapping("/orders/add")
  private String addOrder() {
    return "addOrder";
  }
  
  @PostMapping(value = "addOrderProcess")
  private String addOrderProcess(@RequestParam("orderType") String orderType, @RequestParam("orderPrice") double orderPrice, @RequestParam("orderAmount") int orderAmount, HttpSession session) {

    User user = (User) session.getAttribute("user");
    OrderBook orderBook = new OrderBook();
    orderBook.setUserId(user);
    
    Order order = new Order();
    order.setType(orderType);
    order.setPrice(orderPrice);
    order.setAmount(orderAmount);
    order.setStatus("Not Filled");
    order.setOrderBook(orderBook);
    orderService.addOrder(order);
    return "redirect:/orders";
  
  }
  
}

package com.ab.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ab.entities.Order;
import com.ab.entities.OrderHistory;
// import com.ab.entities.OrderBook;
import com.ab.entities.User;
import com.ab.services.OrderHistoryService;
// import com.ab.repositories.OrderBookRepository;
import com.ab.services.OrderService;
import com.ab.services.TradingEngine;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

  @Autowired
  private OrderService orderService;

  // @Autowired
  // private OrderBookRepository orderBookRepository;

  @Autowired
  private TradingEngine tradingEngine;

  @Autowired
  private OrderHistoryService orderHistoryService;

  @GetMapping("/orders")
  private String getOrders(Model model) {

      List<Order> orders = orderService.getAllOrders();
      model.addAttribute("orders", orders);
      return "orders";
    
  }

  @GetMapping("/myorders")
  private String getMyOrders(Model model, HttpSession session) {

    User user = (User) session.getAttribute("loggedInUser");
      List<Order> orders = orderService.findByUser(user);
      model.addAttribute("orders", orders);
      return "myorders";
    
  }

  @GetMapping("/neworder")
  private String addOrder() {
    return "neworder";
  }
  
  @PostMapping(value = "newOrderProcess")
  private String addOrderProcess(@RequestParam("orderType") String orderType, @RequestParam("orderPrice") double orderPrice, @RequestParam("orderAmount") int orderAmount, HttpSession session) {

    User user = (User) session.getAttribute("loggedInUser");
    LocalDateTime dateTime = LocalDateTime.now();
		String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    // OrderBook orderBook = new OrderBook();
    // orderBookRepository.save(orderBook);
    // System.out.println(orderBook);
    
    Order o = new Order();
    o.setUser(user);
    o.setOrderType(orderType);
    o.setOrderPrice(orderPrice);
    o.setOrderAmount(orderAmount);
    o.setStatus("Not Filled");
    o.setOrderDate(formattedDate);
    // o.setOrderBook(orderBook);
    System.out.println(o);
    Order savedInfo = orderService.addOrder(o);
    System.out.println(savedInfo);

    OrderHistory oH = new OrderHistory();
    oH.setUser(user);
    oH.setOrderType(orderType);
    oH.setOrderPrice(orderPrice);
    oH.setOrderAmount(orderAmount);
    oH.setOrderStatus("Not Filled");
    oH.setOrderDate(formattedDate);
    // oH.setOrderBook(orderBook);
    System.out.println(oH);
    OrderHistory savedoHInfo = orderHistoryService.addOrderHistory(oH);
    System.out.println(savedoHInfo);

    tradingEngine.trade(session);

    if (savedInfo != null && savedoHInfo != null) {
      return "redirect:/orders";
    } else {
      return "orderfailure";
    }
  
  }
  
}

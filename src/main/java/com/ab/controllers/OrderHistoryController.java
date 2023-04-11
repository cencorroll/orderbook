package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ab.entities.OrderHistory;
import com.ab.entities.User;
import com.ab.services.OrderHistoryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderHistoryController {

  @Autowired
  private OrderHistoryService orderHistoryService;

  @GetMapping("/orderhistory")
  private String getOrderHistory(Model model, HttpSession session) {

    User user = (User) session.getAttribute("loggedInUser");
      List<OrderHistory> orderHistory = orderHistoryService.findByUser(user);
      model.addAttribute("orderHistory", orderHistory);
      return "orderhistory";
    
  }
  
  
}

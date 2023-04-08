package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.services.TradingEngine;

import jakarta.servlet.http.HttpSession;

@RestController
public class TradeController {

  @Autowired
  private TradingEngine tradingEngine;

  @PostMapping("/trade")
  public String trade(HttpSession session) {
    return tradingEngine.trade(session);
  }

}


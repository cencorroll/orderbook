package com.ab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.OrderBook;
import com.ab.entities.User;
import com.ab.repositories.OrderBookRepository;

@Service
public class OrderBookService {

  @Autowired
  private OrderBookRepository orderBookRepository;

  public OrderBook findOrderBookByUserId(User userId) {
    return orderBookRepository.findByUserId(userId);
  }

  public void updateOrderBook(OrderBook orderBook) {
    orderBookRepository.save(orderBook);
  }
  

}

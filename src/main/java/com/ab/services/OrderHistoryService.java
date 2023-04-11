package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.OrderHistory;
import com.ab.entities.User;
import com.ab.repositories.OrderHistoryRepository;

@Service
public class OrderHistoryService {

  @Autowired
  private OrderHistoryRepository orderHistoryRepository;

  public OrderHistory addOrderHistory(OrderHistory orderHistory) {
    return orderHistoryRepository.save(orderHistory);
  }

  public OrderHistory updateOrderHistory(OrderHistory orderHistory) {
    return orderHistoryRepository.save(orderHistory);
  }

  public OrderHistory getOrderHistoryById(int orderHistoryId) {
    return orderHistoryRepository.findByOrderHistoryId(orderHistoryId).get(0);
  }

  public List<OrderHistory> findByUser(User user) {
    return orderHistoryRepository.findByUser(user);
  }

  public List<OrderHistory> findByType(String orderType) {
    return orderHistoryRepository.findByOrderType(orderType);
  }

  public List<OrderHistory> getAllOrderHistoryByUser(User user) {
    return orderHistoryRepository.findByUser(user);
  }

}

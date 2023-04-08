package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Order;
import com.ab.entities.User;
import com.ab.repositories.OrderRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public Order addOrder(Order order) {
    List<Order> existingOrder = orderRepository.findById(order.getOrderId());
    if (existingOrder != null) {
      throw new IllegalArgumentException("Order already exists");
    } else {
    if (order.getAmount() == 0 || order.getPrice() == 0 || order.getType() == null || order.getStatus() == null)
      throw new IllegalArgumentException("Order cannot be null or empty");
      
    return orderRepository.save(order);
    }
  }

  public Order updateOrder(Order order) {
    return orderRepository.save(order);
  }

  public Order getOrderById(int orderId) {
    return orderRepository.findById(orderId).get(orderId);
  }

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public List<Order> findByUserId(User userId) {
    return orderRepository.findByUserId(userId);
  }

  public List<Order> findByType(String type) {
    return orderRepository.findByType(type);
  }
}

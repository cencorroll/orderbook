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
    List<Order> existingOrder = orderRepository.findByOrderId(order.getOrderId());
    if (!existingOrder.isEmpty()) {
      throw new IllegalArgumentException("Order already exists");
    } else {
    if (order.getOrderAmount() == 0 || order.getOrderPrice() == 0 || order.getOrderType() == null || order.getOrderStatus() == null)
      throw new IllegalArgumentException("Order cannot be null or empty");
      
    return orderRepository.save(order);
    }
  }

  public Order updateOrder(Order order) {
    return orderRepository.save(order);
  }

  public Order getOrderById(int orderId) {
    return orderRepository.findByOrderId(orderId).get(0);
  }

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public List<Order> findByUser(User user) {
    return orderRepository.findByUser(user);
  }

  public List<Order> findByType(String orderType) {
    return orderRepository.findByOrderType(orderType);
  }
}

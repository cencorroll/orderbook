package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.entities.Order;
import com.ab.entities.User;

public interface OrderRepository extends JpaRepository<Order, Integer>{

  List<Order> findByOrderId(int orderId);

  List<Order> findByUser(User user);

  List<Order> findByOrderType(String orderType);

  // List<Order> findByOrderBookId(int orderBookId);
  
}
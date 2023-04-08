package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.entities.Order;
import com.ab.entities.User;

public interface OrderRepository extends JpaRepository<Order, Integer>{

  List<Order> findById(int orderId);

  List<Order> findByUserId(User userId);

  List<Order> findByType(String type);

  // List<Order> findByOrderBookId(int orderBookId);
  
}

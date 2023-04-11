package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.entities.OrderHistory;
import com.ab.entities.User;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer>{

  List<OrderHistory> findByOrderHistoryId(int orderHistoryId);

  List<OrderHistory> findByUser(User user);

  List<OrderHistory> findByOrderType(String orderType);
  
  
}

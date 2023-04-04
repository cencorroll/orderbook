package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
  
}

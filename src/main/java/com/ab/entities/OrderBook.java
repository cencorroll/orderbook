package com.ab.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_book")
public class OrderBook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_book_id")
  private int orderBookId;

  @OneToMany(mappedBy = "orderBook", cascade = CascadeType.ALL)
  private List<Order> orders;
  
  public int getOrderBookId() {
    return orderBookId;
  }

  public void setOrderBookId(int orderBookId) {
    this.orderBookId = orderBookId;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  //constructors
  public OrderBook() {
    super();
  }

  public OrderBook(int orderBookId, List<Order> orders) {
    this.orderBookId = orderBookId;
    this.orders = orders;
  }

  // toString method
  public String toString() {
    return "OrderBook [orderBookId=" + orderBookId + ", orders=" + orders + "]";
  }

}
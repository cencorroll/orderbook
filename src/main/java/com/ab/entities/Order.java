package com.ab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderId;

  @Column(name = "order_type", nullable = false)
  private String type;

  @Column(name = "order_price", nullable = false)
  private double price;

  @Column(name = "order_amount", nullable = false)
  private int amount;

  @Column(name = "order_status", nullable = false)
  private String status;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_book_id", referencedColumnName = "order_book_id")
  private OrderBook orderBook;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public OrderBook getOrderBook() {
    return orderBook;
  }

  public void setOrderBook(OrderBook orderBook) {
    this.orderBook = orderBook;
  }

  // Constructors
  public Order() {
    super();
  }

  public Order(int orderId, String type, double price, int amount, String status, OrderBook orderBook) {
    this.orderId = orderId;
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.status = status;
    this.orderBook = orderBook;
  }

  
  // toString method
  public String toString(){
    return "Order [orderId=" + orderId + ", type=" + type + ", price=" + price + ", amount=" + amount + ", status=" + status + "]";
  }
}


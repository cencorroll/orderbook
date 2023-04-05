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
  private String orderType;

  @Column(name = "order_price", nullable = false)
  private double orderPrice;

  @Column(name = "order_amount", nullable = false)
  private int orderAmount;

  @Column(name = "order_status", nullable = false)
  private String orderStatus;

  @Column(name = "order_date", nullable = false)
  private String orderDate;

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
    return orderType;
  }

  public void setType(String type) {
    this.orderType = type;
  }

  public double getPrice() {
    return orderPrice;
  }

  public void setPrice(double price) {
    this.orderPrice = price;
  }

  public int getAmount() {
    return orderAmount;
  }

  public void setAmount(int amount) {
    this.orderAmount = amount;
  }

  public String getStatus() {
    return orderStatus;
  }

  public void setStatus(String status) {
    this.orderStatus = status;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
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
    this.orderType = type;
    this.orderPrice = price;
    this.orderAmount = amount;
    this.orderStatus = status;
    this.orderBook = orderBook;
  }

  
  // toString method
  public String toString(){
    return "Order [orderId=" + orderId + ", type=" + orderType + ", price=" + orderPrice + ", amount=" + orderAmount + ", status=" + orderStatus + ", date=" + orderDate + "]";
  }
}


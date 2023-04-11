package com.ab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_history")
public class OrderHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderHistoryId;

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

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public int getOrderHistoryId() {
    return orderHistoryId;
  }

  public void setOrderHistoryId(int orderHistoryId) {
    this.orderHistoryId = orderHistoryId;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }

  public int getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(int orderAmount) {
    this.orderAmount = orderAmount;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  // Constructors
  public OrderHistory() {
    super();
  }

  public OrderHistory(int orderHistoryId, String type, double orderPrice, int orderAmount, String orderStatus) {
    super();
    this.orderHistoryId = orderHistoryId;
    this.orderType = type;
    this.orderPrice = orderPrice;
    this.orderAmount = orderAmount;
    this.orderStatus = orderStatus;
  }
  
  // toString method
  public String toString(){
    return "Order [orderId=" + orderHistoryId + ", type=" + orderType + ", orderPrice=" + orderPrice + ", orderAmount=" + orderAmount + ", orderStatus=" + orderStatus + "]";
  }
}
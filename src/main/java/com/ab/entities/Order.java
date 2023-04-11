package com.ab.entities;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

  // @ManyToOne(cascade = CascadeType.ALL)
  // private OrderBook orderBook;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
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

  public void setOrderPrice(double price) {
    this.orderPrice = price;
  }

  public int getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(int amount) {
    this.orderAmount = amount;
  }

  public String getOrderStatus() {
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

  // public OrderBook getOrderBook() {
  //   return orderBook;
  // }

  // public void setOrderBook(OrderBook orderBook) {
  //   this.orderBook = orderBook;
  // }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  // Constructors
  public Order() {
    super();
  }

  // public Orders(int orderId, String orderType, double price, int amount, String status, String orderDate, OrderBook orderBook, User userId) {
  //   super();
  //   this.userId = userId;
  //   this.orderId = orderId;
  //   this.orderType = orderType;
  //   this.orderPrice = price;
  //   this.orderAmount = amount;
  //   this.orderStatus = status;
  //   this.orderDate = orderDate;
  //   this.orderBook = orderBook;
  // }

  // toString method
  // @Override
  // public String toString() {
  //   return "Order [orderId=" + orderId + ", orderType=" + orderType + ", price=" + orderPrice + ", amount=" + orderAmount + ", status=" + orderStatus + ", orderDate=" + orderDate + ", orderBook=" + orderBook + ", userId=" + userId + "]";
  // }

  public Order(int orderId, String orderType, double price, int amount, String status, String orderDate, User userId) {
    super();
    this.user = userId;
    this.orderId = orderId;
    this.orderType = orderType;
    this.orderPrice = price;
    this.orderAmount = amount;
    this.orderStatus = status;
    this.orderDate = orderDate;
  }

  @Override
  public String toString() {
    return "Order [orderId=" + orderId + ", orderType=" + orderType + ", orderPrice=" + orderPrice + ", orderAmount=" + orderAmount + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", userId=" + user + "]";
  }
}


package com.ab.entities;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_book")
public class OrderBook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_book_id")
  private int orderBookId;

  @ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

  @OneToMany(mappedBy = "orderBook", cascade = CascadeType.ALL)
  private List<Order> orders;
  
  public int getOrderBookId() {
    return orderBookId;
  }

  public void setOrderBookId(int orderBookId) {
    this.orderBookId = orderBookId;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
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

  public List<Order> allBuyList = orders.stream().filter(o -> o.getType().equals("buy")).collect(Collectors.toList());

  public List<Order> allSellList = orders.stream().filter(o -> o.getType().equals("sell")).collect(Collectors.toList());

  public void removeOrder(Order order) {
    orders.removeIf(o -> o.getOrderId() == order.getOrderId());
}

public void updateOrder(Order order) {
  for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getOrderId() == order.getOrderId()) {
          orders.set(i, order);
          break;
      }
  }
}

  // toString method
  public String toString() {
    return "OrderBook [orderBookId=" + orderBookId + ", orders=" + orders + "]";
  }

}
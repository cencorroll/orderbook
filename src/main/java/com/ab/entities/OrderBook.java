// package com.ab.entities;

// import java.util.List;
// import java.util.stream.Collectors;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "order_book")
// public class OrderBook {

//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Column(name = "order_book_id")
//   private int orderBookId;

//   @OneToMany(mappedBy = "orderBook")
//   private List<Orders> orders;
  
//   public int getOrderBookId() {
//     return orderBookId;
//   }

//   public void setOrderBookId(int orderBookId) {
//     this.orderBookId = orderBookId;
//   }

//   public List<Orders> getOrders() {
//     return orders;
//   }

//   public void setOrders(List<Orders> orders) {
//     this.orders = orders;
//   }

//   //constructors
//   public OrderBook() {
//     super();
//   }

//   public OrderBook(int orderBookId, List<Orders> orders) {
//     this.orderBookId = orderBookId;
//     this.orders = orders;
//   }

//   public List<Orders> allBuyList = orders.stream().filter(o -> o.getType().equals("buy")).collect(Collectors.toList());

//   public List<Orders> allSellList = orders.stream().filter(o -> o.getType().equals("sell")).collect(Collectors.toList());

//   public void removeOrder(Orders order) {
//     orders.removeIf(o -> o.getOrderId() == order.getOrderId());
// }

// public void updateOrder(Orders order) {
//   for (int i = 0; i < orders.size(); i++) {
//       if (orders.get(i).getOrderId() == order.getOrderId()) {
//           orders.set(i, order);
//           break;
//       }
//   }
// }

//   // toString method
//   public String toString() {
//     return "OrderBook [orderBookId=" + orderBookId + ", orders=" + orders + "]";
//   }

// }
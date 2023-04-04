package com.ab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_statement")
public class OrderStatement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderStatementId;

  @Column(name = "order_type", nullable = false)
  private String type;

  @Column(name = "order_price", nullable = false)
  private double price;

  @Column(name = "order_amount", nullable = false)
  private int amount;

  @Column(name = "order_status", nullable = false)
  private String status;

  @Column(name = "statement_status", nullable = false)
  private String statementStatus;

  public int getOrderStatementId() {
    return orderStatementId;
  }

  public void setOrderStatementId(int orderStatementId) {
    this.orderStatementId = orderStatementId;
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

  public String getStatementStatus() {
    return this.statementStatus;
  }

  public void setStatementStatus(String statementStatus) {
    this.statementStatus = statementStatus;
  }

  // Constructors
  public OrderStatement() {
    super();
  }

  public OrderStatement(int orderStatementId, String type, double price, int amount, String status) {
    super();
    this.orderStatementId = orderStatementId;
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.status = status;
  }
  
  public OrderStatement(int orderStatementId, String type, double price, int amount, String status, String statementStatus) {
    super();
    this.orderStatementId = orderStatementId;
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.status = status;
    this.statementStatus = statementStatus;
  }
  
  // toString method
  public String toString(){
    return "Order [orderId=" + orderStatementId + ", type=" + type + ", price=" + price + ", amount=" + amount + ", status=" + status + ", statementStatus=" + statementStatus + "]";
  }
}


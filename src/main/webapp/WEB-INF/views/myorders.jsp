<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ab.entities.Order"%>
<%@ page import="com.ab.entities.User"%>
<%@ page import="java.util.List" %>

<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Your Orders</title>
</head>

<body>
  <h1>Your Orders </h1>
  <table border="1">
    <thead>
      <tr>
        <th>Order ID</th>
        <th>Order Type</th>
        <th>Order Price</th>
        <th>Order Amount</th>
        <th>Order Status</th>
        <th>Order Date</th>
      </tr>
    </thead>
    <tbody>
      <% User user = (User) session.getAttribute("loggedInUser");
      if (user !=null) {
        List<Order> orders = (List<Order>) request.getAttribute("orders");
        for (Order order : orders) {
        %>
        <tr>
          <td>
            <%=order.getOrderId()%>
          </td>
          <td>
            <%=order.getOrderType()%>
          </td>
          <td>
            <%=order.getOrderPrice()%>
          </td>
          <td>
            <%=order.getOrderAmount()%>
          </td>
          <td>
            <%=order.getOrderStatus()%>
          </td>
          <td>
            <%=order.getOrderDate()%>
          </td>
        </tr>
        <% } } else { %> 
          
          <h1>Please login to view order </h1>
          
        <% } %>

    </tbody>
  </table>
</body>

</html>

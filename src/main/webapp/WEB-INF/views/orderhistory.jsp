<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ page import="java.util.List" %>
    <%@ page import="com.ab.entities.OrderHistory" %>
      <%@ page import="com.ab.entities.User" %>
        <%@ include file="header.jsp" %>

          <!DOCTYPE html>
          <html>

          <head>
            <meta charset="UTF-8">
            <title>Order History</title>
          </head>

          <body>
            <h1>Order History</h1>
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
                  List<OrderHistory> orderHistory = (List<OrderHistory>) request.getAttribute("orderHistory");
                  for (OrderHistory order : orderHistory) {
                  %>
                  <tr>
                    <td>
                      <%=order.getOrderHistoryId()%>
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
                    
                    <h1>Please login to view order history</h1>
                    
                  <% } %>

              </tbody>
            </table>
          </body>

          </html>
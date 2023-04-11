<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ab.entities.Order" %>
<%@ page import="com.ab.entities.User" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Current Orders</title>
</head>
<body>
	<h1>Current Orders</h1>
	<table>
		<thead>
			<tr>
				<th>Order ID</th>
				<th>Username</th>
				<th>Order Type</th>
				<th>Order Price</th>
				<th>Order Amount</th>
				<th>Status</th>
				<th>Order Date</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Order> orders = (List<Order>) request.getAttribute("orders");
				for(Order order : orders) {
			%>
			<tr>
				<td><%=order.getOrderId()%></td>
				<td><%=order.getUser().getUsername()%></td>
				<td><%=order.getOrderType()%></td>
				<td><%=order.getOrderPrice()%></td>
				<td><%=order.getOrderAmount()%></td>
				<td><%=order.getOrderStatus()%></td>
				<td><%=order.getOrderDate()%></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>

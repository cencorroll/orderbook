<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="/css/styles.css"> -->
<meta charset="UTF-8">
<title>Create a new order</title>
</head>
<body>
	<div class="page">
		<h1>Create a new order</h1>
		<div class="form">
			<form method="POST" action="/newOrderProcess">
        <p>
          <label for="orderType">OrderType:</label> 
          <select name="orderType" id="orderType">
            <option value="buy">Buy</option>
            <option value="sell">Sell</option>
          </select>
        </p>
				<p>
					<label for="orderPrice">Initial Price:</label> <input name="orderPrice"
						id="orderPrice" />
				</p>
				<p>
					<label for="orderAmount">Initial Amount:</label> <input name="orderAmount"
						id="orderAmount" />
				</p>
				<input type="submit" value="Create Order" />
			</form>
		</div>
	</div>
</body>
</html>
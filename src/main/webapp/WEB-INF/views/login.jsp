<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="/css/styles.css"> -->
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="page">
		<h1>Login</h1>
		<form action="/loginProcess" method="POST">
			<div>
				<label for="username">Username:</label> <input id="username"
					name="username" required>
			</div>
			<div>
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div>
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
</body>
</html>

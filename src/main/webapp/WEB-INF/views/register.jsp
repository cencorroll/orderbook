<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="/css/styles.css"> -->
<meta charset="UTF-8">
<title>New Account</title>
<title>Create a new account</title>
</head>
<body>
	<div class="page">
		<h1>Create a new account</h1>
		<div class="form">
			<form method="POST" action="/registerProcess">
				<p>
					<label for="username">Username:</label> <input name="username"
						id="username" />
				</p>
				<p>
					<label for="firstName">First Name:</label> <input name="firstName"
						id="firstName" />
				</p>
				<p>
					<label for="lastName">Last Name:</label> <input name="lastName"
						id="lastName" />
				</p>
				<p>
					<label for="email">Email:</label> <input name="email" id="email" />
				</p>
				<p>
					<label for="password">Password:</label> <input name="password"
						id="password" type="password" />
				</p>
				<input type="submit" value="Create Account" />
			</form>
		</div>
	</div>
</body>
</html>
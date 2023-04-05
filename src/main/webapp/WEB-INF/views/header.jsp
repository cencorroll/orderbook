<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ab.entities.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

li {
	display: inline-block;
	margin-right: 10px;
}
</style>
</head>
<body>
	<div class="header">
		<header>
			<nav>
				<ul>
					<%
					User loggedInUser = (User) session.getAttribute("loggedInUser");
					if (loggedInUser == null) {
					%>
					<li><a href="login">
							<button>Login to your Account</button>
					</a></li>
					<li><a href="register">
							<button>Register</button>
					</a></li>
					<%
					} else {
					%>
					<li><a href="/"><button>Home</button></a></li>
					<li><a href="/neworder"><button>Create Order</button></a></li>
					<li>
						<form action="/logout" method="GET">
							<button type="submit">Logout</button>
						</form>
					</li>
					<%
					}
					%>
				</ul>
			</nav>
		</header>
	</div>

</body>
</html>

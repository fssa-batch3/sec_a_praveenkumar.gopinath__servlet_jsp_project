<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>

</style>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./asserts/login.css">
</head>
<body>


	<div class="main" style="height: 580px">
		<div class="login">


			<form action="login" method="post">
				<label>Login</label>
				<% 
       			String errorMessage = (String) request.getAttribute("errorMessage");
    			if (errorMessage != null) { 
				%>
    			<p class='error'><%= errorMessage %></p>
				<% } %>

				<input id="email" type="email" placeholder="Email" autocomplete="off" name="email" />

				<input type="password" id="password" name="password"
					placeholder="Password" />

				<button type="submit">Login</button>
			
				<br /> 
				<a href="register.jsp"style="padding-left: 50px; color: white; text-decoration: none">Don't
					have an account register here</a>
			</form>
		</div>
	</div>
</body>
</html>
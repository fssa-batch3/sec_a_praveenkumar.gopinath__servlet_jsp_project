<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<style>
body {
	font-family: "Lato", sans-serif;
}

.sidepanel {
	width: 0;
	position: fixed;
	z-index: 1;
	height: 250px;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidepanel a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidepanel a:hover {
	color: #f1f1f1;
}

.sidepanel .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
}

.openbtn {
	font-size: 20px;
	cursor: pointer;
	background-color: #111;
	color: white;
	padding: 10px 15px;
	border: none;
}

.openbtn:hover {
	background-color: #444;
}
</style>
</head>
<body>

	<div id="mySidepanel" class="sidepanel">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">X</a>
		<a href="#">Home</a>
		<c:if test="${empty sessionScope.loggedInEmail}">
			<a href="login.jsp">Login</a>
			<a href="register.jsp">Signup</a>
		</c:if>
		<c:if test="${not empty sessionScope.loggedInEmail}">
			<a href="register.jsp">All user</a>
		</c:if>
	</div>

	<button class="openbtn" onclick="openNav()">☰ Menu</button>
	<h2>Collapsed Sidepanel</h2>
	<p>Click on the hamburger menu/bar icon to open the sidepanel.</p>

	<script>
		function openNav() {
			document.getElementById("mySidepanel").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidepanel").style.width = "0";
		}
	</script>

</body>
</html>
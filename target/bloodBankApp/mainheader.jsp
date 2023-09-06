<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
/* The sidebar menu */
#main {
	transition: margin-left .5s;
	padding: 0 0 0;
}

.sidebar {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	padding-top: 60px;
	transition: 0.5s;
}

.sidebar a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidebar a:hover {
	color: #f1f1f1;
}

.sidebar .closebtn {
	position: absolute;
	top: 0;
	right: 5px;
	font-size: 36px;
	margin-left: 40px;
	font-size: 36px;
	cursor: pointer;
}

.openbtn {
width:70px;
	font-size: 20px;
	cursor: pointer;
	background-color: #111;
	color: white;
	padding: 10px 10px;
	border: none;
	border-radius: 13px;
}

.openbtn:hover {
	background-color: #444;
}

.menu {
	background: @color-2nd;
	height: 100vh;
	width: @menu-width-desktop;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 5;
	outline: none;
}

.
avatar {
	background: rgba(0, 0, 0, 0.1);
	color: white;
	padding: 2em 0.5em;
	text-align: center;
}

img {
	width:100%;
	border-radius: 50%;
	overflow: hidden;
	border: 4px solid@color-1st;
	box-shadow: 0 0 0 4px white;
}

.loginUserEmail {
	color: white;
	font-weight: normal;
	margin-bottom: 0;
	margin-left: 1em;
	font-weight: normal;
}

@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="openTheDoor" class="sidebar">
		<header class="avatar">
			<img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgF1_wkZqqigDDvI_5DqbXmXKmNvPUylyklA&usqp=CAU" />
			<h2 class="loginUserEmail">John D.</h2>
		</header>
		<a  class="closebtn" onclick="closeNav()">&times;</a>
		<a href="#">Home</a> <a href="#">Login</a> <a href="#">Registeration</a>
	</div>

	<div id="main">
		<button class="openbtn" onclick="openNav()">&#9776;</button>
	</div>
	
	<!-- script for menu bar  -->
	<script type="text/javascript">
		function openNav() {
			document.getElementById("openTheDoor").style.width = "200px";
			/* document.getElementById("main").style.marginLeft = "0px"; */
		}

		function closeNav() {
			document.getElementById("openTheDoor").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
		}
	</script>
</body>
</html>
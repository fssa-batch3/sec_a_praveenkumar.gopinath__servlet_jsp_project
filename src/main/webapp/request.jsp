<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* Reset some default styles */
body {
    font-family: Arial, Helvetica, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f2f2f2;
}

/* Style the form container */
form {
    max-width: 400px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

/* Style form labels */
label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
}

/* Style form input fields */
input[type="text"],
input[type="date"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}

/* Style the select dropdown */
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}

/* Style the submit button */
button[type="submit"] {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    font-size: 18px;
    cursor: pointer;
}

/* Add some spacing between form elements */
br {
    margin-top: 10px;
}

</style>
</head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Request Form</h1>

<!-- error message function -->


<%
    String e = (String) request.getAttribute("ErrorMessage");
    if (e != null) {
%>
        <span style="color: red;"><%= e %></span>
<%
    }
%>

	<form action="request" method="post">
		
		<label>Title:</label> <input type="text" name="title"
			placeholder="Title" required> </br> 
			<label>Description:</label> 
			<input type="text" name="description" placeholder="Description" required>
			</br> 
			
		<label for="bloodgroup">Blood Group:</label> <select id="bloodgroup"
			name="bloodgroup" required>
			<option value="" disabled selected>Select your blood group</option>
			<option value="A+">A+</option>
			<option value="A-">A-</option>
			<option value="B+">B+</option>
			<option value="B-">B-</option>
			<option value="AB+">AB+</option>
			<option value="AB-">AB-</option>
			<option value="O+">O+</option>
			<option value="O-">O-</option>
			</select><br> <label>Date:</label> <input type="date" name="date"
			placeholder="Date" required> </br>
			 <label>Phone :</label> <input
			type="text" name="phone" placeholder="Phone" required>



		<!-- Other fields here -->
		<button type="submit">Submit</button>
	</form>
</body>
</html>
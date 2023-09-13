<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fssa.savinglives.model.Request" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
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
<style>
        /* Define your CSS styles here */
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
    <title>Request Table</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
    <h1>Request Table</h1>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Blood Group</th>
                <th>Date</th>
               
                <th>Email</th>
            </tr>
            <% List<Request> requestList = (List<Request>) request.getAttribute("requestList");
             if (requestList != null) {
                for (Request req : requestList) {%> 
                <tr>
                    <td><%=req.gettitle()%></td>
                    <td><%=req.getdescription()%></td>
                    <td><%=req.getgroup()%></td>
                    <td><%=req.getdate()%></td>
                    
                    <td><%=req.getemail()%></td>
                     <!-- Add Task Link -->
               

	
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
    
</body>
</html>
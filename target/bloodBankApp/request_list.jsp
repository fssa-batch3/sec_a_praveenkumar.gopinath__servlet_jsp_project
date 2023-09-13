<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display all Tasks</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="error_message.jsp"></jsp:include>
	<table class=" table table-bordered">
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Blood Group</th>
				<th>Date</th>
				<th>Number</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="request" items="${requestList}" varStatus="loop">

				<tr>
					<td><c:out value="${loop.index + 1}" /></td>
					<td><c:out value="${request.title}" /></td>
					
					<!--<td><form name="submitForm" method="POST"
							action="/EditTaskServlet">
							<input type="hidden" name="taskId" value="${task.id}">
							<input type="submit" name="" value="Edit task">
						</form></td>-->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%session.removeAttribute("requestList"); %>
	<!-- <a href="addNewTask"><button>Add New Request</button></a> -->
</body>
</html>
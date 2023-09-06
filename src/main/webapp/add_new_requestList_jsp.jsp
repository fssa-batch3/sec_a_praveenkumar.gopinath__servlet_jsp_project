<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Task</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="error_message.jsp"></jsp:include>
	<h1>Add New Task</h1>
	
 <!-- <form action="addNewTask" method="post">

		<label>Task: </label> <input type="taskName" name="taskName"
			placeholder="Enter task details... "> <br /> <label for="taskStatus">Task
			Status: </label> <select id="taskStatus" name="taskStatus">
			<option value="PENDING">Pending</option>
			<option value="COMPLETED">Completed</option>
			The taskStatus dropdown allows selecting the task status
		</select> <br />
		<button type="submit">Submit</button>
	</form> -->
	
	
	 <div>
        <form action="addNewReq" method="post">
            <div class="form-group">
                <label for="title" >Title:</label>
                <input type="text" id="title" class="form-input" name="title" required placeholder="Enter title... ">
            </div>
            <div>
                <label for="description" >Description:</label>
                <textarea id="description" name="description" required></textarea>
            </div>
            <div>
                <label for="bloodGroup" >Blood Group:</label>
                <select id="bloodGroup" name="bloodGroup" required>
                    <option value="A+">A+</option>
                    <option value="A-">A-</option>
                    <option value="B+">B+</option>
                    <option value="B-">B-</option>
                    <option value="O+">O+</option>
                    <option value="O-">O-</option>
                    <option value="AB+">AB+</option>
                    <option value="AB-">AB-</option>
                </select>
            </div>
            <div>
                <label for="date" class="form-label">Date:</label>
                <input type="date" id="date" class="form-input" name="date" required>
            </div>
            <div>
                <label for="number" >Number:</label>
                <input type="number" id="number" name="number" required>
            </div>
            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>
</body>
</html>
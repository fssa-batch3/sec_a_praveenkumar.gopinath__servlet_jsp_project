package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.service.RequestService;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String bloodgroup = request.getParameter("bloodgroup");
		String date = request.getParameter("date");
		
		String email = (String) session.getAttribute("loggedInEmail");
		
		Long number = Long.parseLong(request.getParameter("phone"));
		
		
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 
		LocalDate date1 = LocalDate.of(2002, 2, 23);
		
		PrintWriter out = response.getWriter();
	
		
		Request user1 = new Request(title, description, bloodgroup, date1, number, email);
		RequestService requestService = new RequestService();

	
			try {
				if (requestService.create(user1)) {
					out.println("Request is valid");
					response.sendRedirect("ListAllRequestsServlet");
				} else {
					out.println("Request is Invalid");
				}
			} catch (DAOException | ServiceException e) {
				// TODO Auto-generated catch block
				out.print(e.getMessage());
				e.printStackTrace();
				
				//i am using error message 
				request.setAttribute("ErrorMessage", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("request.jsp");
				dispatcher.forward(request, response);
		
		} 
		

	}
}

		
		
	
	

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		Connection connection =getConnection();
//		PrintWriter out = response.getWriter();
//
//		try {
//		    String userEmail = (String) session.getAttribute("loggedInEmail");
//		    String sql = "SELECT id FROM user WHERE email = ?";
//		    
//		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		    preparedStatement.setString(1, userEmail);
//
//		    ResultSet resultSet = preparedStatement.executeQuery();
//
//		    String userID = null;
//		    if (resultSet.next()) {
//		        userID = resultSet.getString("id");
//		    } else {
//		        // Handle the case where no matching user was found
//		        throw new Exception("User not found");
//		    }
//		String title = request.getParameter("title");
//		String description = request.getParameter("description");
//		String bloodgroup = request.getParameter("bloodgroup");
//		String date = request.getParameter("date");
//		String email = (String) session.getAttribute("loggedInEmail");
//		
//		Long number = Long.parseLong(request.getParameter("phone"));
//		
//		
//		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		 
//		LocalDate date1 = LocalDate.of(2002, 2, 23);
//	
//		
//		Request user1 = new Request(title, description, bloodgroup, date1, number, email);
//		RequestService requestService = new RequestService();
//
//		try {
//			if (requestService.create(user1)) {
//				out.println("Request is valid");
//				response.sendRedirect("ListAllRequestsServlet");
//			} else {
//				out.println("Request is Invalid");
//			}
//		} catch (ServicesException | DAOException e) {
//			e.printStackTrace();
//		
//		} } catch (Exception e) {
//			out.print(e.getMessage());
//		}
//		
//		
//
//}
//
//	public Connection getConnection() {
//
//		Connection connection = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "123456");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Unable  to connect database", e);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Database driver class not found", e);
//		}
//		return connection;
//	}
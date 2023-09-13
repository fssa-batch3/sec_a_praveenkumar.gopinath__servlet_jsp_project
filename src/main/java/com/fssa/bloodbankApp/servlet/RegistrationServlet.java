package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fssa.savinglives.model.User;
import com.fssa.savinglives.service.UserService;
import com.fssa.savinglives.service.exception.ServiceException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();
		user.setEmail(email);
		user.setUsername(name);
		user.setPassword(password);

		UserService userservice = new UserService();
		try {
			userservice.registerUser(user);
			out.append("Registration Successfully");
			response.sendRedirect("login.jsp");
		} catch (ServiceException e) {
			response.sendRedirect("register.jsp?errorMessage=Register User Failed : " + e.getMessage());
			out.println("Registration failed : " + e.getMessage());
		}

	}
}
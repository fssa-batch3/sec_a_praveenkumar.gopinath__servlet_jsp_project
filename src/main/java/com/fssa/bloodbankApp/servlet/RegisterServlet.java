package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.savinglives.model.User;
import com.fssa.savinglives.service.UserService;
import com.fssa.savinglives.service.exception.ServiceException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user =  new User(name, email, password);
		

		PrintWriter out = response.getWriter();

		UserService registerService = new UserService();
		try {
			if (registerService.registerUser(user)) {
				out.println("Successfully registered!");
				HttpSession session = request.getSession();
				session.setAttribute("loggedInEmail", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
				dispatcher.forward(request, response);
			} else {
				out.println("Registration failed!");
			}
		} catch (ServiceException e) {
			out.println(e.getMessage());
		}
	}

}
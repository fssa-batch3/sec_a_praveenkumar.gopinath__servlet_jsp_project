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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);


		UserService loginservice = new UserService();

		try {
			loginservice.loginUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("loggedInEmail", email);
			response.sendRedirect("GetAllFundrasie");

		} catch (ServiceException e) {
			request.setAttribute("errorMessage", "Login Failed : " + e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
		}

	}
}
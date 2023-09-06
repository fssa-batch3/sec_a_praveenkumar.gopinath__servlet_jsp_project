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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(email, password);

		PrintWriter out = response.getWriter();

		UserService loginService = new UserService();
		try {
			if (loginService.loginUser(user)) {
				out.println("Login successful!");
				HttpSession session = request.getSession();
				session.setAttribute("loggedInEmail", email);
//				request.setAttribute("loggedInEmail", email); // Only the next page or servlet can access the request scope attribute values. 
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("login.jsp?errorMessage=Email is not registered.");
			}
		} catch (ServiceException e) {
			response.sendRedirect("login.jsp?errorMessage=" + e.getMessage());
		}

//		if (email == null || "".equals(email)) {
//			out.println("Invalid Email");
//			response.sendRedirect("login.jsp?errorMessage=Invalid Email");
//		}
//
//		else if (password == null || "".equals(password) || password.length() < 6) {
//			response.sendRedirect("login.jsp?errorMessage=Invalid Password");
//		} else {
//			out.println("Email and password is valid");
//			HttpSession session = request.getSession();
//			session.setAttribute("loggedInEmail", email);
////			request.setAttribute("loggedInEmail", email); // Only the next page or servlet can access the request scope attribute values. 
//			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//			dispatcher.forward(request, response);
//		}

	}

}
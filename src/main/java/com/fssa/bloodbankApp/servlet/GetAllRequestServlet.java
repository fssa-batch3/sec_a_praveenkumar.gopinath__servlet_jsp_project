package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;

/**
 * Servlet implementation class GetAllTasks
 */
@WebServlet("/GetAllRequestServlet")
public class GetAllRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		List<Request> request1 = new ArrayList<>();

		HttpSession session = request.getSession(false);
		String loggedInEmail = (String) session.getAttribute("loggedInEmail");

		if (loggedInEmail != null) {
			RequestService requestService = new RequestService();
			try {
				request1 = RequestService.getRequestsByBloodGroup(loggedInEmail);

				request.setAttribute("requestList", request1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("request_list.jsp");
				dispatcher.forward(request, response);
			} catch (ServiceException | RuntimeException e) {
				e.printStackTrace();
				response.sendRedirect("login.jsp?errorMessage=" + e.getMessage());
			}

		} else {
			response.sendRedirect("login.jsp?errorMessage=Please login before viewing your list.");
		}

	}

}
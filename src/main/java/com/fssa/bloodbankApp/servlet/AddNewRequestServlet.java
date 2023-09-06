package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;

/**
 * Servlet implementation class AddNewTaskServlet
 */
@WebServlet("/addNewRequest")
public class AddNewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add_new_requestList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String bloodGroup = request.getParameter("bloodGroup");
		String date = request.getParameter("date");
		String number = request.getParameter("number");

		HttpSession session = request.getSession(false);
		String loggedInEmail = (String) session.getAttribute("loggedInEmail");

		if (loggedInEmail != null) {
			Request request1 = new Request(title, desc, bloodGroup, date, number);
//			RequestService requestService = new RequestService();
			try {
				RequestService.readRequest(request1);
				List<Request> requests = RequestService.getRequestsByBloodGroup(loggedInEmail);
				request.setAttribute("RequestList", requests);
				RequestDispatcher dispatcher = request.getRequestDispatcher("request_list.jsp");
				dispatcher.forward(request, response);
			} catch (ServiceException e) {
				e.printStackTrace();
				response.sendRedirect("add_new_requestList.jsp?errorMessage=" + e.getMessage());
			}
		} else {
			response.sendRedirect("add_new_requestList.jsp?errorMessage=Please login before adding new request.");
		}
	}
}
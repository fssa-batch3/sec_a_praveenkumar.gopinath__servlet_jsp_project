package com.fssa.bloodbankApp.servlet;

//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fssa.savinglives.model.Request;
//import com.fssa.savinglives.service.RequestService;
//import com.fssa.savinglives.service.exception.ServiceException;

//@WebServlet("/GetAllRequestServlet")
//public class GetAllRequestServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestService fundraiseservice = new RequestService();
// 
//		try {
//			List<Fundraise> fundraises = fundraiseservice.viewFundraisesServices();
//			request.setAttribute("FUNDRAISE_LIST", fundraises);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//			dispatcher.forward(request, response);
//		} catch (ServiceException e) {
//			request.setAttribute("errorMessage", "Error in getting the fundraise: " + e.getMessage());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//			dispatcher.forward(request, response);
//		}
//	}
//
//}
package com.fssa.bloodbankApp.servlet;

import com.fssa.savinglives.dao.RequestDAO;
import com.fssa.savinglives.model.Request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListAllRequestsServlet")
public class RequestAllUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDAO requestDAO = new RequestDAO();
            List<Request> requestList = requestDAO.readrequest(); // Retrieve the list of requests from DAO

            // Set the requestList attribute for the JSP
            request.setAttribute("requestList", requestList);

            // Forward the request to the JSP for rendering
            request.getRequestDispatcher("/requestallUser.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
}
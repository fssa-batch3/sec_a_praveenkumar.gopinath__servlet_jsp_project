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

/**
 * Servlet implementation class ListRequestServlet
 */
@WebServlet("/ListRequestServlet")
public class ListRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String loggedInEmail = (String) session.getAttribute("loggedInEmail");
        PrintWriter out = response.getWriter();
        if (loggedInEmail == null) {
            response.sendRedirect("login.html");
        } else {
            List<Request> requests = new ArrayList<Request>();

            requests.add(new Request("I need O+ blood group", ", ", "O+", "2023-08-06",
                    "9884689632"));
            requests.add(new Request("I need B+ blood group", "thank you for giving blood", "B+", "2023-08-05",
                    "9841747550"));
            requests.add(new Request("I need A+ blood group", "thank you for giving blood", "A+", "2023-08-04",
                    "9025839183"));

            request.setAttribute("requestList", requests);
            RequestDispatcher dispatcher = request.getRequestDispatcher("request_list.jsp");
            dispatcher.forward(request, response);

            out.println("<p>Logged In user: " + loggedInEmail + "</p>");
            out.println("<a href='LogoutServlet'>logout</a>");
        }
    }
}

package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.savinglives.model.Request;

/**
 * Servlet implementation class GetAllTasks
 */
@WebServlet("/GetAllJSONRequestsServlet")
public class GetAllJSONRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Request> requests = new ArrayList<Request> ();
		
		requests.add(new Request("i need O+ blood group", "thank you for giving blood", "O+", "2023-08-05", "9884689632"));
		requests.add(new Request("i need O+ blood group", "thank you for giving blood", "O+", "2023-08-05", "9841747550"));
		requests.add(new Request("i need O+ blood group", "thank you for giving blood", "O+", "2023-08-05","9025839183"));
		JSONArray requestsJSONArray = new JSONArray(request);
		PrintWriter out = response.getWriter();
		out.println(requestsJSONArray.toString());
		out.flush();
	}

}
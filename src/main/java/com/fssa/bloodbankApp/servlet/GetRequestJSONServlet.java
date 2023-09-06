package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.savinglives.model.Request;

import org.json.JSONObject;

/**
 * Servlet implementation class GetAccountJSONServlet
 */
@WebServlet("/GetRequestJSONServlet")
public class GetRequestJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Request request1 = new Request("Convert requests to JSON", "COMPLETED");
		
		JSONObject donorsJson = new JSONObject(request1);
		PrintWriter out = response.getWriter();
		out.println(donorsJson.toString());
		out.flush();
	}

}
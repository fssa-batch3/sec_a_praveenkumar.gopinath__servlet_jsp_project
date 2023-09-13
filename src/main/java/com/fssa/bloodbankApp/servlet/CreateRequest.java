package com.fssa.bloodbankApp.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.*;
import com.fssa.savinglives.service.*;
import com.fssa.savinglives.service.exception.ServiceException;

/**
 * Servlet implementation class CreateRequest
 */
@WebServlet("/CreateRequest")
public class CreateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		LocalDate date = LocalDate.of(2002, 2, 23);
		Request request1 = new Request("title","description","group",date,9884689632L,"praveen1234@gmail.com");
		RequestService RequestService = new RequestService();
		try {
			RequestService .create(request1);
		} catch (ServiceException | DAOException e) {
			e.printStackTrace();
		
		}
		
	
	}
  

}
package com.store.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.service.CustomerServiceImpl;
import com.store.service.ICustomerService;

/**
 * Servlet implementation class DeleteCustomerServlet
 */
//@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String customerID = request.getParameter("customerID");			
		
		ICustomerService iCustomerService = new CustomerServiceImpl();
		iCustomerService.removeCustomer(customerID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/ListCustomers.jsp");
		dispatcher.forward(request, response);
	}

}

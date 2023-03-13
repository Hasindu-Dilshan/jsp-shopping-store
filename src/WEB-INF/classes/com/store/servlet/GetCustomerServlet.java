package com.store.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.model.Customer;
import com.store.service.CustomerServiceImpl;
import com.store.service.ICustomerService;

/**
 * Servlet implementation class GetCustomerServlet
 */
//@WebServlet("/GetCustomerServlet")
public class GetCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCustomerServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

 		String customerID = request.getParameter("customerID");			
		ICustomerService ICustomerService = new CustomerServiceImpl();
		Customer customer = null;
		try {
			customer = ICustomerService.getCustomerByID(customerID);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("customer", customer);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/GetCustomer.jsp");
		dispatcher.forward(request, response);
	}

}

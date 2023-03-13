package com.store.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.model.Customer;
import com.store.service.CustomerServiceImpl;
import com.store.service.ICustomerService;

/**
 * Servlet implementation class CustomerLoginServlet
 */

public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerLoginServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ICustomerService iCustomerService = new CustomerServiceImpl();
		
		Customer customer = iCustomerService.validate(email, password);
		
		if(customer != null) {
			HttpSession session=request.getSession(); 
			session.setAttribute("customerID", customer.getCustomerID());
			session.setAttribute("customerName", customer.getCustomerName());
			response.sendRedirect("homepage.jsp");
			
		}
		else {
			// alert wrong credentials & redirect to login
			
			response.sendRedirect("error.jsp");
			
		}
	}
	
	
}

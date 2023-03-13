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

//@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		ICustomerService iCustomerService = new CustomerServiceImpl();
		

		Customer customer = new Customer();
		
		String customerName = request.getParameter("name");
		
		customerName =iCustomerService.modelCustomerName(customerName);
		
		customer.setCustomerName(customerName);

		customer.setCustomerEmail(request.getParameter("email"));

		customer.setCustomerBirthYear(request.getParameter("birthYear"));
		
		customer.setCustomerGender(request.getParameter("gender"));
		
		customer.setCustomerPassword(request.getParameter("password"));
		
		iCustomerService.addCustomer(customer);
		

		request.setAttribute("customer", customer);
		
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/ListCustomers.jsp");
//		dispatcher.forward(request, response);
		response.sendRedirect("login.jsp");
	}

}

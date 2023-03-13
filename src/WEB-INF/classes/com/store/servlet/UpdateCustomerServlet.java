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
 * Servlet implementation class UpdateCustomerServlet
 */
//@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Customer customer = new Customer();
		
		String customerID = request.getParameter("customerID");	
		customer.setCustomerID(customerID);
		
		customer.setCustomerName(request.getParameter("name"));

		customer.setCustomerEmail(request.getParameter("email"));

		customer.setCustomerBirthYear(request.getParameter("birthYear"));
		
		customer.setCustomerGender(request.getParameter("gender"));
		
		customer.setCustomerPassword(request.getParameter("password"));
		
		ICustomerService iCustomerService = new CustomerServiceImpl();
		iCustomerService.updateCustomer(customerID, customer);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/ListCustomers.jsp");
		dispatcher.forward(request, response);
	}

}

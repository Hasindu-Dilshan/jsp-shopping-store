package com.store.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ListCustomersServlet")
public class ListCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCustomersServlet() {
        super();

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.sendRedirect("views/ListCustomers.jsp");
	}

}

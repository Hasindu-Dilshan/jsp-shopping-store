package com.store.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.service.CartItemServiceImpl;
import com.store.service.ICartItemService;

//@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveFromCartServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productID = Integer.parseInt(request.getParameter("productID"));
		
		ICartItemService iCartItemService = new CartItemServiceImpl();
		
		iCartItemService.removeCartItem(productID);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect("cart.jsp");
	}

}

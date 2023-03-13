package com.store.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.model.Product;
import com.store.service.IProductService;
import com.store.service.ProductServiceImpl;

//@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductDetailsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productID = request.getParameter("productID");
		
		IProductService iProductService = new ProductServiceImpl();
		Product product = iProductService.getProductByID(productID);
		
		request.setAttribute("product", product);
		
//		response.sendRedirect("product_details.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product_details.jsp");
		dispatcher.forward(request, response);
	}

}

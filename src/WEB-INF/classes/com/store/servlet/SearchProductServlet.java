package com.store.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.model.Product;
import com.store.service.IProductService;
import com.store.service.ProductServiceImpl;

//@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchProductServlet() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		
		if(search.equals("")) {
			response.sendRedirect("/shopping-store/homepage.jsp");
		}
		else {
		
			IProductService iProductService = new ProductServiceImpl();
			
			ArrayList<Integer> itemIDs = iProductService.getProductsByTag(search);
			
			ArrayList<Product> productList = new ArrayList<Product>();
			
			for(Integer i : itemIDs) {	
				Product product = iProductService.getProductByID(i.toString());
				
				productList.add(product);
			}
			
			request.setAttribute("searchProducts", productList);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("search", search);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/SearchResultPage.jsp");
			dispatcher.forward(request, response);
		}
	}

}

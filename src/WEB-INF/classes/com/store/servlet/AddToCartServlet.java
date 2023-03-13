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

import com.store.model.CartItem;
import com.store.service.CartItemServiceImpl;
import com.store.service.ICartItemService;


//@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int productID = Integer.parseInt(request.getParameter("productID"));
	
//		make customerID from _SESSION
		String customerID = (String) session.getAttribute("customerID");
		
		boolean itemAvailable = false;
		
		ICartItemService iCartItemService = new CartItemServiceImpl();
		
		ArrayList<CartItem> cartItemList = iCartItemService.getCartItems();
		
		for(CartItem cartItem : cartItemList) {
			if(cartItem.getProductID() == productID && customerID.equals(cartItem.getCustomerID())) {
				itemAvailable = true;
				break;
			}
		}
		
		if(!itemAvailable) {
			CartItem cartItem = new CartItem(productID, customerID);
					
			iCartItemService.addCartItem(cartItem); 
			
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shopping-store/cart.jsp");
//			
//			dispatcher.forward(request, response);
			
			response.sendRedirect("cart.jsp");
		}
		else {
			session.setAttribute("alertAvailable", "true");
			session.setAttribute("getAlert", "Item Already Available");
			
			String previousPage = (String) session.getAttribute("previousPage");
			
			if(previousPage.equals("homepage")) {
				response.sendRedirect("homepage.jsp");
			}

			else if(previousPage.equals("search_page")) {
				response.sendRedirect("SearchProductServlet?search=" + session.getAttribute("search"));
			}

			
		}
		
	}

	

}

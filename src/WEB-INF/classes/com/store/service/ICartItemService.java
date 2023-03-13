package com.store.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.store.model.CartItem;

public interface ICartItemService {
	
	public static final Logger log = Logger.getLogger(ICartItemService.class.getName());
	
	
	public void addCartItem(CartItem cartItem);
	
	public double getDiscountByID(int productID);
	
	public CartItem updateCartItem(String productID, CartItem cartItem);
	
	public void removeCartItem(int productID);

	public ArrayList<CartItem> getCartItems();

	
	public double getTotalPrice(ArrayList<CartItem> cartItemList);
	
	public int getNumberOfItems(ArrayList<CartItem> cartItemList);
	
	public double getTotalSaving(ArrayList<CartItem> cartItemList);
}

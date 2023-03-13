package com.store.model;

public class CartItem extends Product{
	
	private int itemID;
	
	private String customerID;
	
	private int quantity;
	
	private double discountRate;
	
	
	// default constructor
	public CartItem() {
		
	}

	public CartItem(int productID, String customerID) {
		this.productID = productID;
		
		this.customerID = customerID;
		
		quantity = 1; // initial value
		
		discountRate = 0; 
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	
}

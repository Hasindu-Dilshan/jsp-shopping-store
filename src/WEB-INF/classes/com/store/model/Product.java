package com.store.model;

public class Product {
	
	protected int productID; 
	
	protected String title;
	
	protected double price;
	
	private String details;
	
	protected String tag;
	
	protected String thumbLocation;
	
	/* New variables */
	
	private int rating;
	
	private int date;

	// Default Constructor
	public Product() {
		
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getThumbLocation() {
		return thumbLocation;
	}

	public void setThumbLocation(String thumbLocation) {
		this.thumbLocation = thumbLocation;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String toString() {
		return "productID: " +  productID + " title:" + title + " price:" + price + " details: " + details + " tag:" + tag + " thumbLocation:" + thumbLocation + " rating:" + rating + " date:" + date;
	}
}

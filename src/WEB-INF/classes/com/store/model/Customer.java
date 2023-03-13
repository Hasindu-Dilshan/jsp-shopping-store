package com.store.model;

public class Customer {
	private String customerID;
	
	private String customerName;

	private String customerEmail;

	private String customerBirthYear;
	
	private String customerGender;
	
	private String customerPassword;

	// Default constructor
	public Customer() {
		
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerBirthYear() {
		return customerBirthYear;
	}

	public void setCustomerBirthYear(String customerBirthYear) {
		this.customerBirthYear = customerBirthYear;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	
}

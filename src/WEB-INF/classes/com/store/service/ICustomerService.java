package com.store.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.store.model.Customer;

public interface ICustomerService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ICustomerService.class.getName());
	
	public void addCustomer(Customer customer);

	public Customer getCustomerByID(String customerID) throws ClassNotFoundException;
	
	public ArrayList<Customer> getCustomers() throws ClassNotFoundException;

	public Customer updateCustomer(String customerID, Customer customer);

	public void removeCustomer(String customerID);

	public Customer validate(String email, String password);
	
	public String modelCustomerName(String customerName);
	
}

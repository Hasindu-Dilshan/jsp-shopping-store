package com.store.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.store.model.Product;

public interface IProductService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IProductService.class.getName());
	
	public Product getProductByID(String productID);
	
	public ArrayList<Integer> getProductsByTag(String tag);
	
	public ArrayList<Product> getProducts();
	
	
}

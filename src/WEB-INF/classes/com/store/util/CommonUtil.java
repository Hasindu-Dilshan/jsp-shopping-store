package com.store.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.store.service.ICustomerService;
import com.store.service.IProductService;

public class CommonUtil {
	/** Initialize logger */
	public static final Logger log1 = Logger.getLogger(ICustomerService.class.getName());
	public static final Logger log2 = Logger.getLogger(IProductService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log1.log(Level.SEVERE, e.getMessage());
			log2.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Employee ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateIDs(ArrayList<String> arrayList) {
//		String id;
//		int next = arrayList.size();
//		next++;
//		id = CommonConstants.CUSTOMER_ID_PREFIX + next;
//		if (arrayList.contains(id)) {
//			next++;
//			id = CommonConstants.CUSTOMER_ID_PREFIX + next;
//		}
//		return id;
		
		String lastID = arrayList.get(arrayList.size() - 1);
		
		int suffix = Integer.parseInt(lastID.substring(CommonConstants.CUSTOMER_ID_PREFIX.length())) + 1;
		
		String id = CommonConstants.CUSTOMER_ID_PREFIX + Integer.toString(suffix);
		
		return id;
	}
	
	public static int generateItemIDs(ArrayList<String> arrayList) {
		
		int id = Integer.parseInt(arrayList.get(arrayList.size() - 1)) + 1 ;
		
		return id;
		
//		int id;
//		int next = arrayList.size();
//		
//		next++;
//		id =  next;
//		if (arrayList.contains((Object) Integer.toString(id))) {
//			next++;
//			id =  next;
//		}
//		return id;
	}
}

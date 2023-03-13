package com.store.util;

public class CommonConstants {
	
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in SQLQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in SQLQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for customer id prefix */
	public static final String CUSTOMER_ID_PREFIX = "UID";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_customer_table in SQLQuery.xml */
	public static final String QUERY_ID_DROP_CUSTOMER_TABLE = "drop_customer_table";

	/** Constant for query id of drop_product_table in SQLQuery.xml */
	public static final String QUERY_ID_DROP_PRODUCT_TABLE = "drop_product_table";

	/** Constant for query id of create_table in SQLQuery.xml */
	public static final String QUERY_ID_CREATE_CUSTOMER_TABLE = "create_customer_table";

	/** Constant for query id of insert customers in SQLQuery.xml */
	public static final String QUERY_ID_INSERT_CUSTOMERS = "insert_customer";
	
	/** Constant for query id of create_table in SQLQuery.xml */
	public static final String QUERY_ID_CREATE_PRODUCT_TABLE = "create_product_table";

	/** Constant for query id of get an customer in SQLQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER = "customer_by_id";
	
	/** Constant for query id of get an product in SQLQuery.xml */
	public static final String QUERY_ID_GET_PRODUCT = "product_by_id";

	/** Constant for query id of get all customers in SQLQuery.xml */
	public static final String QUERY_ID_ALL_CUSTOMERS = "all_customers";
	
	/** Constant for query id of get all products in SQLQuery.xml */
	public static final String QUERY_ID_ALL_PRODUCTS = "all_products";

	/** Constant for query id of remove a customer in SQLQuery.xml */
	public static final String QUERY_ID_REMOVE_CUSTOMER = "remove_customer";

	/** Constant for query id of update a customer in SQLQuery.xml */
	public static final String QUERY_ID_UPDATE_CUSTOMER = "update_customer";

	/** Constant for query id of get all customer ids in SQLQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER_IDS = "customer_ids";
	
	/** Constant for query id of get discount in SQLQuery.xml */
	public static final String QUERY_ID_GET_DISCOUNT = "discount_by_id";
	
	/** Constant file path to product thumbnails */
	public static final String  PRODUCT_THUMBNAIL_PATH = "img/";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;

	/** Whether to recreate tables on startup */
	public static final boolean RECREATE_TABLES = false;

	public static final String QUERY_ID_ALL_ITEMS = "all_cart_items";

	public static final String QUERY_ID_INSERT_CART_ITEMS = "insert_cart_item";

	public static final String QUERY_ID_GET_ITEM_IDS = "item_ids";
	
	public static final String QUERY_ID_REMOVE_ITEM = "remove_item";

	public static final String QUERY_TAG_PRODUCTS = "product_by_tag";

}

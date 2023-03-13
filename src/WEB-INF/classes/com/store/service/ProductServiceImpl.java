package com.store.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.store.model.Product;
import com.store.util.CommonConstants;
import com.store.util.DBConnectionUtil;
import com.store.util.QueryUtil;

public class ProductServiceImpl implements IProductService {
	
	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createProductTable();
	}

	private PreparedStatement preparedStatement;
	
	public static void createProductTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			statement = connection.createStatement();
			
			if(CommonConstants.RECREATE_TABLES) {
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PRODUCT_TABLE));
				
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_PRODUCT_TABLE));
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public Product getProductByID(String productID) {
		
		return actionOnProduct(productID).get(0);
	}
	
	public ArrayList<Product> getProducts() {
		
		return actionOnProduct(null);
	}
	
	private ArrayList<Product> actionOnProduct(String productID) {

		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (productID != null && !productID.isEmpty()) {
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PRODUCT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, productID);
			}
			
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_PRODUCTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Product product = new Product();
				
				product.setProductID(Integer.parseInt(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE)));
				product.setTitle(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				product.setPrice(Double.parseDouble(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE)));
				product.setDetails(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				product.setTag(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				product.setThumbLocation(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				product.setRating(Integer.parseInt(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN)));
				
				productList.add(product);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return productList;
	}

	@Override
	public ArrayList<Integer> getProductsByTag(String tag) {
		
		ArrayList<Integer> productIDList = new ArrayList<Integer>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_TAG_PRODUCTS));
			
			preparedStatement.setString(1, tag);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				
				productIDList.add(id);
			}
	
			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			
			
		}
		return productIDList;
	}
	
}

package com.store.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.store.model.CartItem;
import com.store.util.CommonConstants;
import com.store.util.CommonUtil;
import com.store.util.DBConnectionUtil;
import com.store.util.QueryUtil;

public class CartItemServiceImpl implements ICartItemService{
	
	public static final Logger log = Logger.getLogger(CartItemServiceImpl.class.getName());
	
	private static Connection connection;
	private PreparedStatement preparedStatement;
	

	@Override
	public double getDiscountByID(int productID) {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_DISCOUNT));
			
			connection.setAutoCommit(false);
			
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, productID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			
			double discount = resultSet.getDouble(CommonConstants.COLUMN_INDEX_ONE);
			
			return discount;
		}
		catch(Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
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
		
		return 0;
		
	}

	@Override
	public CartItem updateCartItem(String productID, CartItem cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(int itemID) {			
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));
			
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, itemID);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end
			 * of transaction
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
	}

	@Override
	public ArrayList<CartItem> getCartItems() {
		ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();
			
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ITEMS));
			connection.setAutoCommit(false);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				CartItem cartItem = new CartItem();
				
//				String customerID = resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE);
				
//				if(custommerID == session(get_user_id))
				
				cartItem.setItemID(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
				cartItem.setProductID(resultSet.getInt(CommonConstants.COLUMN_INDEX_TWO));
				cartItem.setTitle(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				cartItem.setPrice(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				cartItem.setThumbLocation(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				cartItem.setCustomerID(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				cartItem.setQuantity(resultSet.getInt(CommonConstants.COLUMN_INDEX_SEVEN));
				cartItem.setDiscountRate(resultSet.getInt(CommonConstants.COLUMN_INDEX_EIGHT));
				
				cartItemList.add(cartItem);
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
		return cartItemList;
	}

	@Override
	public void addCartItem(CartItem cartItem) {
//		int cartItemID = CommonUtil.generateItemIDs(getItemIDs());
		int cartItemID = CommonUtil.generateItemIDs(getItemIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CART_ITEMS));
			connection.setAutoCommit(false);
			
			cartItem.setItemID(cartItemID);
			
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, cartItem.getItemID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cartItem.getCustomerID());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, cartItem.getQuantity());	
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, cartItem.getProductID());
			
			// Add item
			preparedStatement.execute();
			connection.commit();

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
		
	}

	private ArrayList<String> getItemIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_IDS));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
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
		
		return arrayList;
	}

	@Override
	public double getTotalPrice(ArrayList<CartItem> cartItemList) {
		double totalPrice = 0;
		
		for(CartItem cartItem : cartItemList) {
			totalPrice += cartItem.getPrice() * cartItem.getQuantity();
		}

		return totalPrice;
	}

	@Override
	public int getNumberOfItems(ArrayList<CartItem> cartItemList) {

		return cartItemList.size();
	}

	@Override
	public double getTotalSaving(ArrayList<CartItem> cartItemList) {
		double totalSavings = 0;
		
		for(CartItem cartItem : cartItemList) {
			double discountPerItem =  ((cartItem.getPrice() * cartItem.getDiscountRate()) / 100.0);
			
			totalSavings += discountPerItem * cartItem.getQuantity();
		}

		return totalSavings;
	}

}

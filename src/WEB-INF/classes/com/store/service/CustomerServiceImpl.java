package com.store.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.store.model.Customer;
import com.store.util.CommonConstants;
import com.store.util.CommonUtil;
import com.store.util.DBConnectionUtil;
import com.store.util.QueryUtil;

public class CustomerServiceImpl implements ICustomerService{
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createCustomerTable();
	}

	private PreparedStatement preparedStatement;
	
	public static void createCustomerTable() {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			if(CommonConstants.RECREATE_TABLES) {
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CUSTOMER_TABLE));
			
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CUSTOMER_TABLE));
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		String customerID = CommonUtil.generateIDs(getCustomerIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CUSTOMERS));
			connection.setAutoCommit(false);
			
			//Generate employee IDs
			customer.setCustomerID(customerID);
			
			switch(customer.getCustomerGender()) {
			case "option1" : customer.setCustomerGender("none");
				break;
			case "option2" : customer.setCustomerGender("male");
				break;
			case "option3" : customer.setCustomerGender("female");
				break;
			}
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customer.getCustomerID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, customer.getCustomerName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, customer.getCustomerEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, customer.getCustomerBirthYear());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, customer.getCustomerGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, customer.getCustomerPassword());
			
			// Add employee
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

	@Override
	public Customer getCustomerByID(String customerID) throws ClassNotFoundException {
		
		return actionOnCustomer(customerID).get(0);
	}

	@Override
	public ArrayList<Customer> getCustomers() throws ClassNotFoundException {
		// 
		return actionOnCustomer(null);
	}

	@Override
	public Customer updateCustomer(String customerID, Customer customer) {
		if (customerID != null && !customerID.isEmpty()) {
			/*
			 * Update employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CUSTOMER));
				
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customer.getCustomerName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, customer.getCustomerEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, customer.getCustomerBirthYear());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, customer.getCustomerGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, customer.getCustomerPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, customer.getCustomerID());
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
		
		try {
			return getCustomerByID(customerID);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void removeCustomer(String customerID) {

		if (customerID != null && !customerID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customerID);
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
		
	}
	
	private ArrayList<Customer> actionOnCustomer(String customerID) throws ClassNotFoundException {
		
		

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (customerID != null && !customerID.isEmpty()) {
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customerID);
			}
			
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CUSTOMERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Customer customer = new Customer();
				
				customer.setCustomerID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				customer.setCustomerName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				customer.setCustomerEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				customer.setCustomerBirthYear(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				customer.setCustomerGender(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				customer.setCustomerPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				
				customerList.add(customer);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
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
		return customerList;
	}
	
	private ArrayList<String> getCustomerIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_IDS));
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
	public Customer validate(String email, String password) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		try {
			customerList = getCustomers();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Customer customer : customerList) {
			if(customer.getCustomerEmail().equals(email) && customer.getCustomerPassword().equals(password)) {
				return customer;
			}
		}
		
		return null;
	}
	
	public String modelCustomerName(String customerName) {
		char nameChars[] = customerName.toCharArray();
		
		boolean foundSpace = true;
		
		for(int index = 0; index < nameChars.length; index++) {
			// if the array element is a letter
		      if(Character.isLetter(nameChars[index])) {

		        // check space is present before the letter
		        if(foundSpace) {

		          // change the letter into uppercase
		        	nameChars[index] = Character.toUpperCase(nameChars[index]);
		          foundSpace = false;
		        }
		      }

		      else {
		        // if the new character is not character
		        foundSpace = true;
		      }
		}
		
		return customerName;
		
	}
	
}

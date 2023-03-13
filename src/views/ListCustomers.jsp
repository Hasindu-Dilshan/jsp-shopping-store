<%@ page import="com.store.model.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.store.service.CustomerServiceImpl"%>
<%@ page import="com.store.service.ICustomerService"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Store</title>
</head>
<body>
	<h3>List of Customers</h3>
	Online Shopping Store for OOP Project
	<br>
	<br>
	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of Customer</h2></caption>
		 <a href="/shopping-store/signup.jsp">Add Customer</a>
		  <tr>
               <th>Customer ID</th>
               <th>Customer Name</th>
               <th>Customer Email</th>
               <th>Customer Birth Year</th>
               <th>Customer Gender</th>
               <th>Customer Password</th>
               <th>Select</th>
           </tr>
            <%
            ICustomerService iCustomerService = new CustomerServiceImpl();
	        ArrayList<Customer> arrayList = iCustomerService.getCustomers();
            	           	
            for(Customer customer : arrayList){
            %>
			 <tr>
				<td>  <%=customer.getCustomerID() %>  </td>
				<td>  <%=customer.getCustomerName() %>  </td>
				<td>  <%=customer.getCustomerEmail() %>  </td>
				<td>  <%=customer.getCustomerBirthYear() %>  </td>
				<td>  <%=customer.getCustomerGender( )%>  </td>
				<td>  <%=customer.getCustomerPassword() %>  </td>
				<td> 
				
				<form method="post" action="/shopping-store/GetCustomerServlet">
					<input type="hidden" name="customerID" value="<%=customer.getCustomerID()%>"/>
					<input type="submit" value= "Select Employee" class="select-button" /> 
				</form>
				
				 </td>	
				</tr>
			<%	
			   }
            %>
		</table>
		</div>
		
</body>
</html>
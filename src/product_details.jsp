<%@ page import="com.store.service.IProductService" %>
<%@ page import="com.store.service.ProductServiceImpl" %>
<%@ page import="com.store.model.Product" %>
<%@ page import="com.store.util.CommonConstants" %>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

  <title>Document</title>


</head>
<body>

	<div align="left">
		<table border="1" cellpadding="12">
		  <tr>
               <th>Product ID</th>
               <th>Product view</th>
               <th>Product title</th>   
               <th>Product price</th>
               <th>Product Details</th>
               <th>Product Tag</th>
               <th>Product Rating</th>
               <th>Quantity</th>
               <th>Add to cart</th>
           </tr>
            <%
	            Product product = (Product) request.getAttribute("product");
	            
            %>
	 		<tr>
				<td> <%=product.getProductID() %> </td>
				<td> <img src="<%=CommonConstants.PRODUCT_THUMBNAIL_PATH %><%=product.getThumbLocation() %>" alt="<%=product.getThumbLocation() %>"> </td>
				<td> <%=product.getTitle() %> </td>
				<td> <%=product.getPrice() %> </td>
				<td> <%=product.getDetails() %></td>
				<td> <%=product.getTag() %></td>
				<td> <%=product.getRating() %></td>
				
				<form method="get" action="AddToCartServlet">
					<td>
						<input type="number" name="quantity" value="quantity">
					</td>
					<td>
						<!-- Pass user -->
						<input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
						<input type="submit" value= "Add To Cart" class="select-button" />
						
					</td> 
				</form>
			 	
			</tr>    
		</table>
	</div>
</body>
</html>



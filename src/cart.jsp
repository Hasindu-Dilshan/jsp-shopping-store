<%@ page import="com.store.model.CartItem" %>
<%@ page import="com.store.service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.store.util.CommonConstants" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/homepage.js"></script>
</head>

<%

	String customerID = (String) session.getAttribute("customerID");
	String previousPage = (String) session.getAttribute("previousPage");
	
	if(previousPage.equals("homepage")) {
		previousPage = "homepage.jsp";
	}

	else if(previousPage.equals("search_page")) {
		previousPage = "SearchProductServlet";
	}

	else {
		System.out.println("<previousPage> = " + previousPage);
	}
	
%>

<body>
	<form method="get" action="<%=previousPage%>">
		<input type="hidden" name="search" value="<%=(String) session.getAttribute("search") %>">
		<input type="submit" value="Go Back" onclick="javascript:window.location='<%=previousPage%>'">
	</form>
	
	<table border=1>
		<tr>
				<th>Thumbnail</th>
				<th>Title</th>
				<th>Price</th>
				<th>Discount %</th>
				<th>Quantity</th>
				<th>Remove</th>
		</tr>
		
		<%
			ICartItemService iCartItemService = new CartItemServiceImpl();
			ArrayList<CartItem> cartItemList = iCartItemService.getCartItems();
			
			// remove items not related to the session user
			for(int index = 0; index < cartItemList.size(); index++) {
				if(!customerID.equals( cartItemList.get(index).getCustomerID())) {
					cartItemList.remove(index);
					index--;
				}
			}
					
		%>
		
		<%
			for(CartItem cartItem : cartItemList) {
		%>

		<tr>
			<td> <img src="<%=CommonConstants.PRODUCT_THUMBNAIL_PATH %><%=cartItem.getThumbLocation() %>" alt="<%=cartItem.getThumbLocation() %>"> </td>
			<td> <%=cartItem.getTitle() %> </td>
			<td> <%=cartItem.getPrice() %> </td>
			<td> <%=cartItem.getDiscountRate() %> </td>
			<td><input type="number" id="<%cartItem.getItemID();%>" "name="quantity" value="<%=cartItem.getQuantity()%>" min="1" max="5"></td>
			<%-- <td> <input type="text" name="quantity" value="<%=cartItem.getQuantity()%>"> </td> --%>
			<td> 
			<form method="get" action="RemoveFromCartServlet">
				<input type="hidden" name="productID" value="<%=cartItem.getProductID()%>"/>
				<input type="submit" value="Remove"> 
				
			</form>
			
			</td>
		</tr>
		
		
		<%
		
			}
		%>
		
	</table >
	
	<br><br>
		
	<table border=1>
		<tr>
			<th>Total Price</th>
			<th>Number of Items</th>
			<th>You Save</th>
		</tr>
		
		<tr>
			<td><%=iCartItemService.getTotalPrice(cartItemList)%></td>
			<td><%=iCartItemService.getNumberOfItems(cartItemList) %></td>
			<td><%=iCartItemService.getTotalSaving(cartItemList) %></td>
		</tr>
	</table>
</body>


<script>
function preventBack() {
    window.history.forward();
}
 window.onunload = function() {
    null;
};
setTimeout("preventBack()", 0);
</script>

</html>
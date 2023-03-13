<%@ page import="com.store.model.Customer" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	
		<h2 class="h2">Get Customer Page</h2>
		
		<br>
		<br>
		<%
			Customer customer = (Customer) request.getAttribute("customer");
		%>
	
		<form method="POST" action="/shopping-store/UpdateCustomerServlet">
			<table>
				<tr>
					<td>Customer ID</td>
					<td><input type="text" name="customerID" disabled="disabled"
						value="<%=customer.getCustomerID()%>" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"
						value="<%=customer.getCustomerName()%>" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"
						value="<%=customer.getCustomerEmail()%>" /></td>
				</tr>
				<tr>
					<td>Birth Year</td>
					<td><input type="text" name="birthYear"
						value="<%=customer.getCustomerBirthYear()%>" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender"
						value="<%=customer.getCustomerGender()%>" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"
						value="<%=customer.getCustomerPassword()%>" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="hidden" name="customerID"
						value="<%=customer.getCustomerID()%>" /> <input type="submit"
						value="Update Customer" class="update-button"/>
					</td>
				</tr>
			</table>
		</form>
	
		<table>
			<tr>
				<td colspan="2">
					<form method="POST" action="/shopping-store/DeleteCustomerServlet">
						<input type="hidden" name="customerID"
							value="<%=customer.getCustomerID()%>" /> <input type="submit"
							value="Delete Customer" class="delete-button"/>
					</form>
				</td>
			</tr>
		</table>
	
		<%-- <jsp:include page="footer.jsp"></jsp:include> --%>

</body>
</html>
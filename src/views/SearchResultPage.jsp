<%@ page import="java.util.ArrayList" %>
<%@ page import="com.store.model.Product" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<script type="text/javascript">
		var alertAvailable = '<%=session.getAttribute("alertAvailable")%>';
		var Msg = '<%=session.getAttribute("getAlert")%>';
		
		 if (alertAvailable == "true") {
		   	alert(Msg);
		   	<%session.setAttribute("alertAvailable", "false");%>
		 }
	</script> 
	
    <%

    	String thisPage = "search_page";
    
    	session.setAttribute("previousPage", thisPage);
    
		String disabled = "disabled";
	
		if(session.getAttribute("customerID") != null) {
			String customerID = (String) session.getAttribute("customerID");
			disabled = "";
		} 
	
	%>
    
    <%
    	ArrayList<Product> productList = new ArrayList<Product>();
    	productList = (ArrayList<Product>) request.getAttribute("searchProducts");
    %>
    

<jsp:include page="header.jsp"/>

	<div class="row">
	<%
		for(Product product : productList) {
	%>
	
		
		
		<div class="col-md-3">
                <div class="card border-0" style="width: 15rem; ">
                    <img class="card-img-top card-img" src="img/<%=product.getThumbLocation() %>" alt="Card image cap" >
                    <div class="card-body">
                        <h5 class="card-title"><%=product.getTitle() %></h5>
                        <!-- <p class="card-text">Intel i7 9750H <br>GTX 1660 Ti  <br>512GB SSD <br> 16GB</p> -->
                        <div class="mt-3 d-flex justify-content-between">
                           	<form method="get" action="BuyNowServlet">
								<input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
								<input class="btn btn-primary" type="submit" value= "Buy Now" class="select-button" <%=disabled %>/> 
							</form>
						
							<form method="get" action="AddToCartServlet">
								<input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
								<input class="btn btn-primary" type="submit" value= "Add To Cart" class="select-button"  <%=disabled %>/> 
							</form>
                            <!-- <a href="#" class="btn btn-primary">Add to cart</a>
                            <a href="#" class="btn btn-primary">Buy Now</a> -->
                        </div>
                    
                    </div>
                </div>
            </div>
		
		
	
	<%
			}
	/*
		} 
		else {
			System.out.println("<productList>@SearchResultPage is null");
		}
		 */
	%>
	
	</div>
	
	<jsp:include page="footer.jsp"/>
	

</body>

<script src="js/homepage.js">
</script>
</html>
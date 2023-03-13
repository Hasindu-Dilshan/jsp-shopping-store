<%@ page import="com.store.service.IProductService" %>
<%@ page import="com.store.service.ProductServiceImpl" %>
<%@ page import="com.store.model.Product" %>
<%@ page import="java.util.ArrayList"%>

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
        
		IProductService  iProductService = new ProductServiceImpl();
        ArrayList<Product> trendingItemList = iProductService.getProducts();
        
        ArrayList<Product> newItemList = iProductService.getProducts();
        
        if(newItemList.size() > 0) {
        	trendingItemList.add(trendingItemList.get(0));
            newItemList.add(trendingItemList.get(0));
        }
        else {
        	response.sendRedirect("error.jsp");
        }
        
    %> 
    
    
    
    <%
	    
    	int max_items = 4;
	    
	    String thisPage = "homepage";
	    
	    session.setAttribute("search", "");
	    
	    session.setAttribute("previousPage", thisPage);
		
		String disabled = "disabled";
		
		session.setAttribute("disabled", disabled);
	
		if(session.getAttribute("customerID") != null) {
			String customerID = (String) session.getAttribute("customerID");
			disabled = "";
			
			session.setAttribute("disabled", disabled);
		}
	
	%>
	
	 <jsp:include page="views/header.jsp"/>
    
   
        <div class="card-header my-3" style="font-weight: bold; font-size: 1.5em;">Trending Items</div>

        <div class="row">
        	<%	
        		int counter = 1;
	            for(Product product : newItemList){
	            	if(counter <= max_items) {
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
								<input type="hidden" name="previousPage" value="<%=thisPage %>"/>
								<input class="btn btn-primary" type="submit" value= "Add To Cart" class="select-button" <%=disabled %>/> 
							</form>
                            <!-- <a href="#" class="btn btn-primary">Add to cart</a>
                            <a href="#" class="btn btn-primary">Buy Now</a> -->
                        </div>
                    
                    </div>
                </div>
            </div>
            <%
            		counter++;
	            	}
	            }
            %>
        </div>


        <div class="card-header my-3" style="font-weight: bold; font-size: 1.5em;">New Items</div>
        
        <div class="row">
        	<%	         
        		counter = 1;
	            for(Product product : newItemList){
	            	if(counter <= max_items) {
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
							<input type="submit" class="btn btn-primary" value= "Buy Now" class="select-button" <%=disabled %>/> 
						</form>
						
						<form method="get" action="AddToCartServlet">
							<input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
							<input type="hidden" name="previousPage" value="<%=thisPage %>"/>
							<input type="submit" class="btn btn-primary" value= "Add To Cart" class="select-button" <%=disabled %>/> 
						</form>
						
						
                            <!-- a href="#" class="btn btn-primary">Add to cart</a>
                            <a href="#" class="btn btn-primary">Buy Now</a> -->
                        </div>
                    
                    </div>
                </div>

                
            </div>
            
            <%
            		counter++;
	            	}
	            }
            %>
        </div>
    
   
     <jsp:include page="views/footer.jsp"/>
   

	<script src="js/homepage.js"></script>
</html>
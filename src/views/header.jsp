<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"> 
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet"/>

<style>
        #search {
            width: 150%;
            margin-left: 70%;
        }

        #search_btn {
            position: absolute; 
            margin-left: 23%;
        }
        
        #logout_btn {
   	       	
            position: absolute; 
            margin-left: 40%;
        }

        #dropdown-All_Categories {
            position:absolute;
            margin-left: 20%;
        }

        .card-img{
            width: 100%!important;
            height: 200px!important;
            object-fit: cover;
        }
        
        .cart{background-color: #ffc107; border-color: #ffc107;}
</style>

<%

	String disabled = "disabled";

	String customerID = "";

	String customerName = "";

	String btnLogInOut = "";
	
	String search = "";
	
	if(session.getAttribute("search") != null) {
		search = (String) session.getAttribute("search");
	}

	if(session.getAttribute("customerID") != null) {
		customerID = (String) session.getAttribute("customerID");
		customerName = (String) session.getAttribute("customerName");
		disabled = "";
	}
	
	if(disabled.equals("disabled")) { // if not logged in
		btnLogInOut = "<a href=" + request.getContextPath() + "/login.jsp ><button type='button' class='btn btn-primary' id='logout_btn'> Login </button></a>";
	}
	else {
		btnLogInOut = "<a href='" + request.getContextPath() + "/LogOutServlet'>" +  "<button type='button' class='btn btn-primary' id='logout_btn'" + "> Logout </button></a>";
	}
	
%>
        
<body>
	<div class="container">
	 <nav class="navbar navbar-expand-lg navbar-light bg-light">

	    <a class="navbar-brand" href="/shopping-store/homepage.jsp">
	      <img src="img/logo.jpeg" alt="" width="140%" height="38vh" class="d-inline-block align-text-top">
	      
	    </a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
        <div style="margin-left: 10%;">
                <% if(!customerName.equals("")) { %>
                
                	Hi <%=customerName %>
                	
                <%
                	} 
                %>
        </div>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form class="form-inline my-2 my-lg-0" method="get" action="SearchProductServlet">
               <div style="display: inline-flex;">
                    <div>
                    
                        <input class="form-control mr-sm-1" type="search" placeholder="&#xF002;&nbsp; Search" style="font-family:Arial, FontAwesome" aria-label="Search" name="search" id="search" value=<%=search %> >
                        
                    </div>
                
                    <div>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="search_btn">Search</button>
                    </div>
                    
                    <div>
                    	<%=btnLogInOut %>
					</div>
                </div>
            </form>
            
            <!-- View Cart Button  -->
   			<button style="margin-left: 68%;"class="btn cart" type="button" id="cart" onclick="javascript:window.location='/shopping-store/cart.jsp'" <%=disabled %>>Cart <i class="fa fa-shopping-cart"></i></button>
   		
        </div>  
        
   		
    </nav>
    
    <br>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<style>
    .gradient-custom {
    /* fallback for old browsers */
    background: #f8f9fa;

    /* Chrome 10-25, Safari 5.1-6 */
    /* background: -webkit-linear-gradient(to bottom right, rgba(240, 147, 251, 1), rgba(245, 87, 108, 1)); */

    /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
    /* background: linear-gradient(to bottom right, rgba(240, 147, 251, 1), rgba(245, 87, 108, 1)) */
    }

    .card-registration .select-input.form-control[readonly]:not([disabled]) {
    font-size: 1rem;
    line-height: 2.15;
    padding-left: .75em;
    padding-right: .75em;
    }
    .card-registration .select-arrow {
    top: 13px;
    }
</style>
</head>


<body>
	<%
	
		if(session.getAttribute("customerID") != null) {
			String customerID = (String) session.getAttribute("customerID");
			
	%>
	
	<h1> Customer is already logged in</h1>
	
	<%
		} else {
			
		
	%>
	
	<section class="vh-100 gradient-custom">
	 <div class="container py-5 h-100">
	   <div class="row justify-content-center align-items-center h-100">
	     <div class="col-12 col-lg-9 col-xl-7">
	       <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
	         <div class="card-body p-4 p-md-5">
	           <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
	           <!-- <form name="signup" method="post" action="AddCustomerServlet" onSubmit="return formValidation();"> -->
	           <form name="login" method="post" action="CustomerLoginServlet" onSubmit="return formValidation();" autocomplete="off">
	              <div class="row">
	                
	                <div class="col-md-6 mb-4">
	
	                  <div class="form-outline">
	                    <input type="email" id="lastName" placeholder="Enter email here" class="form-control form-control-lg" name="email" value="a@gmail.com" />
	                    <label class="form-label" for="lastName">Email</label>
	                  </div>
	
	                </div>
	              </div>
	
	              
	              
	              
	              <div class="row">
	                <div class="col-md-6 mb-4 pb-2">
	
	                  <div class="form-outline">
	                    <input type="password" id="password" placeholder="Enter your password here" class="form-control form-control-lg" name="password" value="asd"/>
	                    <label class="form-label" for="password">Password</label>
	                  </div>
	
	                </div>
	
	              </div>
			
				  <div class="mt-3 d-flex justify-content-between">
		              <div class="mt-1 pt-2">
		                <input class="btn btn-primary btn-lg" type="submit" value="Login" />
		              </div>
		              
		              <div class="mt-1 pt-2">
		                <a href="signup.jsp"> <input class="btn btn-primary btn-lg" type="button" value="Create account" /> </a>
		              </div>
	              </div>
	              
	              <br>
	              
	               <div class="row">
	                <div class="col-md-6 mb-4 pb-2">
	
	                  <div class="form-outline">
	                  	<a href="homepage.jsp"> <input class="btn btn-primary btn-lg" type="button" value="Goto Home" /> </a>
	                  </div>
	
	                </div>
	
	              </div>
	
	            </form>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>

	<!-- <form method="post" action="CustomerLoginServlet">
		<input type="email" name="email" placeholder="Enter email here" value="a@gmail.com">
		<input type="password" placeholder="Enter your password here" name="password" value="asd" >
		
		<input type="submit" value="login">
	</form> -->
	
	<%
		}
	%>
</body>

<script src="js/login.js">
</script>
</html>
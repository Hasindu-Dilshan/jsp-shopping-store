
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
	
<meta charset="UTF-8">
<title>Online shopping store</title>

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
<body class="body">

<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
            <!-- <form name="signup" method="post" action="AddCustomerServlet" onSubmit="return formValidation();"> -->
            <form name="signup" method="post" action="AddCustomerServlet" onSubmit="return formValidation();" autocomplete="off">
              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <input type="text" id="firstName" class="form-control form-control-lg" name="name" value="asdfg"/>
                    <label class="form-label" for="firstName">Name</label>
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <input type="email" id="lastName" class="form-control form-control-lg" name="email" value="a@gmail.com" />
                    <label class="form-label" for="lastName">Email</label>
                  </div>

                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 d-flex align-items-center">

                  <div class="form-outline datepicker w-100">
                    <input type="number" class="form-control form-control-lg" id="birthdayDate" name="birthYear" value="2000"/>
                    <label for="birthdayDate" class="form-label">Year of Birth</label>
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <h6 class="mb-2 pb-1">Gender: </h6>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                      value="option1" checked />
                    <label class="form-check-label" for="femaleGender">Rather Not Mention</label>
                  </div>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="maleGender"
                      value="option2" />
                    <label class="form-check-label" for="maleGender">Male</label>
                  </div>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="otherGender"
                      value="option3" />
                    <label class="form-check-label" for="otherGender">Other</label>
                  </div>

                </div>
              </div>
              
              <div class="row">
                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                    <input type="password" id="password" class="form-control form-control-lg" name="password"/>
                    <label class="form-label" for="password">Password</label>
                  </div>

                </div>

                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                    <input type="password" id="passwordConfirmation" class="form-control form-control-lg" name="passwordConfirmation"/>
                    <label class="form-label" for="passwordConfirmation">Confirm Password</label>
                  </div>

                </div>
              </div>

              <div class="mt-1 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Signup" />
              </div>

            </form>
            <br>
			<div class="row">
			   <div class="col-md-6 mb-4 pb-2">
			
			     <div class="form-outline">
			     	<a href="homepage.jsp"> <input class="btn btn-primary btn-lg" type="button" value="Goto Home" /> </a>
			     </div>
			
			   </div>
			
			</div>
          </div>
          
          
        </div>
      </div>
    </div>
  </div>
</section>


</body>

<script src="js/signup.js">
</script>
</html>
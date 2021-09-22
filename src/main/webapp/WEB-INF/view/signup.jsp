<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Genzest">
	<meta name="author" content="Genzest">
	

	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

	<title>Genzest</title>

	<link href="assets/css/app.css" rel="stylesheet">

	<link href="assets/css/style.css" rel="stylesheet">
	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Lato:wght@100;400&display=swap" rel="stylesheet">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">

<style>
.log{
	    background: #17171e;
	    width: 100%;
	    border-radius: 12px;
	    padding:26px;
	}
	label{
		color:#fff;
	}
	button{
		padding: 9px;
	    border: none;
	    background: #F15336;
	    width: 100px;
	    color: #fff;
	    border-radius: 3px;
	    font-weight:bold;
	    margin-top:20px;
	}
	#signupForm h4{
		margin-bottom:30px;
		font-weight:bold;
	}
	.navbar .btn-three {
		width:105px;
	}
</style>
</head>

<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a href="index.html"><img src="assets/img/icons/Genzest Logo.png" alt="" class="img-responsive logo"></a></a>


				<ul class="sidebar-nav">
				<br>
					<li class="sidebar-item active">
					<a class="sidebar-link" href="index.html"><i class="align-middle" data-feather="home"></i> <span class="align-middle"><b>Dashboard</b></span>
            		</a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="https://genzest.com/about-us.html"><i class="fa fa-rocket align-middle" style="font-size:21px"></i> <span class="align-middle"><b>About Us</b></span>
                    </a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="https://genzest.com/business.html"><i class='fa fa-archive align-middle' style='font-size:19px'></i> <span class="align-middle"><b>Business</b></span>
                    </a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="https://genzest.com/contact.html"><i class='fa fa-envelope-o align-middle' style='font-size:19px'></i> <span class="align-middle"><b>Contact Us</b></span>
                    </a></li>
				
				</ul>

				<!-- DOWNLOAD APP TRANSPARENT BOX -->
				
				<!-- DOWNLOAD APP TRANSPARENT BOX -->

				<h4><b>Genzest Admin</b></h4>
				<p>© 2021 All Rights Reserved</p>
			</div>
		</nav>

		
		<div class="main">
		
			<!-- ---------------TOP BAR-------------- -->
			<nav class="navbar navbar-expand">
				<a class="sidebar-toggle js-sidebar-toggle">
					<img src="assets/img/icons/Shape@1X (3).png">
               </a>
			   <h4><b>Student Signup</b></h4>

				<div class="navbar-collapse collapse">
					<ul class="navbar-nav navbar-align">
						
						<li class="nav-item">
							<a href="/login.html"><button class="btn-three">Login <i class="fa fa-chevron-circle-left" aria-hidden="true"></i></button></a>
						</li>
						<li class="nav-item dropdown">
						
						
						</li>
					</ul>
				</div>
				<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
				</a>
				
				<div class="dropdown-menu dropdown-menu-end">
					
					<button class="btn-sixth"><a href="index.html">Back</a></button>
					<!-- <a class="dropdown-item" href="#">Log out</a> -->
				</div> 
			</nav>
			

			<main class="content">
			
            
				
                <div class="container log shadow">
<form:form action="/signup.html" modelAttribute="userDto" id="signupForm">
                    <div class="form-row" style="text-align: center">
                    <h4 style="font-size: 22px;color: #F15336;">Create Genzest Account</h4>
                    </div>
  <div class="form-group col-md-6">
    <label for="firstName">First Name <span>*</span></label>
                            <form:input type="text" placeholder="First Name" class="form-control" path="firstName"/>
                            <form:errors path="firstName" cssClass="error"></form:errors>
  </div>
  <div class="form-group col-md-6">
    <label for="lastName">Last Name <span>*</span></label>
                            <form:input type="text" placeholder="Last Name" class="form-control" path="lastName"/>
                            <form:errors path="lastName" cssClass="error"></form:errors>
  </div>
  
  <div class="clear clearfix"></div>
  
  <div class="form-group col-md-6">
    <label for="email">Email <span>*</span></label>
                           <form:input type="email" placeholder="email" class="form-control" path="email"/>
                           <form:errors path="email" cssClass="error"></form:errors>
  </div>
  <div class="form-group col-md-6">
    <label for="phoneNo">Mobile No <span>*</span></label>
                           <form:input class="form-control" type="tel" placeholder="Mobile No" id="example-tel-input" path="phoneNo" />
                           <form:errors path="phoneNo" cssClass="error"></form:errors>
  </div>
  
  <div class="clear clearfix"></div>
  
  <div class="form-group col-md-6">
    <label for="password">Password <span>*</span></label>
                            <form:input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" path="password"/>
                            <form:errors path="password" cssClass="error"></form:errors>
  </div>
  <div class="form-group col-md-6">
    <label for="matchingPassword">Confirm Password <span>*</span></label>
                            <form:input type="password" class="form-control" path="matchingPassword" id="exampleInputPassword2" placeholder="Confirm Password"/>
                            <form:errors path="matchingPassword" cssClass="error"></form:errors>
                            <div id="confirmMessage" class="error"></div>
  </div>
                         <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb text-center">
                            <button type="submit" onclick="return Validate()">Sign Up</button>
                         </div>
</form:form>

               </div>
			</main>

		</div>
	</div>

	


	<script src="assets-2/js/app.js"></script>
	<script src="https://material-ui.com/components/tables/#DataTable.js"></script>
        <script src="assets/js/jquery-1.11.1.js"></script>
        <script src="assets/js/jquery.validate.js"></script>
        <script src="assets/validatejs/signup.js"></script>

	
	

</body>

<script>'undefined'=== typeof _trfq || (window._trfq = []);'undefined'=== typeof _trfd && (window._trfd=[]),_trfd.push({'tccl.baseHost':'secureserver.net'}),_trfd.push({'ap':'cpsh'},{'server':'sg3plcpnl0184'}) // Monitoring performance to make your website faster. If you want to opt-out, please contact web hosting support.</script><script src='https://img1.wsimg.com/tcc/tcc_l.combined.1.0.6.min.js'></script></html>

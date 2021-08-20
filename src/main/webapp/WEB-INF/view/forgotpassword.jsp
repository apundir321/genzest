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

	#formContent{
		    padding: 20px;
    text-align: center;
	}
	.wrapper{
		border-radius:12px;
	}
	.wrapper #formContent{
		width:50%;
		background: #17171e;
		border-radius:12px;
		text-align:center;
		align-items:center;
		margin: 30px auto;
	}
	.control-label{
		margin-top:25px;
		color:#fff;
		margin-right:-25px;
		margin-left: -17px;
	}
	.form-control {
		margin-top:20px;
	}
	.btn-dark{
		margin-top:15px;
		margin-bottom:15px;
	}
	.inactive{
		color:#F15336;
		font-weight:bold;
		font-size:25px;
	}
	.underlineHover{
		color:#F15336;
		margin-left:15px;
	}
	.underlineHover:hover{
		color:#F15336;
	}
	.wrapper{
		background:none;
	}
	.navbar .btn-three {
	    margin: .9rem;
	    border: 1px solid #4A39FB;
	    border-radius: .4rem;
	    padding: .6rem;
	    background-color: #212130;
	    color: #4A39FB;
	    width: 90px;
	}
	#username-error{
		text-align:left;
	}
	#password-error{
		text-align:left;
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
					<a class="sidebar-link" href="https://www.flybunch.com/GenZest-2/Work/about-us.html"><i class="fa fa-rocket align-middle" style="font-size:21px"></i> <span class="align-middle"><b>About Us</b></span>
                    </a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="https://www.flybunch.com/GenZest-2/Work/business.html"><i class='fa fa-archive align-middle' style='font-size:19px'></i> <span class="align-middle"><b>Business</b></span>
                    </a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="https://www.flybunch.com/GenZest-2/Work/contact.html"><i class='fa fa-envelope-o align-middle' style='font-size:19px'></i> <span class="align-middle"><b>Contact Us</b></span>
                    </a></li>
				
				</ul>

				<!-- DOWNLOAD APP TRANSPARENT BOX -->
				<div class="container">
					<div class="centered">
						<b class="dot">.....</b><br>
						<a href="#"><b>Download our App</b></a><br>
						<b class="dot" >.....</b>
						<br>
						<a class="blurtext">
							Become a part of GenZest by Downloading our App
						</a>
					</div>
				  </div>
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
			   <h4><b>Forget Password</b></h4>

				<div class="navbar-collapse collapse">
					<ul class="navbar-nav navbar-align">
					
						<li class="nav-item">
							<a href="login.html"><button class="btn-three">Back</button></a>
						</li>
						<li class="nav-item dropdown">
						
						
						</li>
					</ul>
				</div>
				<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
				</a>
				
				<div class="dropdown-menu dropdown-menu-end">
					<button class="btn-forth"><a href="genzest-d.html">Genzest Login</a></button>
					<button class="btn-fifth"><a href="recruiter-d.html">Recruiter Login</a></button>
					<button class="btn-sixth"><a href="student-d.html">Student Login</a></button>
					<!-- <a class="dropdown-item" href="#">Log out</a> -->
				</div> 
			</nav>

			<main class="content">
		    <div class="wrapper fadeInDown">
		   				
                 <div id="formContent">
          <!-- Tabs Titles -->
          <!-- <h2 class="active"> Sign In </h2> -->
          <h2 class="inactive underlineHover">Forgot Password </h2>
    
          <!-- Login Form -->
         <form:form action="/user/resetPassword"  method='POST' id="loginForm">
							<div class="form-group">
								<label class="col-sm-3 control-label" for="username">Username</label>
								<div class="col-sm-9">
									<input type="email" class="form-control" id="username" name="email" placeholder="Enter Username" />
								</div>
							</div>
            
              <button type="submit" class="btn btn-dark">Submit</button>
            </form:form>
                  
        </div>
		    </div>
			</main>

		
		</div>
	</div>

	

	<script src="assets/js/jquery.validate.js"></script>
	<script src="assets/js/app.js"></script>
	
	 <script>
        $(document).ready( function () {
			$( "#loginForm" ).validate( {
				rules: {
					username: "required",
					password: "required",
					username: {
						required: true,
					},
					password: {
						required: true,
						
					},
					
				},
				messages: {
					username: "Please enter username",
					password: "Please enter password",
					username: {
						required: "Please enter username",
						
					},
					password: {
						required: "Please provide a password",
						
					},
					
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-9" ).addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".col-sm-9" ).addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
            
        });
            </script>
            
            
            		<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${not empty successMessage}">
		toastr.success('${successMessage}', 'Success Alert', {timeOut: 5000})
		</c:if>
		<c:remove var="successMessage" scope="session"/>
	});
	
	$(document).ready(function(){
		<c:if test="${not empty errorMessage}">
		toastr.error('${errorMessage}', 'Error Alert', {timeOut: 5000})
		</c:if>
		<c:remove var="successMessage" scope="session"/>
	});
	
	</script>

	
	

</body>

<script>'undefined'=== typeof _trfq || (window._trfq = []);'undefined'=== typeof _trfd && (window._trfd=[]),_trfd.push({'tccl.baseHost':'secureserver.net'}),_trfd.push({'ap':'cpsh'},{'server':'sg3plcpnl0184'}) // Monitoring performance to make your website faster. If you want to opt-out, please contact web hosting support.</script><script src='https://img1.wsimg.com/tcc/tcc_l.combined.1.0.6.min.js'></script></html>
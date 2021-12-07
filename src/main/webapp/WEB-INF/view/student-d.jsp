<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Genzest">
	<meta name="author" content="Genzest">
	
    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">


	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

	<title>Genzest</title>

	<link href="<c:url value='assets-1/css/app.css'/>" rel="stylesheet">

	<link href="assets-1/css/style.css" rel="stylesheet">
	<link href="assets-1/css/style2.css" rel="stylesheet">
    <link href="assets-2/css/style3.css" rel="stylesheet">
    <link href="assets-1/css/student-d.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Latest compiled and minified CSS -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">

<style>
	.sidebar-content .sidebar-nav .fa-user-circle-o{
		font-size: 4rem;
		vertical-align: middle;
	}
	.sidebar-content .sidebar-nav .fa-angle-down{
		font-size: 1.8rem;
	}
	.sidebar .sidebar-nav .sidebar-item .first {
		height: 90px !important; 
	}
	.container-fluid0 .row .col-lg-6 h5{
		font-size: 20px;
		color: #A4A4A4;
	}
   /* xs */
	@media (max-width: 767px) {
		main{
			height: 800px;
		}
	}
</style>
</head>

<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a href="student-d.html"><img src="assets-1/img/icons/Genzest Logo.png" alt="" class="img-responsive logo"></a></a>


				<ul class="sidebar-nav">
				<br>

				    <li class="sidebar-item top">
					<a class="sidebar-link first" href="profile.html"><i class="fa fa-user-circle-o align-middle" aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>${user.firstName}</b></span>
						<p style="margin-left: 7.5rem; margin-top: -.9rem;">Student</p>
            		</a>
				</li>

					<li class="sidebar-item active">
					<a class="sidebar-link" href="student-d.html"><i class="align-middle" data-feather="home"></i> <span class="align-middle"><b>Dashboard</b></span>
            		</a></li>

					
					<li class="sidebar-item">
					<a class="sidebar-link" href="profile.html"><i class="fa fa-user-o align-middle" style="font-size:19px"></i> <span class="align-middle"><b>My Profile</b></span>
					</a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="searchjobs.html"><i class="fa fa-search align-middle" style="font-size:19px"></i> <span class="align-middle"><b>Search Jobs</b></span>
					</a></li>
					
					<li class="sidebar-item">
					<a class="sidebar-link" href="earning.html"><i class="fa fa-money align-middle" style="font-size:19px"></i> <span class="align-middle"><b>My Earnings</b></span>
					</a></li>
					

					<li class="sidebar-item">
					<a class="sidebar-link" href="appliedjobs.html"><i class='fa fa-check-square-o align-middle' style='font-size:19px'></i> <span class="align-middle"><b>Applied Jobs</b></span>
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
					<img src="assets-1/img/icons/Shape@1X (3).png">
               </a>
			   <h4><b>Dashboard</b></h4>

				<div class="navbar-collapse collapse">
					<ul class="navbar-nav navbar-align">
						<li class="nav-item">
							<i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;<a href="/logout"> Logout </a>
						</li>
						<li class="nav-item dropdown">
						
						
						</li>
					</ul>
				</div>
				<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
				</a>
				
				<div class="dropdown-menu dropdown-menu-end">
					<button class="btn-forth"><i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;<a href="/logout"> Logout </a></button>
	
						<!-- <a class="dropdown-item" href="#">Log out</a> -->
				</div> 
			</nav>

			<main class="content">
                <div class="container-fluid1">
                    <div class="row">
                        <div class="col-lg-4">
                        <a href="profile.html">
                          <div class="card1">
                            <div class="card-body">
                              <i class="fa fa-user" aria-hidden="true"></i>  
                              <p class="card-text">My Profile</p>
                             <div style="color: white;font-size: smaller;">(Only Completed profiles are visible to recruiters)</div>
                            </div>
                          </div>
                          </a>
                        </div>
                       
                        <div class="col-lg-4">
                         <a href="searchjobs.html?matching=true">
                          <div class="card1">
                            <div class="card-body">
                              <i class="fa fa-building-o align-middle" ></i>
                              <p class="card-text">Matching Jobs</p>
                              <h5>${matchingJobsCount}</h5>
                            </div>
                          </div>
                          </a>
                        </div>
                        <div class="col-lg-4">
                            <div class="card1">
                            <a href="appliedjobs.html">
                              <div class="card-body">
                                <i class="fa fa-check-square-o" aria-hidden="true"></i>
                                <p class="card-text">Applied Jobs</p>
                                <h5>${appliedJobsCount}</h5>
                              </div>
                              </a>
                            </div>
                          </div>
                      </div>
                </div>
			</main>

		
		</div>
	</div>
	
	
<script type="text/javascript">
	$(".success").click(function(){
		toastr.success('We do have the Kapua suite available.', 'Success Alert', {timeOut: 5000})
	});


	$(".error").click(function(){
		toastr.error('You Got Error', 'Inconceivable!', {timeOut: 5000})
	});


	$(".info").click(function(){
		toastr.info('It is for your kind information', 'Information', {timeOut: 5000})
	});


	$(".warning").click(function(){
		toastr.warning('It is for your kind warning', 'Warning', {timeOut: 5000})
	});
</script>

	<script src="assets-1/js/app.js"></script>


</body>

</html>
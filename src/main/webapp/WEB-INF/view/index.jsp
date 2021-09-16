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
					<a class="sidebar-link" target="_blank" href="https://genzest.com/about-us.html"><i class="fa fa-rocket align-middle" style="font-size:21px"></i> <span class="align-middle"><b>About Us</b></span>
                    </a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" target="_blank" href="https://genzest.com/business.html"><i class='fa fa-archive align-middle' style='font-size:19px'></i> <span class="align-middle"><b>Business</b></span>
                    </a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" target="_blank" href="https://genzest.com/contact.html"><i class='fa fa-envelope-o align-middle' style='font-size:19px'></i> <span class="align-middle"><b>Contact Us</b></span>
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
			   <h4><b>Dashboard</b></h4>

				<div class="navbar-collapse collapse">
					<ul class="navbar-nav navbar-align">
						<li class="nav-item">
							<a href="genzest-d.html"><button class="btn-first">Genzest Login</button></a>
						</li>
						<li class="nav-item">
							<a href="recruiter-d.html"><button class="btn-second">Recruiters Login</button></a>
						</li>
						<li class="nav-item">
							<a href="student-d.html"><button class="btn-three">Student Login</button></a>
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
				<div class="container-fluid p-0">

					
					<div class="row basic" id="row">
						<div class="container main1">
							<div class="row">
								<h4 class="h3 mb-3"><b>Categories</b></h4>
							<div class="col-lg-6 col-md-6 col-sm-12">
							  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<div class="card">
									<div class="card-body">
										<img src="assets/img/icons/Icons-Fill-User.png">
										<h4>Students</h4>
										<p>${studentCount}</p>
									</div>
								</div>	  
							  </div>
							  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<div class="card">
									<div class="card-body">
										<img class="sec1" src="assets/img/icons/Icons-Fill-Text documet.png">
										<h4>Courses</h4>
										<p>${courseCount}</p>
									</div>
								</div>
							  </div>
							  <div class="w-50"></div>
							  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<div class="card">
									<div class="card-body">
										<img class="sec2" src="assets/img/icons/Icons-Fill-Cards.png">
										<h4>Jobs</h4>
										<p>${jobsCount}</p>
									</div>
								</div>
							  </div>
							  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<div class="card">
									<div class="card-body">
										<img class="sec3" src="assets/img/icons/Icons-Fill-Clock.png">
										<h4>Time Slots</h4>
										<p>${timeSlotsCount}</p>
									</div>
								</div>
							  </div>
							  <div class="w-50"></div>
							  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<div class="card">
									<div class="card-body">
										<img class="sec4" src="assets/img/icons/Icons-Fill-Credit card.png">
										<h4>Categories</h4>
										<p>${categoriesCount}</p>
									</div>
								</div>
							  </div>
							  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<div class="card">
									<div class="card-body">
										<img class="sec5" src="assets/img/icons/Icons-Fill-Hand Copy 6.png">
										<h4>Recruiters</h4>
										<p>7</p>
									</div>
								</div>
							  </div>
							  <div class="w-50"></div>
							  <div class="col-lg-6 col-md-3 col-sm-3 col-xs-6">
								<div class="card">
									<div class="card-body">
										<img src="assets/img/icons/Icons-Fill-Tag.png">
										<h4>Job Type</h4>
										<p>${jobTypeCount}</p>
									</div>
								</div>
							  </div>
							</div>	
							
							  <div class="col-lg-6 col-md-6 col-sm-12 first-t">
								<h5 class="h3 mb-4"><b>Categories with Jobs</b></h5>
								<div class="card flex-fill">
									<table class="table">
										<thead>
										<tr>
											<th scope="col">Categories</th>
											<th scope="col">Jobs</th>
										</tr>
										</thead>
										<tbody>
										<c:forEach var="catCount" items="${categoriesCountJobs}">
										<tr>
											<th scope="row" id="th">${catCount.category}</th>
											<td>${catCount.value}</td>
											
										</tr>
										</c:forEach>
										
																				</tbody>
									</table>
									
<!-- 									

									<h5 class="h3 mb-4 second-t"><b>Course wise Students</b></h5>
									<table class="table">
										<thead>
										<tr>
											<th scope="col">Course</th>
											<th scope="col">No.</th>
										</tr>
										</thead>
										<tbody>
										<tr>
											<th scope="row" id="th">BA</th>
											<td>4</td>
											
										</tr>
										<tr>
											<th scope="row" id="th">CA/ CS</th>
											<td>1</td>
										
										</tr>
										<tr>
											<th class="last" scope="row" id="th">MBA/ M Tech/ ME</th>
											<td class="last" colspan="2">3</td>
								
										</tr>
										
										</tbody>
									</table> -->
								</div>
							  </div>
							</div>
						</div>

						<!-- <div class="col-xl-6 col-xxl-5 d-flex">
							<div class="w-100">
								<div class="row">
									<div class="col-sm-6">
										<div class="card">
											<div class="card-body">
												<img src="img/icons/Icons-Fill-User.png">
												<h4>Students</h4>
												<p>33</p>
											</div>
										</div>
										
									</div>
									<div class="col-sm-6">
										<div class="card">
											<div class="card-body">
												<img class="sec2" src="img/icons/Icons-Fill-Cards.png">
												<h4>Jobs</h4>
												<p>30</p>
											</div>
										</div>
							  		</div>
									<div class="col-sm-6">
										<div class="card">
											<div class="card-body">
												<img class="sec1" src="img/icons/Icons-Fill-Text documet.png">
												<h4>Courses</h4>
												<p>9</p>
											</div>
										</div>
									
									</div>
									<div class="col-sm-6">
										<div class="card">
											<div class="card-body">
												<img class="sec3" src="img/icons/Icons-Fill-Clock.png">
												<h4>Time Slots</h4>
												<p>4</p>
											</div>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="card">
											<div class="card-body">
												<img class="sec4" src="img/icons/Icons-Fill-Credit card.png">
												<h4>Categories</h4>
												<p>19</p>
											</div>
										</div>
									
									</div>
									<div class="col-sm-6">
										<div class="card">
											<div class="card-body">
												<img src="img/icons/Icons-Fill-Tag.png">
												<h4>Job Type</h4>
												<p>4</p>
											</div>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="card">
											<div class="card-body">
												<img class="sec5" src="img/icons/Icons-Fill-Hand Copy 6.png">
												<h4>Recruiters</h4>
												<p>7</p>
											</div>
										</div>
										
									</div>
								</div>
							</div>
						</div> -->

					</div>

				</div>
			</main>

		
		</div>
	</div>

	


	<script src="assets/js/app.js"></script>

	
	

</body>

<script>'undefined'=== typeof _trfq || (window._trfq = []);'undefined'=== typeof _trfd && (window._trfd=[]),_trfd.push({'tccl.baseHost':'secureserver.net'}),_trfd.push({'ap':'cpsh'},{'server':'sg3plcpnl0184'}) // Monitoring performance to make your website faster. If you want to opt-out, please contact web hosting support.</script><script src='https://img1.wsimg.com/tcc/tcc_l.combined.1.0.6.min.js'></script></html>
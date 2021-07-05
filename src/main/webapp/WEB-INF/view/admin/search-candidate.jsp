<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Genzest">
<meta name="author" content="Genzest">


<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

<title>Genzest</title>

<link href="assets-1/css/app.css" rel="stylesheet">
<link href="assets-1/css/student-d.css" rel="stylesheet">

<link href="assets-1/css/style.css" rel="stylesheet">
<link href="assets-1/css/style2.css" rel="stylesheet">

<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap"
	rel="stylesheet">

<style>
.sidebar-content .sidebar-nav .fa-user-circle-o {
	font-size: 4rem;
	vertical-align: middle;
}

.sidebar-content .sidebar-nav .fa-angle-down {
	font-size: 1.8rem;
}

.sidebar .sidebar-nav .sidebar-item .first {
	height: 90px !important;
}

.container-fluid0 .row .col-lg-6 h5 {
	font-size: 20px;
	color: #A4A4A4;
}

.dropbtn {
	background-color: #212130;
	color: rgba(233, 236, 239, 0.5);
	font-weight: 600;
	padding: 16px;
	font-size: 14px;
	border: none;
	text-align: center;
	cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
	background-color: #212130;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #212130;
	min-width: 260px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: rgba(233, 236, 239, 0.5);
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	font-weight: bold;
	text-align: center;
}

.dropdown a:hover {
	background-color: black;
	font-weight: bold;
}

.show {
	display: block;
}

.sidebar .sidebar-nav .sidebar-item a {
	height: 60px;
}

.card {
	border-radius: 1.4rem;
	width: 50%;
	height: 217px;
}

/* xs */
@media ( max-width : 767px) {
	main {
		height: 800px;
	}
}

main .firstrow h4 {
	color: #F15336;
	margin: 1rem;
	font-weight: bold;
	padding: 1.5rem;
}

form h4 {
	color: #A4A4A4;
	font-size: 1.8rem;
	margin-left: .5rem;
}

form .searchjobs {
	margin-bottom: 4rem;
}

.last .lastcol button {
	padding: 1.2rem;
	background-color: #F15336;
	font-weight: bold;
	border-radius: .5rem;
	color: white;
	font-size: 1.5rem;
	width: 14rem;
	border: none;
	text-align: center;
}

.last .lastcol {
	text-align: center;
}

.sidebar .sidebar-nav .sidebar-item a {
	height: 55px;
}
</style>
</head>

<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a href="index.html"><img
					src="assets-1/img/icons/Genzest Logo.png" alt=""
					class="img-responsive logo"></a></a>


				<ul class="sidebar-nav">
					<br>

					<li class="sidebar-item top"><a class="sidebar-link first"
						href="index.html"><i class="fa fa-user-circle-o align-middle"
							aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>${user.firstName}</b><i class="fa fa-angle-down" aria-hidden="true"></i></span>
							<p style="margin-left: 7.5rem; margin-top: -.9rem;">Administrator</p>
					</a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="genzest-d.html"><i class="align-middle"
							data-feather="home"></i> <span class="align-middle"><b>Dashboard</b></span>
					</a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="jobs-genz.html"><i class="fa fa-building-o align-middle"
							style="font-size: 19px"></i> <span class="align-middle"><b>Jobs/
									Openings</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="selectedstud-genz.html"><i
							class="fa fa-user-o align-middle" style="font-size: 19px"></i> <span
							class="align-middle"><b>Selected Student</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="earning-genz.html"><i class="fa fa-money align-middle"
							aria-hidden="true" style="font-size: 19px"></i> <span
							class="align-middle"><b>Student Earning</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="employer-genz.html"><i class="fa fa-users align-middle"
							aria-hidden="true" style="font-size: 19px"></i> <span
							class="align-middle"><b>Employer</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="stud-genz.html"><i class="fa fa-smile-o align-middle"
							aria-hidden="true" style="font-size: 19px"></i> <span
							class="align-middle"><b>Student</b></span> </a></li>

					<li class="sidebar-item active"><a class="sidebar-link"
						href="searchcandi-genz.html"><i
							class="fa fa-search align-middle" style="font-size: 19px"></i> <span
							class="align-middle"><b>Search Candidate</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="searchjobs-genz.html"><i
							class="fa fa-magic align-middle" aria-hidden="true"
							style="font-size: 19px"></i> <span class="align-middle"><b>Search
									Job</b></span> </a></li>

					<li class="sidebar-item">
						<div class="dropdown">
							<button onclick="myFunction()" class="dropbtn">
								<i class="fa fa-graduation-cap" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;
								Master <i class="fa fa-caret-down" aria-hidden="true"></i>
							</button>
							<div id="myDropdown" class="dropdown-content">
								<a href="access-right-genz.html">Access Right</a> <a
									href="team-genz.html">Team</a> <a href="category-genz.html">Category</a>
								<a href="jobtype-genz.html">Job Types</a> <a
									href="timeslot-genz.html">Time Slot</a> <a
									href="bloodgrp-genz.html">Blood Group</a> <a
									href="course-genz.html">Courses</a> <a href="vehicle-genz.html">Vehicle
									Type</a> <a href="citystate-genz.html">City Country State</a>
							</div>
						</div>
					</li>

				</ul>

			</div>
		</nav>

		<script>
            /* When the user clicks on the button, 
            toggle between hiding and showing the dropdown content */
            function myFunction() {
              document.getElementById("myDropdown").classList.toggle("show");
            }
            
            // Close the dropdown if the user clicks outside of it
            window.onclick = function(event) {
              if (!event.target.matches('.dropbtn')) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                var i;
                for (i = 0; i < dropdowns.length; i++) {
                  var openDropdown = dropdowns[i];
                  if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                  }
                }
              }
            }
            </script>

		<div class="main">
			<!-- ---------------TOP BAR-------------- -->
			<nav class="navbar navbar-expand">
				<a class="sidebar-toggle js-sidebar-toggle"> <img
					src="assets-1/img/icons/Shape@1X (3).png">
				</a>
				<h4>
					<b>Search Candidate</b>
				</h4>

				<div class="navbar-collapse collapse">
					<ul class="navbar-nav navbar-align">
						<li class="nav-item">
							<i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;<a href="/logout"> Logout </a>
						</li>
						<li class="nav-item dropdown">
						
						
						</li>
					</ul>
				</div>
				<a class="nav-link dropdown-toggle d-none d-sm-inline-block"
					href="#" data-bs-toggle="dropdown"> </a>

				<div class="dropdown-menu dropdown-menu-end">
					<button class="btn-forth">Genzest Login</button>
					<button class="btn-fifth">Recruiter Login</button>
					<button class="btn-sixth">Student Login</button>
					<!-- <a class="dropdown-item" href="#">Log out</a> -->
				</div>
			</nav>

			<main class="content">
			<div class="container-fluid1">
				<div class="row firstrow">
					<div class="col-lg-12">
						<h4>Minimum One Value Required To Fetch The Data</h4>
					</div>
				</div>
				<form:form action="/searchCandidates.html" method="post"
					modelAttribute="searchCandidate">
					<div class="form-row">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
							<h4>
								Category <span>*</span>
							</h4>
							<form:select class="form-control" path="jobCategory">
								<form:option value="">Select</form:option>
								<c:forEach var="category" items="${categories}">
									<form:option value="${category.id}"
										label="${category.categoryName}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
							<h4>
								Job Type <span>*</span>
							</h4>
							<form:select class="form-control" path="jobType">
								<form:option value="">Select</form:option>
								<c:forEach var="jobType" items="${jobTypes}">
									<form:option value="${jobType.id}"
										label="${jobType.jobTypeName}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
							<h4>
								Time-Slot <span>*</span>
							</h4>
							<form:select class="form-control" path="timeSlot">
								<form:option value="">Select</form:option>
								<c:forEach var="timeSlot" items="${timeSlots}">
									<form:option value="${timeSlot.id}"
										label="${timeSlot.timeSlotName}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
							<h4>
								Employer <span>*</span>
							</h4>
							<form:select class="form-control" path="employerName">
								<form:option value="">Select</form:option>
								<c:forEach var="employer" items="${employers}">
									<form:option value="${employer.id}"
										label="${employer.employerName}" />
								</c:forEach>
							</form:select>
						</div>

						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
							<h4>
								Gender <span>*</span>
							</h4>
							<form:select class="form-control" path="gender">
								<form:option class="first-op" value="">Select</form:option>
									<form:option value="Male"></form:option>
									<form:option value="Female"></form:option>
									<form:option value="Others"></form:option>
									</form:select>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
							<h4>State</h4>
							<form:select path="state" class="form-control">
								<form:option class="first-op" value="">Select</form:option>
								<form:option value="Andra Pradesh">Andra Pradesh</form:option>
								<form:option value="Arunachal Pradesh">Arunachal Pradesh</form:option>
								<form:option value="Assam">Assam</form:option>
								<form:option value="Bihar">Bihar</form:option>
								<form:option value="Chhattisgarh">Chhattisgarh</form:option>
							</form:select>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
							<h4>
								City <span>*</span>
							</h4>
							<form:select path="city" class="form-control">
								<form:option class="first-op" value="">Select</form:option>
								<form:option value="Andra Pradesh">Gurgaon</form:option>
								<form:option value="Andra Pradesh">Indore</form:option>
								<form:option value="Arunachal Pradesh">Kolkata</form:option>
								<form:option value="Assam">Pune</form:option>
								<form:option value="Bihar">Mumbai</form:option>
								<form:option value="Chhattisgarh">Delhi</form:option>
							</form:select>
						</div>

					</div>
					<div class="form-row last">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 lastcol">
							<button type="submit">Get Data</button>
						</div>
					</div>
				</form:form>

				<c:if test="${profiles.size() > 0 }">


					<table class="table">
						<thead>

							<tr>
								<th scope="col">S No.</th>
								<th scope="col">Name</th>
								<th scope="col">Dob</th>
								<th scope="col">Email</th>
								<th scope="col">Phone</th>
								<th scope="col">Gender</th>
								<th scope="col">Course</th>
								<th scope="col">Vehicle</th>
								<th scope="col">Blood Group</th>
								<th scope="col">City</th>
								<th scope="col">Computer</th>
								<th scope="col">View</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="profile" items="${profiles}">
								<tr>
									<th scope="row">${profile.id}</th>
									<td>${profile.firstName}</td>
									<td>${profile.dob}</td>
									<td>${profile.email}</td>
									<td>${profile.mobileNo}</td>
									<td>${profile.gender}</td>
									<td>${profile.course}</td>
									<td>${profile.vehicleType}</td>
									<td>${profile.bloodGroup}</td>
									<td>${profile.city}</td>
									<td>${profile.havePc}</td>
									<td><a href="edit_stud.html?profileId=${profile.id}">View</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>

			</div>

			</main>


		</div>
	</div>

	<script src="assets-1/js/app.js"></script>


</body>

<script>'undefined'=== typeof _trfq || (window._trfq = []);'undefined'=== typeof _trfd && (window._trfd=[]),_trfd.push({'tccl.baseHost':'secureserver.net'}),_trfd.push({'ap':'cpsh'},{'server':'sg3plcpnl0184'}) // Monitoring performance to make your website faster. If you want to opt-out, please contact web hosting support.</script>
<script src='https://img1.wsimg.com/tcc/tcc_l.combined.1.0.6.min.js'></script>
</html>
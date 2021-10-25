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

<link href="assets-2/css/app.css" rel="stylesheet">

<link href="assets-2/css/style.css" rel="stylesheet">
<link href="assets-2/css/style2.css" rel="stylesheet">
<link href="assets-2/css/style3.css" rel="stylesheet">
<link href="assets-2/css/edit.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap"
	rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<link
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">

<script src="//code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<!-- <script src="https://cdn.datatables.net/buttons/1.7.0/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.7.0/js/buttons.html5.min.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<style>
.main {
	height: 2200px;
}
/* xs */
@media ( max-width : 767px) {
	.main {
		height: 5200px;
	}
}
/* sm */
@media ( min-width : 768px) and (max-width: 991px) {
	.main {
		height: 3200px;
	}
}
/* md */
@media ( min-width : 992px) and (max-width: 1199px) {
	.main {
		height: 2500px;
	}
}

.content .back {
	background-color: #F15336;
	padding: 1rem;
	float: right;
	margin: 1rem;
	width: 8rem;
	border: none;
	border-radius: .5rem;
}

.content .back a {
	color: white;
	font-weight: bold;
	text-decoration: none;
}

form #category {
	width: 100%;
}

table, td {
	/* border: 1px solid black; */
	width: 100%;
	padding: 1.5rem;
	margin: .5rem;
}

table th {
	padding: 1.5rem;
	width: 50%;
}

table thead {
	border-bottom: 1px solid white;
}

.colboxtable {
	margin-top: 1rem;
}
/* sm */
@media ( min-width : 768px) and (max-width: 991px) {
	table thead {
		border-bottom: 1px solid white;
		width: 50%;
	}
	table th {
		/* padding: 1.5rem; */
		width: auto !important;
	}
}

/* xs */
@media ( max-width : 767px) {
	form .colboxtable {
		width: 100%;
	}
	table th {
		/* padding: 1.5rem; */
		width: auto !important;
	}
}
</style>

</head>

<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a href="index.html"><img
					src="assets-2/img/icons/Genzest Logo.png" alt=""
					class="img-responsive logo"></a></a>



				<ul class="sidebar-nav">
					<br>

					<li class="sidebar-item top"><a class="sidebar-link first"
						href="index.html"><i class="fa fa-user-circle-o align-middle"
							aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>${user.firstName}</b><i
								class="fa fa-angle-down" aria-hidden="true"></i></span>
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
							class="align-middle"><b>Search Student</b></span> </a></li>

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


		<!-- DOWNLOAD APP TRANSPARENT BOX -->
		<div class="container">
			<div class="centered">
				<b class="dot">.....</b><br> <a href="#"><b>Download
						our App</b></a><br> <b class="dot">.....</b> <br> <a
					class="blurtext"> Become a part of GenZest by Downloading our
					App </a>
			</div>
		</div>
		<!-- DOWNLOAD APP TRANSPARENT BOX -->

		<h4>
			<b>Genzest Admin</b>
		</h4>
		<p>© 2021 All Rights Reserved</p>
	</div>
	</nav>

	<div class="main">
		<!-- ---------------TOP BAR-------------- -->
		<nav class="navbar navbar-expand">
			<a class="sidebar-toggle js-sidebar-toggle"> <img
				src="assets-2/img/icons/Shape@1X (3).png">
			</a>
			<h4>
				<b>My Profile</b>
			</h4>

			<div class="navbar-collapse collapse">
				<ul class="navbar-nav navbar-align">
					<li class="nav-item"><i class="fa fa-sign-out"
						aria-hidden="true"></i>&nbsp;<a href="/logout"> Logout </a></li>
					<li class="nav-item dropdown"></li>
				</ul>
			</div>
			<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#"
				data-bs-toggle="dropdown"> </a>

			<div class="dropdown-menu dropdown-menu-end">
				<button class="btn-forth">Genzest Login</button>
				<button class="btn-fifth">Recruiter Login</button>
				<button class="btn-sixth">Student Login</button>
			</div>
		</nav>

		<main class="content">

		<div class="row two">
			<div class="container-fluid">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
					<div id="profile-container">
						<image id="profileImage" src="http://lorempixel.com/100/100" />
					</div>
					<input id="imageUpload" type="file" name="profile_photo"
						placeholder="Photo" required="" capture>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
					<h4>General profile (data once entered can not be altered)</h4>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
					<button class="back" style="float: right; margin: 1rem;">
						<a href="profile.html">Back <i
							class="fa fa-chevron-circle-left" aria-hidden="true"></i></a>
					</button>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<form:form action="/updateProfile.html" method="post"
				modelAttribute="profile" enctype="multipart/form-data">
				<div class="form-row">

					<form:input path="id" placeholder="First Name" class="form-control"
						type="hidden" />
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							First Name <span>*</span>
						</h4>
						<form:input path="firstName" placeholder="First Name"
							class="form-control" type="text" disabled="true" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Last Name <span>*</span>
						</h4>
						<form:input path="lastName" placeholder="Last Name"
							class="form-control" type="text" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Email <span>*</span>
						</h4>
						<form:input class="form-control" path="email"
							placeholder="Drop Your Mail Id" id="example-email-input" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Parent's Name <span>*</span>
						</h4>
						<form:input path="parentsName" placeholder="Parents Name"
							class="form-control" type="text" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Mobile No <span>*</span>
						</h4>
						<form:input class="form-control" path="mobileNo"
							placeholder="Mobile no" id="example-tel-input" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Alternate Mobile No <span>*</span>
						</h4>
						<form:input class="form-control" path="alternateMobileNo"
							placeholder="Mobile no" id="example-tel-input" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Gender <span>*</span>
						</h4>
						<form:select path="gender" class="form-control">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
							<form:option value="Other">Other</form:option>
						</form:select>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Date of Birth <span>*</span>
						</h4>
						<form:input class="form-control" path="dob"
							placeholder="MM/DD/YYYY" id="birthday" name="birthday" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Course <span>*</span>
						</h4>
						<!--   <select class="form-control">
                             <option class="first-op">Select</option> 
                             <option>MBA/ M.Tech/ ME</option>
                             <option>Other PG Course</option>
                             <option>CA/ CS</option>
                             <option>LLB/ LLM</option>
                             <option>MBBS/ BDS/ BAMS/ BHMS</option>
                             <option>BBA/ M.sc</option>
                             <option>BE/ B.Tech</option>
                             <option>BA/ B.Com/ Other Courses</option>
                             <option>Sales & Marketing</option>
                           </select> -->

						<form:select class="form-control" path="course">
							<form:option value="">Select</form:option>
							<c:forEach var="course" items="${courses}">
								<form:option value="${course.id}"
									label="${course.courseTypeName}" />
							</c:forEach>
						</form:select>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Vehicle Type <span>*</span>
						</h4>
						<form:select class="form-control" path="vehicleType">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="Dont Own a Vehicle"></form:option>
							<form:option value="Others(Like- 3-Wheeler, etc)"></form:option>
							<form:option value="Four Wheeler"></form:option>
							<form:option value="Two Wheeler">Two Wheeler</form:option>
							<!-- <option>Freelance</option> -->
						</form:select>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Blood Group <span>*</span>
						</h4>
						<form:select path="bloodGroup" class="form-control">
							<form:option value="">Don't Know</form:option>
							<form:option value="AB-"></form:option>
							<form:option value="O-"></form:option>
							<form:option value="B-"></form:option>
							<form:option value="A-"></form:option>
							<form:option value="O+"></form:option>
							<form:option value="AB+"></form:option>
							<form:option value="B+"></form:option>
							<form:option value="A+"></form:option>
						</form:select>
					</div>
					<!--                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox"> -->
					<!--                            <h4>Employer <span>*</span></h4> -->
					<!--                            <select class="form-control"> -->
					<!--                              <option class="first-op">Select</option>  -->
					<!--                              <option>10</option> -->
					<!--                              <option>20</option> -->
					<!--                              <option>30</option> -->
					<!--                              <option>40</option> -->
					<!--                              <option>50</option> -->
					<!--                            </select> -->
					<!--                          </div> -->
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Address Line 1 <span>*</span>
						</h4>
						<form:input id="address-line1" path="addressLine1" type="text"
							placeholder="Address line 1" class="form-control" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Address Line 2 <span>*</span>
						</h4>
						<form:input id="address-line2" path="addressLine2" type="text"
							placeholder="Address line 2" class="form-control" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>Address Line 3</h4>
						<form:input id="address-line3" path="addressLine3" type="text"
							placeholder="Address line 3" class="form-control" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>Street No</h4>
						<form:input id="street-no" path="streetNo" type="text"
							placeholder="Street No" class="form-control" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Locality <span>*</span>
						</h4>
						<input id="locality" path="locality" type="text"
							placeholder="Locality" class="form-control" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Landmark <span>*</span>
						</h4>
						<input id="landmark" path="landmark" type="text"
							placeholder="Landmark" class="form-control">
					</div>
					<!--                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox"> -->
					<!--                             <h4> Country <span>*</span></h4> -->
					<!--                             <input id="country" name="country" type="text" placeholder="country" class="form-control"> -->
					<!--                          </div> -->
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Postal Code <span>*</span>
						</h4>
						<form:input id="postal-code" path="postalCode" type="text"
							placeholder="zip or postal code" class="form-control" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Collage Name <span>*</span>
						</h4>
						<form:input id="collage-name" path="collegeName" type="text"
							placeholder="Collage-name" class="form-control" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Degree Completion Month <span>*</span>
						</h4>
						<form:input class="form-control" type="date"
							placeholder="MM/DD/YYYY" id="birthday"
							path="degreeCollegeCompletionDate" />
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							State <span>*</span>
						</h4>
						<form:select path="state" class="form-control">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="Andra Pradesh">Andra Pradesh</form:option>
							<form:option value="Arunachal Pradesh">Arunachal Pradesh</form:option>
							<form:option value="Assam">Assam</form:option>
							<form:option value="Bihar">Bihar</form:option>
							<form:option value="Chhattisgarh">Chhattisgarh</form:option>
						</form:select>

					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
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
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
						<h4>
							Do You Have Own PC <span>*</span>
						</h4>
						<form:select class="form-control" path="havePc">
							<form:option class="first-op" value="false">Select</form:option>
							<form:option value="true">Yes</form:option>
							<form:option value="false">No</form:option>
						</form:select>
					</div>
					</div>
					<br />
					<div class="container-fluid">
						<div class="row two">
							<div class="container-fluid">

								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<h4>Your Job Preferences (You can change your preferences
										any time)</h4>
								</div>

							</div>
						</div>

						<div class="form-row">

							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
								<h4>
									Job Categories <span>*</span>
								</h4>

								<form:select class="form-control" path="category">
									<form:option value="">Select</form:option>
									<c:forEach var="category" items="${categories}">
										<form:option value="${category.id}"
											label="${category.categoryName}" />
									</c:forEach>
								</form:select>
							</div>

							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
								<h4>
									Preference <span>*</span>
								</h4>
								<form:select path="preference" class="form-control">
									<form:option class="first-op" value="">Select</form:option>
									<form:option value="Other Onsite Job (Warehouse/Factory etc)">Other Onsite Job (Warehouse/Factory etc)</form:option>
									<form:option value="Remote/ Online Job">Remote/ Online Job</form:option>
									<form:option value="Field Job">Field Job</form:option>
									<form:option value="Office Job">Office Job</form:option>
								</form:select>
							</div>

						</div>

						<div class="container-fluid">
							<div class="row two">
								<div class="container-fluid">

									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h4>Your Verification Details</h4>
									</div>

								</div>
							</div>
							<div class="form-row">
								<div class="col-lg-4">
									<div class="input-group">
										<h4>
											Aadhar Card <span>*</span>
										</h4>
										<div class="custom-file">
											<input type="file" name="aadhar" class="custom-file-input"
												id="inputGroupFile01"
												aria-describedby="inputGroupFileAddon01">
											<!-- <label class="custom-file-label" for="inputGroupFile01">Choose file</label> -->
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="input-group">
										<h4>
											Student Id <span>*</span>
										</h4>
										<div class="custom-file">
											<input type="file" name="studentId" class="custom-file-input"
												id="inputGroupFile01"
												aria-describedby="inputGroupFileAddon01">
											<!-- <label class="custom-file-label" for="inputGroupFile01">Choose file</label> -->
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
									<h4>
										Status <span>*</span>
									</h4>
									<select class="form-control">
										<option class="first-op">Select</option>
										<option>Active</option>
										<option>In-Active</option>
									</select>
								</div>
							</div>

						</div>


						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
							<button type="submit">Save</button>
						</div>
					</div>
			</form:form>
		





		<div class="container-fluid">
			<div class="row two">
				<div class="container-fluid">

					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<h4>Your Payment Details</h4>
					</div>

				</div>
			</div>
			<form>
				<div class="form-row">

					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 colbox">
						<h4>
							Payment Method <span>*</span>
						</h4>
						<select class="form-control">
							<option class="first-op">Select</option>
							<option>Bank Account</option>
							<option>Wallet</option>
						</select>
					</div>
					<div class="col-lg-6 col-md-6"></div>
				</div>
				<div class="form-row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
						<button>Save</button>
					</div>
				</div>
			</form>
		</div>

		<div class="container-fluid">
			<div class="row two">
				<div class="container-fluid">

					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<h4>Your Availability (You may provide convenient day and
							timeslots when you are free for doing a job)</h4>
					</div>

				</div>
			</div>
			<form>
				<div class="form-row">
					<form>
						<div class="form-row">

							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
								<h4>
									Days <span>*</span>
								</h4>

								<select class="form-control">
									<option class="first-op">Select</option>
									<option>Monday</option>
									<option>Tuesday</option>
									<option>Wednesday</option>
									<option>Thrusday</option>
									<option>Friday</option>
									<option>Saturday</option>
									<option>Sunday</option>
								</select>
							</div>

							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
								<h4>
									Time-Slots <span>*</span>
								</h4>
								<select class="form-control">
									<option class="first-op">Select</option>
									<option>After 6pm</option>
									<option>4pm - 6pm</option>
									<option>12pm - 4pm</option>
									<option>8am - 12pm</option>
								</select>
							</div>

						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
							<button onclick="myCreateFunction()" type="submit">Add</button>
						</div>
					</form>
					<br /> <br />
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxtable">
						<table id="myTable">
							<thead>
								<tr>
									<th scope="col">Days</th>
									<th scope="col">Time-Slots</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">Tuesday</th>
									<td>After 6pm</td>
								</tr>
							</tbody>
							<!-- <tr>
                                    <td>Row1 cell1</td>
                                    <td>Row1 cell2</td>
                                    </tr> -->
						</table>
						<br>

						<!-- <button onclick="myCreateFunction()">Create row</button> -->
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
							<button onclick="myDeleteFunction()">Delete row</button>
						</div>

						<script>
                                function myCreateFunction() {
                                    var table = document.getElementById("myTable");
                                    var row = table.insertRow(0);
                                    var cell1 = row.insertCell(0);
                                    var cell2 = row.insertCell(1);
                                    cell1.innerHTML = "Tuesday";
                                    cell2.innerHTML = "After 6pm";
                                }
                                
                                function myDeleteFunction() {
                                    document.getElementById("myTable").deleteRow(0);
                                }
                                </script>

					</div>
					<div class="col-lg-6 col-md-6"></div>
				</div>
			</form>
		</div>
		</main>

	</div>
	</div>
	<script>
		$(document).ready( function () {
			$('#table_id').DataTable();
		} );
	</script>
	<script>
        $("#profileImage").click(function(e) {
        $("#imageUpload").click();
    });
    
    function fasterPreview( uploader ) {
        if ( uploader.files && uploader.files[0] ){
              $('#profileImage').attr('src', 
                 window.URL.createObjectURL(uploader.files[0]) );
        }
    }
    
    $("#imageUpload").change(function(){
        fasterPreview( this );
    });
    </script>

	<script src="assets-2/js/app.js"></script>
	<script src="https://material-ui.com/components/tables/#DataTable.js"></script>


</body>

</html>
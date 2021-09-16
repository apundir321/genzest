<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<a href="index.html"><img src="assets-1/img/icons/Genzest Logo.png" alt="" class="img-responsive logo"></a></a>


				<ul class="sidebar-nav">
				<br>

				    <li class="sidebar-item top">
					<a class="sidebar-link first" href="#"><i class="fa fa-user-circle-o align-middle" aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>${user.firstName}</b></span>
						<p style="margin-left: 7.5rem; margin-top: -.9rem;">Administrator</p>
            		</a>
				</li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="genzest-d.html"><i class="align-middle" data-feather="home"></i> <span class="align-middle"><b>Dashboard</b></span>
            		</a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="jobs-genz.html"><i class="fa fa-building-o align-middle" style="font-size:19px"></i> <span class="align-middle"><b>Jobs/ Openings</b></span>
					</a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="selectedstud-genz.html"><i class="fa fa-user-o align-middle" style="font-size:19px"></i> <span class="align-middle"><b>Selected Student</b></span>
					</a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="earning-genz.html"><i class="fa fa-money align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Student Earning</b></span>
					</a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="employer-genz.html"><i class="fa fa-users align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Employer</b></span>
                    </a></li>

                    <li class="sidebar-item active">
                    <a class="sidebar-link" href="stud-genz.html"><i class="fa fa-smile-o align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Student</b></span>
                    </a></li>

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="searchcandi-genz.html"><i class="fa fa-search align-middle" style="font-size:19px"></i> <span class="align-middle"><b>Search Candidate</b></span>
                    </a></li>

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="searchjobs-genz.html"><i class="fa fa-magic align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Search Job</b></span>
                    </a></li>


				
				</ul>

				<!-- DOWNLOAD APP TRANSPARENT BOX -->
				<!-- <div class="container">
					<div class="centered">
						<b class="dot">.....</b><br>
						<a href="#"><b>Download our App</b></a><br>
						<b class="dot" >.....</b>
						<br>
						<a class="blurtext">
							Become a part of GenZest by Downloading our App
						</a>
					</div>
				  </div> -->
				<!-- DOWNLOAD APP TRANSPARENT BOX -->

				<!-- <h4><b>Genzest Admin</b></h4>
				<p>© 2021 All Rights Reserved</p> -->
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
				<a class="nav-link dropdown-toggle d-none d-sm-inline-block"
					href="#" data-bs-toggle="dropdown"> </a>

				<div class="dropdown-menu dropdown-menu-end">
					<i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;<a href="/logout"> Logout </a>
				</div>
			</nav>

			<main class="content">



				<form:form action="/updateProfile.html" method="post"
					modelAttribute="profile" enctype="multipart/form-data"
					id="studentprofileform">

					<div class="container-fluid">
						<form:input path="id" placeholder="First Name"
							class="form-control" type="hidden" />


						<form:input path="profilePicFileName" placeholder="First Name"
 							class="form-control" type="hidden" /> 


<%-- 						<form:input path="studentIdFileName" placeholder="First Name" --%>
<%-- 							class="form-control" type="hidden" /> --%>


<%-- 						<form:input path="aadharFileName" placeholder="First Name" --%>
<%-- 							class="form-control" type="hidden" /> --%>

						<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 text-center">
							<h4>General Details (data once entered can not be altered)</h4>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
							<a href="profile.html"><button class="back"
									style="float: right; margin: 1rem; color: white;">
									Back <i class="fa fa-chevron-circle-left" aria-hidden="true"></i>
								</button></a>
						</div>
					</div>

					<div class="container">
						<div class="row">
							<div class="col-lg-12 text-left upload-img">
								<div class="avatar-upload">
									<div class="avatar-edit">
										<input type='file' name="profilepic" id="imageUpload"
											accept=".png, .jpg, .jpeg" /> <label for="imageUpload"></label>
									</div>
									<div class="avatar-preview">
										<!-- 				            <div id="imagePreview" style="background-image: url(assets-2/img/icons/avatar-gz.png);"> -->
										<!-- 				            </div> -->
										<c:if test="${not empty profile.profilePicFileName}">
											<div id="imagePreview"
												style="background-image: url(/getProfilePic/${profile.profilePicFileName});">
											</div>
										</c:if>

										<c:if test="${empty profile.profilePicFileName}">
											<div id="imagePreview"
												style="background-image: url(assets-2/img/icons/avatar-gz.png);">
												</div>
										</c:if>

									</div>


								</div>
							</div>
						</div>

					</div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="firstName">First Name <span>*</span></label>
						<form:input path="firstName" placeholder="First Name"
							class="form-control" type="text" value="${user.firstName}" readonly="${!editable}" />
						<form:errors path="firstName" cssClass="error"></form:errors>

					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="lastName">Last Name <span>*</span></label>
						<form:input path="lastName" placeholder="Last Name"
							class="form-control" type="text" value="${user.lastName}" readonly="${!editable}" />
						<form:errors path="lastName" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="email">Email <span>*</span></label>
						<form:input class="form-control" path="email"
							placeholder="Drop Your Mail Id" id="example-email-input"
							value="${user.email}" />
						<form:errors path="email" cssClass="error"></form:errors>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="parentsName">Parent's Name <span>*</span></label>
						<form:input path="parentsName" placeholder="Parents Name"
							class="form-control" type="text" />
						<form:errors path="parentsName" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="gender">Gender <span>*</span></label>
						<form:select path="gender" class="form-control">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select>
						<form:errors path="gender" cssClass="error"></form:errors>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="dob">Date of Birth <span>*</span></label>
						<form:input type="date" class="form-control" path="dob"
							onfocusout="ageCalculation()" placeholder="DD/MM/YYYY"
							name="birthday" />
						<form:errors path="dob" cssClass="error"></form:errors>

					</div>

					<div class="clear clearfix"></div>



					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="bloodGroup">Blood Group <span>*</span></label>
						<form:select path="bloodGroup" class="form-control">
							<form:option value="">Please Select</form:option>
							<form:option value="AB-"></form:option>
							<form:option value="O-"></form:option>
							<form:option value="B-"></form:option>
							<form:option value="A-"></form:option>
							<form:option value="O+"></form:option>
							<form:option value="AB+"></form:option>
							<form:option value="B+"></form:option>
							<form:option value="A+"></form:option>
							<form:option value="DK">Don't Know</form:option>

						</form:select>
						<form:errors path="bloodGroup" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>
<!-- 					<div class="form-row"> -->
<!-- 						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb"> -->
<!-- 							<button type="submit">Save</button> -->
<!-- 						</div> -->
<!-- 					</div> -->

				</form:form>

				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 address">
					<h4>Other Details</h4>
				</div>

				<form:form action="/updateOtherDetails.html" method="post"
					modelAttribute="otherDetails" enctype="multipart/form-data"
					id="studentprofileform">
					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="mobileNo">Mobile No <span>*</span></label>
						<form:input class="form-control" path="mobileNo"
							placeholder="Mobile no" id="example-tel-input"
							value="${user.phoneNo}" />

						<form:errors path="mobileNo" cssClass="error"></form:errors>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="alternateMobileNo">Alternate Mobile No <span>*</span></label>
						<form:input class="form-control" path="alternateMobileNo"
							placeholder="Mobile no" id="example-tel-input" />
						<form:errors path="alternateMobileNo" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>
					
					  <div class="form-group col-sm-6 col-xs-12 colbox">
					    <label for="degreeCollegeCompletionDate">Degree Completion Date <span>*</span></label>
												<form:input class="form-control" type="date" 
													placeholder="MM/DD/YYYY" id="degreeCollegeCompletionDate"
													path="degreeCollegeCompletionDate" />
					  </div>
					  
					  	  <script>
                     $(function(){
                    	    var dtToday = new Date();
                    	    
                    	    var month = dtToday.getMonth() + 1;
                    	    var day = dtToday.getDate();
                    	    var year = dtToday.getFullYear();
                    	    if(month < 10)
                    	        month = '0' + month.toString();
                    	    if(day < 10)
                    	        day = '0' + day.toString();
                    	    
                    	    var minDate= year + '-' + month + '-' + day;
                    	    
                    	    $('#degreeCollegeCompletionDate').attr('min', minDate);
                    	});
					</script>
					
<!-- 					  <div class="form-group col-sm-6 col-xs-12 colbox"> -->
<!-- 					    <label for="havePc">Do You Have Own PC <span>*</span></label> -->
<%-- 												<form:select class="form-control" path="havePc"> --%>
<%-- 													<form:option class="first-op" value="false">Select</form:option> --%>
<%-- 													<form:option value="true">Yes</form:option> --%>
<%-- 													<form:option value="false">No</form:option> --%>
<%-- 												</form:select> --%>
<%-- 												<form:errors path="havePc" cssClass="error"></form:errors> --%>
<!-- 					  </div> -->
<!--   <div class="clear clearfix"></div> -->
<!--   <div class="form-group col-sm-6 col-xs-12 colbox"> -->
<!--     <label for="vehicleType">Vehicle Type <span>*</span></label> -->
<%-- 							<form:select class="form-control" path="vehicleType"> --%>
<%-- 								<form:option class="first-op" value="">Select</form:option> --%>
<%-- 								<form:option value="Dont Own a Vehicle"></form:option> --%>
<%-- 								<form:option value="Others(Like- 3-Wheeler, etc)"></form:option> --%>
<%-- 								<form:option value="Four Wheeler"></form:option> --%>
<%-- 								<form:option value="Two Wheeler">Two Wheeler</form:option> --%>
<!-- 								<option>Freelance</option> -->
<%-- 							</form:select> --%>
<%-- 							<form:errors path="vehicleType" cssClass="error"></form:errors> --%>
<!--   </div> -->
  <div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="course">Course <span>*</span></label>
						<form:select class="form-control" path="course">
							<form:option value="">Select</form:option>
							<form:option value="B.tech">B.tech</form:option>
							<c:forEach var="course" items="${courses}">
								<form:option value="${course.id}"
									label="${course.courseTypeName}" />
							</c:forEach>
						</form:select>
						<form:errors path="course" cssClass="error"></form:errors>
					</div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="collegeName">College Name <span>*</span></label>
						<form:input id="collage-name" path="collegeName" type="text"
							placeholder="Collage-name" class="form-control" />
						<form:errors path="collegeName" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="havePc">Do You Have Own PC <span>*</span></label>
						<form:select class="form-control" path="havePc">
							<form:option class="first-op" value="false">Select</form:option>
							<form:option value="true">Yes</form:option>
							<form:option value="false">No</form:option>
						</form:select>
						<form:errors path="havePc" cssClass="error"></form:errors>
					</div>
					<div class="clear clearfix"></div>
					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="vehicleType">Vehicle Type <span>*</span></label>
						<form:select class="form-control" path="vehicleType">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="Dont Own a Vehicle"></form:option>
							<form:option value="Others(Like- 3-Wheeler, etc)"></form:option>
							<form:option value="Four Wheeler"></form:option>
							<form:option value="Two Wheeler">Two Wheeler</form:option>
							<!-- <option>Freelance</option> -->
						</form:select>
						<form:errors path="vehicleType" cssClass="error"></form:errors>
					</div>
					<div class="clear clearfix"></div>

					<div class="form-group col-xs-12 colbox">
						<label for="address">Address <span>*</span></label>
						<form:textarea class="form-control" id="address" name="address"
							path="addressLine1" rows="3" />
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="country">Country <span>*</span></label>
						<form:select name="country" class="form-control" path="country">
							<form:option value="">Please select</form:option>
							<form:option value="India">India</form:option>
						</form:select>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="state">State <span>*</span></label>
						<form:select path="state" id="editState" class="form-control"
							onchange="myFunction()">
							<form:option class="first-op" value="">Select</form:option>
							<c:forEach var="state" items="${states}">
								<form:option value="${state[1]}" label="${state[1]}" />
							</c:forEach>
						</form:select>
						<c:if test="${not empty otherDetails.state}">
							<h4 style="color: #f15336">
								Selected: <span style="color: #A4A4A4;">${otherDetails.state}</span>
							</h4>
						</c:if>
						<form:errors path="state" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="city">City <span>*</span></label>
						<form:select path="city" id="cityDropDown" class="form-control">
							<option value="">Select</option>
							<c:forEach var="state" items="${states}">
								<form:option value="${state[1]}" label="${state[1]}" />
							</c:forEach>
						</form:select>
						<form:errors path="city" cssClass="error"></form:errors>
						<c:if test="${not empty otherDetails.city}">
							<h4 style="color: #f15336">
								Selected: <span style="color: #A4A4A4;">${otherDetails.city}</span>
							</h4>
						</c:if>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="locality">Locality <span>*</span></label>
						<%-- <form:select name="locality" class="form-control">
								<form:option value="">Please select</form:option>
								<form:option value="sec49">Sec 49</form:option>
							</form:select> --%>

						<form:input class="form-control" type="text"
							placeholder="Locality" id="locality" path="locality" />
					</div>

					<div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="landmark">Landmark </label>
						<form:input id="landmark" path="landmark" type="text"
							placeholder="Landmark" class="form-control" />
					</div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="postalCode">Postal Code <span>*</span></label>
						<form:input id="postal-code" path="postalCode" type="text"
							placeholder="zip or postal code" class="form-control" />
						<form:errors path="postalCode" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="jobCategories">Job Categories (Select Upto 5)<span>*</span></label>
						<form:select class="form-control" path="jobCategories"
							multiple="true" maxlength="5" minlength="1">
							<form:option value="">Select</form:option>
					
							<c:forEach var="category" items="${categories}">
								<form:option value="${category.id}"
									label="${category.categoryName}" />
							</c:forEach>
						</form:select>
						<c:if test="${not empty otherDetails.jobCategories}">
							<h4 style="color: #f15336">
								Selected: <span style="color: #A4A4A4;"><c:forEach
										var="category" items="${otherDetails.jobCategories}">
										<span>${category.categoryName}</span>&nbsp;&nbsp;</c:forEach></span>
							</h4>
						</c:if>
					</div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="preference">Preference <span>*</span></label>
						<form:select path="preference" class="form-control">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="Other Onsite Job (Warehouse/Factory etc)">Other Onsite Job (Warehouse/Factory etc)</form:option>
							<form:option value="Remote/ Online Job">Remote/ Online Job</form:option>
							<form:option value="Field Job">Field Job</form:option>
							<form:option value="Office Job">Office Job</form:option>
						</form:select>
						<form:errors path="preference" cssClass="error"></form:errors>
						<c:if test="${not empty otherDetails.preference}">
							<h4 style="color: #f15336">
								Selected: <span style="color: #A4A4A4;">${otherDetails.preference}</span>
							</h4>
						</c:if>
					</div>

					<div class="clear clearfix"></div>
<!-- 					<div class="form-row"> -->
<!-- 						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb"> -->
<!-- 							<button type="submit">Save</button> -->
<!-- 						</div> -->
<!-- 					</div> -->

				</form:form>
				
<%-- 				<form:form action="/updatedocs.html" method="post" modelAttribute="studentDocs" enctype="multipart/form-data"> --%>

<!-- 				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 address">  -->
<!--  					<h4>Upload Documents</h4>  -->
<!--  				</div>  -->

<!--  				<div class="form-group col-sm-6 col-xs-12 colbox">  -->
<!--  					<label for="aadhar">Aadhar Card <span>*</span></label> <input  -->
<!--  						type="file" name="aadhar" class="custom-file-input"  -->
<!--  						id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">  -->

<!--  				</div>  -->

<!--  				<div class="form-group col-sm-6 col-xs-12 colbox">  -->
<!--  					<label for="studentId">Student Id <span>*</span></label>  -->
<!--  					<div class="custom-file">  -->
<!--  						<input type="file" name="studentId" class="custom-file-input"  -->
<!--  							id="inputGroupFile01" aria-describedby="inputGroupFileAddon01"> -->
<!--  					</div>  -->
<!--  				</div>  -->

<!-- 				<div class="clear clearfix"></div>  -->

<!--  				<div class="form-group col-sm-3 col-xs-12 colbox">  -->
<!--  					<label for="paymentMethod">Payment Method <span>*</span></label>  -->
<%-- 					<form:select onchange='checkItem(this.value)' class="form-control"  --%>
<%-- 						path="paymentMethod"> --%>
<%-- 						<form:option class="first-op" value="">Select</form:option> --%>
<%-- 						<form:option value="Bank Account"></form:option> --%>
<%-- 						<form:option value="Wallet"></form:option> --%>
<%-- 					</form:select> --%>
<%-- 					<form:errors path="paymentMethod" cssClass="error"></form:errors> --%>
<!-- 				</div> -->

<!-- 				<div class="form-group col-md-3 ba-class"> -->
<!-- 					<label for="inputother" style="display: none;" id="BA">Bank -->
<!-- 						Name <span>*</span> -->
<!-- 					</label> <input type="text" class="form-control" id="text" name="text" -->
<!-- 						style="display: none;" placeholder="Bank Name"> -->
<!-- 				</div> -->
<!-- 				<div class="form-group col-md-3 ba-class"> -->
<!-- 					<label for="inputother" style="display: none;" id="AC">Account -->
<!-- 						Number <span>*</span> -->
<!-- 					</label> <input type="text" class="form-control" id="text-1" name="text" -->
<!-- 						style="display: none;" placeholder="Account Number"> -->
<!-- 				</div> -->
<!-- 				<div class="form-group col-md-3 ba-class"> -->
<!-- 					<label for="inputother" style="display: none;" id="IC">IFSC -->
<!-- 						Code <span>*</span> -->
<!-- 					</label> <input type="text" class="form-control" id="text-3" name="text" -->
<!-- 						style="display: none;" placeholder="IFSC Code"> -->
<!-- 				</div> -->

<!-- 				<div class="form-group col-md-3 ba-class-1"> -->
<!-- 					<label for="inputother" style="display: none;" id="UPI">UPI -->
<!-- 						<span>*</span> -->
<!-- 					</label> <input type="text" class="form-control" id="text-4" name="text" -->
<!-- 						style="display: none;" placeholder="UPI"> -->
<!-- 				</div> -->
						

<!-- 				<div class="form-row"> -->
<!-- 					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb"> -->
<!-- 						<button onClick="bankandwallet()" type="submit">Save</button> -->
<!-- 					</div> -->
<!-- 				</div> -->

<%-- 				</form:form> --%>

				<div class="container-fluid">
					<div class="row two">
						<div class="container-fluid">

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<h4>Time slots choosen by Student</h4>
							</div>

						</div>
					</div>
					<div class="form-row">
<%-- 						<form:form action="/updatePreferences.html" method="post" --%>
<%-- 							modelAttribute="dayPreference"> --%>
<!-- 							<div class="form-row"> -->

<!-- 								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox"> -->
<!-- 									<h4> -->
<!-- 										Days <span>*</span> -->
<!-- 									</h4> -->

<%-- 									<form:select id="timeslotDay" class="form-control" path="day"> --%>
<%-- 										<form:option class="first-op" value="">Select</form:option> --%>
<%-- 										<form:option value="Monday"></form:option> --%>
<%-- 										<form:option value="Tuesday"></form:option> --%>
<%-- 										<form:option value="Wednesday"></form:option> --%>
<%-- 										<form:option value="Thrusday"></form:option> --%>
<%-- 										<form:option value="Friday"></form:option> --%>
<%-- 										<form:option value="Saturday"></form:option> --%>
<%-- 										<form:option value="Sunday"></form:option> --%>
<%-- 									</form:select> --%>
<!-- 									<div id="confirmMessageDay" class="error"></div> -->
<!-- 								</div> -->

<!-- 								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox"> -->
<!-- 									<h4> -->
<!-- 										Time-Slots <span>*</span> -->
<!-- 									</h4> -->
<%-- 									<form:select id="timeSlot" class="form-control" path="timeSlot"> --%>
<%-- 										<form:option value="">Select</form:option> --%>
<%-- 										<c:forEach var="timeSlot" items="${timeSlots}"> --%>
<%-- 											<form:option value="${timeSlot.id}" --%>
<%-- 												label="${timeSlot.timeSlotName}" /> --%>
<%-- 										</c:forEach> --%>

<%-- 									</form:select> --%>
<!-- 									<div id="confirmMessage" class="error"></div> -->
<!-- 								</div> -->

<!-- 							</div> -->
<!-- 							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb"> -->
<!-- 								<button type="submit" onclick="return validate()">Add</button> -->
<!-- 							</div> -->
<%-- 						</form:form> --%>
						<br /> <br />
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxtable">
							<table id="myTable">
								<thead>
									<tr>
										<th scope="col">Days</th>
										<th scope="col">Time-Slots</th>
<!-- 										<th scope="col">Action</th> -->
									</tr>
								</thead>
								<tbody>
									<c:forEach var="dayPreference" items="${otherDetails.preferences}">
										<tr>	
											<th scope="row">${dayPreference.day}</th>
											<td>${dayPreference.timeSlot.timeSlotName}</td>
										</tr>
									</c:forEach>
								</tbody>
								<!-- <tr>
                                    <td>Row1 cell1</td>
                                    <td>Row1 cell2</td>
                                    </tr> -->
							</table>
							<br>

							<!-- <button onclick="myCreateFunction()">Create row</button> -->

						</div>
						<div class="col-lg-6 col-md-6"></div>
					</div>

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
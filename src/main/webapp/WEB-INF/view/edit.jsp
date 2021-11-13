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
<link href="assets/css/jquery-ui.css" rel="stylesheet">
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


<!-- 	    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script> -->
<!--     <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<link
	href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">



<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

<style>

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

<style>
.avatar-upload {
	position: relative;
	max-width: 140px;
	margin: 20px auto;
	margin-left: 2px;
}

.avatar-upload .avatar-edit {
	position: absolute;
	right: 12px;
	z-index: 1;
	top: 10px;
}

.avatar-upload .avatar-edit input {
	display: none;
}

.avatar-upload .avatar-edit input+label {
	display: inline-block;
	width: 30px;
	height: 30px;
	margin-bottom: 0;
	border-radius: 100%;
	background: #FFFFFF;
	border: 1px solid transparent;
	box-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.12);
	cursor: pointer;
	font-weight: normal;
	transition: all .2s ease-in-out;
}

.avatar-upload .avatar-edit input+label:hover {
	background: #f1f1f1;
	border-color: #d6d6d6;
}

.avatar-upload .avatar-edit input+label:after {
	content: "\f040";
	font-family: 'FontAwesome';
	color: #757575;
	position: absolute;
	top: 5px;
	left: 0;
	right: 0;
	text-align: center;
	margin: auto;
}

.avatar-upload .avatar-preview {
	width: 134px;
	height: 134px;
	position: relative;
	border-radius: 100%;
	border: 6px solid #F8F8F8;
	box-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.1);
}

.avatar-upload .avatar-preview>div {
	width: 100%;
	height: 100%;
	border-radius: 100%;
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
}

.error {
	color: #a94442;
	font-style: italic;
	font-weight: bold;
}

.colbox span {
	color: red;
	font-size: 17px;
}

input[type=file] {
	color: white;
}

.ba-class {
	margin-top: 16px;
}

.ba-class-1 {
	margin-top: -16px;
}

.ba-class label {
	color: white;
}

.ba-class-1 label {
	color: white;
}

.ba-class label span {
	color: red;
	font-size: 17px;
}

.ba-class-1 label span {
	color: red;
	font-size: 17px;
}

.upload-img {
	margin-top: -12px;
}


.container-check { border:2px solid #ccc; width:100%; height: 100px; overflow-y: scroll; }

.checkbox {color:black}
</style>

</head>

<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a href="student-d.html"><img
					src="assets-2/img/icons/Genzest Logo.png" alt=""
					class="img-responsive logo"></a></a>



				<ul class="sidebar-nav">
					<br>

					<li class="sidebar-item top"><a class="sidebar-link first"
						href="student-d.html"><i class="fa fa-user-circle-o align-middle"
							aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>${user.firstName}
							</b></span>
							<p style="margin-left: 7.5rem; margin-top: -.9rem;">Student</p> </a>
					</li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="student-d.html"><i class="align-middle"
							data-feather="home"></i> <span class="align-middle"><b>Dashboard</b></span>
					</a></li>



					<li class="sidebar-item active"><a class="sidebar-link"
						href="profile.html"><i class="fa fa-user-o align-middle"
							style="font-size: 19px"></i> <span class="align-middle"><b>My
									Profile</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="searchjobs.html"><i class="fa fa-search align-middle"
							style="font-size: 19px"></i> <span class="align-middle"><b>Search
									Jobs</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="earning.html"><i class="fa fa-money align-middle"
							style="font-size: 19px"></i> <span class="align-middle"><b>My
									Earnings</b></span> </a></li>

					<li class="sidebar-item"><a class="sidebar-link"
						href="appliedjobs.html"><i
							class='fa fa-check-square-o align-middle' style='font-size: 19px'></i>
							<span class="align-middle"><b>Applied Jobs</b></span> </a></li>

				</ul>

				<!-- DOWNLOAD APP TRANSPARENT BOX -->
				
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
				<a class="nav-link dropdown-toggle d-none d-sm-inline-block"
					href="#" data-bs-toggle="dropdown"> </a>

				<div class="dropdown-menu dropdown-menu-end">
					<i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;<a href="/logout"> Logout </a>
				</div>
			</nav>

			<main class="content">

				<a href="profile.html"><button class="back"
									style="float: right; margin: 1rem; color: white;">
									Back <i class="fa fa-chevron-circle-left" aria-hidden="true"></i>
								</button></a>

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
												--></div>
										</c:if>

									</div>


								</div>
							</div>
						</div>

					</div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="firstName">First Name <span>*</span></label>
						
						<form:input path="firstName" placeholder="First Name"
							class="form-control" type="text" value="${user.firstName}" readonly="true" />
						<form:errors path="firstName" cssClass="error"></form:errors>
						
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="lastName">Last Name <span>*</span></label>
						<form:input path="lastName" placeholder="Last Name"
							class="form-control" type="text" value="${user.lastName}" readonly="true"/>
						<form:errors path="lastName" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="email">Email <span>*</span></label>
						<form:input class="form-control" path="email"
							placeholder="Drop Your Mail Id" type="email" id="example-email-input"
							value="${user.email}"  readonly="true"/>
						<form:errors path="email" cssClass="error"></form:errors>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="parentsName">Parent's Name <span>*</span></label>
						<c:if test="${empty profile.parentsName }">
						<form:input path="parentsName" placeholder="Parents Name"
							class="form-control" type="text" />
							</c:if>
							<c:if test="${not empty profile.parentsName }">
							<form:input path="parentsName" placeholder="Parents Name"
							class="form-control" type="text" readOnly="true" />
							</c:if>
						<form:errors path="parentsName" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="gender">Gender <span>*</span></label>
						<c:if test="${empty profile.gender }">
						<form:select path="gender" class="form-control">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></c:if>
						<c:if test="${not empty profile.gender }">
						<form:input path="gender" placeholder="Gender"
							class="form-control" type="text" readOnly="true" />
						</c:if>
						<form:errors path="gender" cssClass="error"></form:errors>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
					
						<label for="dob">Date of Birth <span>*</span></label>
						<c:if test="${empty profile.dob }">
							<form:input type="date" class="form-control" path="dob"
							onfocusout="ageCalculation()" placeholder="DD/MM/YYYY"
							name="birthday"/>
							</c:if>
							<c:if test="${not empty profile.dob }">
							<form:input type="date" class="form-control" path="dob"
							onfocusout="ageCalculation()" placeholder="DD/MM/YYYY"
							name="birthday" readonly="true"/>
							</c:if>
						<form:errors path="dob" cssClass="error"></form:errors>

					</div>

					<div class="clear clearfix"></div>



					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="bloodGroup">Blood Group <span>*</span></label>
						<c:if test="${empty profile.bloodGroup }">
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
						</c:if>
						<c:if test="${not empty profile.bloodGroup }">
						<form:input type="text" class="form-control" path="bloodGroup"
							 placeholder="Blood Group"
							name="bloodgroup" readonly="true"/>
						</c:if>
						<form:errors path="bloodGroup" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>
						
<%-- 						<c:if test="${editable}"> --%>
					<div class="form-row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
							<button type="submit">Save</button>
						</div>
					</div>
<%-- 					</c:if> --%>

				</form:form>

				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 address">
					<h4>Other Details</h4>
				</div>

				<form:form action="/updateOtherDetails.html" method="post"
					modelAttribute="otherDetails" enctype="multipart/form-data"
					id="otherdetailsform">
					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="mobileNo">Mobile No <span>*</span></label>
						<c:if test="${empty otherDetails.mobileNo }">
						<form:input class="form-control" path="mobileNo"
							placeholder="Mobile no" id="mobileNo"
							value="${user.phoneNo}" />
						</c:if>
						<c:if test="${not empty otherDetails.mobileNo }">
						<form:input class="form-control" path="mobileNo"
							placeholder="Mobile no" id="mobileNo"
							 />
						</c:if>
						<form:errors path="mobileNo" cssClass="error"></form:errors>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="alternateMobileNo">Alternate Mobile No <span>*</span></label>
						<form:input class="form-control" path="alternateMobileNo"
							placeholder="Alternate Mobile no" id="alternateMobileNo" />
						<form:errors path="alternateMobileNo" cssClass="error"></form:errors>
						<div id="alternateMobileNoDiv" class="error"></div>
					</div>

					<div class="clear clearfix"></div>
					
					  <div class="form-group col-sm-6 col-xs-12 colbox">
					    <label for="degreeCollegeCompletionDate">Tentative Degree Completion Date <span>*</span></label>
												<form:input class="form-control" type="date" onchange="ageCalculationtwo()" 
													placeholder="MM/DD/YYYY" id="degreeCollegeCompletionDate"
													path="degreeCollegeCompletionDate"/>
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
						<form:select class="form-control" path="course"  >
						
							<form:option value="">Select</form:option>
							
							<c:forEach var="course" items="${courses}">
								<form:option value="${course.courseTypeName}"
									label="${course.courseTypeName}" />
							</c:forEach>
						</form:select>
						<form:errors path="course" cssClass="error"></form:errors>
					</div>
					
					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="specialization">Specialization <span></span></label>
						<form:input class="form-control" path="specialization"
							placeholder="Specialization field" id="specialization" />
						<form:errors path="specialization" cssClass="error"></form:errors>
						
					</div>
					

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="collegeName">College Name <span>*</span></label>
						<form:input id="collage-name" path="collegeName" type="text"
							placeholder="College-name" class="form-control" />
						<form:errors path="collegeName" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="doHavePc">Do You Have Own PC <span>*</span></label>
						<form:select class="form-control" path="doHavePc">
							<form:option class="first-op" value="">Select</form:option>
							<form:option value="true">Yes</form:option>
							<form:option value="false">No</form:option>
						</form:select>
						<form:errors path="doHavePc" cssClass="error"></form:errors>
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
<%-- 						<c:if test="${not empty otherDetails.state}"> --%>
<!-- 							<h4 style="color: #f15336"> -->
<%-- 								Selected: <span style="color: #A4A4A4;">${otherDetails.state}</span> --%>
<!-- 							</h4> -->
<%-- 						</c:if> --%>
						<form:errors path="state" cssClass="error"></form:errors>
					</div>

					<div class="clear clearfix"></div>

					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="city">City <span>*</span></label>
						<form:select path="city" id="cityDropDown" class="form-control" onchange="selectLocality()">
							<option value="">Select</option>
							<c:forEach var="city" items="${cities}">
								<form:option  value="${city[1]}" label="${city[1]}"  />
							</c:forEach>
						</form:select>
						<form:errors path="city" cssClass="error"></form:errors>
<%-- 						<c:if test="${not empty otherDetails.city}"> --%>
<!-- 							<h4 style="color: #f15336"> -->
<%-- 								Selected: <span style="color: #A4A4A4;">${otherDetails.city}</span> --%>
<!-- 							</h4> -->
<%-- 						</c:if> --%>
					</div>

					<div class="form-group col-sm-6 col-xs-12 colbox" id="localityDiv">
						<label for="locality">Locality <span>*</span></label>
						 <form:select path="otherLocality" name="locality" class="form-control">
						 <form:option value="">Please Select</form:option>
								<form:option value="Aerodrum Road">Aerodrum Road</form:option>
								<form:option value="Annapurna Road">Annapurna Road</form:option>
								<form:option value="Dewas Naka">Dewas Naka</form:option>
								<form:option value="Jail Road">Jail Road</form:option>
								<form:option value="Jawahar Marg">Jawahar Marg</form:option>
								<form:option value="Khandwa Road">Khandwa Road</form:option>
								<form:option value="Malharganj">Malharganj</form:option>
								<form:option value="Malwa Mill">Malwa Mill</form:option>
								<form:option value="Manik Bagh">Manik Bagh</form:option>
								<form:option value="Musakhedi">Musakhedi</form:option>
								<form:option value="Navlakha">Navlakha</form:option>
								<form:option value="Palasia">Palasia</form:option>
								<form:option value="Palda">Palda</form:option>
								<form:option value="Rajendra Nagar">Rajendra Nagar</form:option>
								<form:option value="Ram Bagh">Ram Bagh</form:option>
								<form:option value="Rau">Rau</form:option>
								<form:option value="RNT Marg">RNT Marg</form:option>
								<form:option value="Sapna Sangeeta">Sapna Sangeeta</form:option>
								<form:option value="Super Corridor">Super Corridor</form:option>
								<form:option value="Vijay Nagar">Vijay Nagar</form:option>
								
							</form:select>
<%-- 						<form:input class="form-control" type="text" --%>
<%-- 							placeholder="Locality" id="locality" path="locality" /> --%>
					</div>
					
					<div class="form-group col-sm-6 col-xs-12 colbox" id="localityInputDiv">
						<label for="locality">Locality <span>*</span></label>
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
						
						
						<div class="container-check ">
    						<form:checkboxes  items = "${categories}" element="div"   itemValue="id" itemLabel="categoryName" path = "jobCategories" onchange="checkBoxLimit()" /><br/></td> 
						</div>
						
					</div>


					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="preference">Job Type <span>*</span></label>
						<form:select path="preference" class="form-control">
							<form:option class="first-op" value="">Select</form:option>
							<c:forEach var="jobType" items="${jobTypes}">
											<form:option value="${jobType.jobTypeName}"
												label="${jobType.jobTypeName}" />
										</c:forEach>
<%-- 							<form:option value="Other Onsite Job (Warehouse/Factory etc)">Other Onsite Job (Warehouse/Factory etc)</form:option> --%>
<%-- 							<form:option value="Remote/ Online Job">Remote/ Online Job</form:option> --%>
<%-- 							<form:option value="Field Job">Field Job</form:option> --%>
<%-- 							<form:option value="Office Job">Office Job</form:option> --%>
<%-- 							<form:option value="Office Job">No Preference</form:option> --%>

						</form:select>
						<form:errors path="preference" cssClass="error"></form:errors>
<%-- 						<c:if test="${not empty otherDetails.preference}"> --%>
<!-- 							<h4 style="color: #f15336"> -->
<%-- 								Selected: <span style="color: #A4A4A4;">${otherDetails.preference}</span> --%>
<!-- 							</h4> -->
<%-- 						</c:if> --%>
					</div>
					
					<div class="form-group col-sm-6 col-xs-12 colbox">
						<label for="referralCode">Referral Code <span>(Optional)</span></label>
						<form:input id="postal-code" path="referralCode" type="text"
							placeholder="Referral code" class="form-control" />
					</div>

<!-- 					<div class="form-group col-sm-6 col-xs-12 colbox"> -->
<!-- 						<div class="container-check"> -->
<%--     					<form:checkboxes  items = "${categories}"  itemValue="id" itemLabel="categoryName" path = "jobCategories" /><br/></td>  --%>
<!-- </div> -->

<!-- 					</div> -->
					<div class="clear clearfix"></div>
					<div class="form-row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
							<button type="submit" onclick="return checkAlternateMobileNo()">Save</button>
						</div>
					</div>

				</form:form>
				
				<form:form action="/updatedocs.html" method="post" modelAttribute="studentDocs" enctype="multipart/form-data"
				id="uploaddocumentform">

				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 address"> 
 					<h4>Upload Documents</h4> 
 				</div> 

 				<div class="form-group col-sm-6 col-xs-12 colbox"> 
 					<label for="aadhar">Aadhar Card <span>*</span></label> <input 
 						type="file" name="aadhar" class="custom-file-input" 
 						id="inputGroupFile01" aria-describedby="inputGroupFileAddon01"> 
						<c:if test="${not empty studentDocs.aadharFileName}">
							<h4 style="color: #f15336">
								Aadhar Card uploaded : <span style="color: #A4A4A4;"><a href="/getProfilePic/${studentDocs.aadharFileName}">View</a></span>
							</h4>
							
							<input id="adhar" type="hidden"
							placeholder="aadhar" class="form-control" value="${studentDocs.aadharFileName}" >
						</c:if>
 				</div> 
	

 				<div class="form-group col-sm-6 col-xs-12 colbox"> 
 					<label for="studentId">Student Id <span>*</span></label> 
 					<div class="custom-file"> 
 						<input type="file" name="studentId" class="custom-file-input" 
 							id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
 					</div> 
 					<c:if test="${not empty studentDocs.studentIdFileName}">
							<h4 style="color: #f15336">
								Student Id uploaded : <span style="color: #A4A4A4;"><a href="/getProfilePic/${studentDocs.studentIdFileName}">View</a></span>
							</h4>
							
							<input id="studentId" type="hidden"
							placeholder="student id" class="form-control" value="${studentDocs.studentIdFileName}" >
						</c:if>
 					
 				</div> 

				<div class="clear clearfix"></div> 

 				<div class="form-group col-sm-3 col-xs-12 colbox"> 
 					<label for="paymentMethod">Payment Method <span>*</span></label> 

					<form:select  class="form-control" 
 						path="paymentMethod"> 
						<form:option class="first-op" value="">Select</form:option>
						<form:option value="Bank Account"></form:option>
						<form:option value="Wallet"></form:option>
					</form:select>
					<form:errors path="paymentMethod" cssClass="error"></form:errors>
				</div>

				<div class="form-group col-md-3 ba-class">
					<label for="inputother" style="display: none;" id="BA">Bank
						Name <span>*</span>
					</label> 
					<form:input type="text" class="form-control" id="text" name="text"
						style="display: none;" placeholder="Bank Name" path="bankName"/>
				</div>
				<div class="form-group col-md-3 ba-class">
					<label for="inputother" style="display: none;" id="AC">Account
						Number <span>*</span>
					</label> <form:input type="text" class="form-control" id="text-1" name="text"
						style="display: none;" placeholder="Account Number" path="accountName"/>
				</div>
				<div class="form-group col-md-3 ba-class">
					<label for="inputother" style="display: none;" id="IC">IFSC
						Code <span>*</span>
					</label> <form:input type="text" class="form-control" id="text-3" name="text"
						style="display: none;" placeholder="IFSC Code" path="ifscCode"/>
				</div>

				<div class="form-group col-md-3 ba-class-1">
					<label for="inputother" style="display: none;" id="UPI">UPI
						<span>*</span>
					</label> <form:input type="text" class="form-control" id="text-4" name="text"
						style="display: none;" placeholder="UPI" path="upiId"/>
				</div>
						

				<div class="form-row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
						<button onClick="bankandwallet()" type="submit">Save</button>
					</div>
				</div>

				</form:form>

				<div class="container-fluid">
					<div class="row two">
						<div class="container-fluid">

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<h4>Your Availability (You may provide convenient day and
									timeslots when you are free for doing a job)</h4>
							</div>

						</div>
					</div>
					<div class="form-row">
						<form:form action="/updatePreferences.html" method="post"
							modelAttribute="dayPreference">
							<div class="form-row">

								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
									<h4>
										Days <span>*</span>
									</h4>

									<form:select id="timeslotDay" class="form-control" path="day">
										<form:option class="first-op" value="">Select</form:option>
										<form:option value="Monday"></form:option>
										<form:option value="Tuesday"></form:option>
										<form:option value="Wednesday"></form:option>
										<form:option value="Thursday"></form:option>
										<form:option value="Friday"></form:option>
										<form:option value="Saturday"></form:option>
										<form:option value="Sunday"></form:option>
									</form:select>
									<div id="confirmMessageDay" class="error"></div>
								</div>

								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
									<h4>
										Time-Slots <span>*</span>
									</h4>
									<form:select id="timeSlot" class="form-control" path="timeSlot">
										<form:option value="">Select</form:option>
										<c:forEach var="timeSlot" items="${timeSlots}">
											<form:option value="${timeSlot.id}"
												label="${timeSlot.timeSlotName}" />
										</c:forEach>

									</form:select>
									<div id="confirmMessage" class="error"></div>
								</div>

							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
								<button type="submit" onclick="return validate()">Add</button>
							</div>
						</form:form>
						<br /> <br />
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxtable">
							<table id="myTable">
								<thead>
									<tr>
										<th scope="col">Days</th>
										<th scope="col">Time-Slots</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="dayPreference" items="${otherDetails.preferences}">
										<tr>	
											<th scope="row">${dayPreference.day}</th>
											<td>${dayPreference.timeSlot.timeSlotName}</td>
											<td><a href="deletePreference.html?preferenceId=${dayPreference.id}"  onclick="return confirm('Are you sure?')"><i class="fa fa-trash"/></a></td>
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
	<script src="assets-2/js/app.js"></script>
	<script src="https://material-ui.com/components/tables/#DataTable.js"></script>
	<script src="assets/js/jquery-1.11.1.js"></script>
	<script src="assets/js/jquery-ui.min.js"></script>
	<script src="assets/js/jquery.validate.js"></script>
	<script src="assets/validatejs/editstudentprofile.js"></script>
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

	<script>
function myFunction() {
  var x = document.getElementById("editState").value;
  $.ajax({
		type: 'GET',
		url: '${pageContext.request.contextPath}/loadCitiesByState/' + x,
		success: function(result) {
			var s = '';
			s+= '<option value="">Select</option>'
			for(var i = 0; i < result.length; i++) {
				//s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
				
				s += '<option value="'+result[i][1]+'">'+result[i][1]+'</option>'
			}
			console.log(s);
			$('#cityDropDown').html(s);
		}
	});
}
</script>

	<script type="text/javascript">
    function validate() {
        var timeSlot = document.getElementById("timeSlot").value;
        var timeslotDay = document.getElementById("timeslotDay").value;
        if(!timeslotDay){
        	document.getElementById("confirmMessageDay").innerHTML = "Day Not Selected";
        	return false;
        }
        
        if(!timeSlot){
        	document.getElementById("confirmMessage").innerHTML = "TimeSlot Not Selected";
        	return false;
        }
        return true;
    }
</script>

	<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${not empty successMessage}">
		toastr.success('${successMessage}', 'Success Alert', {timeOut: 5000})
		</c:if>
		<c:remove var="successMessage" scope="session"/>
			<c:remove var="successMessage" scope="request"/>
	});
	
 	$(document).ready(function(){
 		var val =$('#paymentMethod').val();
 		if(val === "Bank Account"){
 	        document.getElementById('BA').style.display='block';
 	        document.getElementById('text').style.display='block';
 	        
 	        document.getElementById('AC').style.display='block';
 	        document.getElementById('text-1').style.display='block';
 	        
 	        document.getElementById('IC').style.display='block';
 	        document.getElementById('text-3').style.display='block';
 	      }
 	      else{
 	        document.getElementById('text').value=""; 
 	        document.getElementById('BA').style.display='none';
 	        document.getElementById('text').style.display='none';
 	        
 	        document.getElementById('AC').style.display='none';
 	        document.getElementById('text-1').style.display='none';
 	        
 	        document.getElementById('IC').style.display='none';
 	        document.getElementById('text-3').style.display='none';
 	      }
 	      
 	      if(val === "Wallet"){
 	    	  document.getElementById('UPI').style.display='block';
 	          document.getElementById('text-4').style.display='block';
 	      }
 	      else{
 	          document.getElementById('UPI').style.display='none';
 	          document.getElementById('text-4').style.display='none';
 	      }
 	});
	
	
	$(document).ready(function(){
		<c:if test="${not empty warningMessage}">
		toastr.warning('${warningMessage}', 'Warning Alert', {timeOut: 5000})
		</c:if>
		<c:remove var="warningMessage" scope="session"/>
			<c:remove var="warningMessage" scope="request"/>
	});
	
	$(document).ready(function(){
		<c:if test="${not empty errorMessage}">
		toastr.error('${errorMessage}', 'Error Alert', {timeOut: 5000})
		</c:if>
		<c:remove var="errorMessage" scope="session"/>
			<c:remove var="errorMessage" scope="request"/>
	});
	
	</script>


	<script>
	$(function() {
	    $("#birthday").datepicker({
	       //showOn: both - datepicker will appear clicking the input box as well as the calendar icon
	       //showOn: button - datepicker will appear only on clicking the calendar icon
	       showOn: 'both',
	       //you can use your local path also eg. buttonImage: 'images/x_office_calendar.png'
	       buttonImage: 'https://theonlytutorials.com/demo/x_office_calendar.png',
	       buttonImageOnly: true,
	       changeMonth: true,
	       changeYear: true,
	       showAnim: 'slideDown',
	       duration: 'fast',
	       dateFormat: 'dd-mm-yy'
	    });
	});
	</script>

	<script>
  function ageCalculation(){

	  var currentDate = new Date();
	  var val = document.getElementById("dob").value;
	  var birthDate = new Date(val);
	  var difference = currentDate - birthDate;
	  
	  var differenceInYears = Math.floor(difference / (1000 * 60 * 60 * 24 * 365.25));
	  if(birthDate > currentDate) {
	    window.alert("Please Select Valid Date of Birth ");
	    document.getElementById('dob').value = "";
	  } else {
		  return true;
	  }
	}
  </script>

	<script>
  function ageCalculationtwo(){
	var futureDateval = "2099-12-12";
	var futureDate = new Date(futureDateval);
	  var val = document.getElementById("degreeCollegeCompletionDate").value;
	  var birthDate = new Date(val);
	  
	  
		
	  if(birthDate > futureDate) {
	    window.alert("Date selected is out of range");
	    document.getElementById('degreeCollegeCompletionDate').value = "";
	  } else {
		  return true;
	  }
	}
  </script>

	<script>
  
  function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function(e) {
	            $('#imagePreview').css('background-image', 'url('+e.target.result +')');
	            $('#imagePreview').hide();
	            $('#imagePreview').fadeIn(650);
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	$("#imageUpload").change(function() {
	    readURL(this);
	});
  
  </script>

	<script>
  var itm = document.getElementById('paymentMethod');
  function checkItem(val)
  {
      if(val === "Bank Account"){
        document.getElementById('BA').style.display='block';
        document.getElementById('text').style.display='block';
        
        document.getElementById('AC').style.display='block';
        document.getElementById('text-1').style.display='block';
        
        document.getElementById('IC').style.display='block';
        document.getElementById('text-3').style.display='block';
      }
      else{
        document.getElementById('text').value=""; 
        document.getElementById('BA').style.display='none';
        document.getElementById('text').style.display='none';
        
        document.getElementById('AC').style.display='none';
        document.getElementById('text-1').style.display='none';
        
        document.getElementById('IC').style.display='none';
        document.getElementById('text-3').style.display='none';
      }
      
      if(val === "Wallet"){
    	  document.getElementById('UPI').style.display='block';
          document.getElementById('text-4').style.display='block';
      }
      else{
          document.getElementById('UPI').style.display='none';
          document.getElementById('text-4').style.display='none';
      }
  }
  </script>

	<script>
  	function bankandwallet(){
  	  var value = document.getElementById('paymentMethod').value;
  		var BA = document.getElementById("text").value;
  		var AC = document.getElementById("text-1").value;
  		var IFSC = document.getElementById("text-3").value;
  		var UPI = document.getElementById("text-4").value;
  		 if(value === "Bank Account"){
  			 console.log("in bank acc.");
  			 if(BA === ""){
  				 console.log("in bank name.");
  				 window.alert("Please Fill Bank Name");
  				 return false;
  			 }else{
  				 return true;
  			 }
  			 if(AC === ""){
  				 window.alert("Please Fill Account Number");
  				return false;
  			 }else {
  				 return true;
  			 }
  			 if(IFSC === ""){
  				 window.alert("Please Fill IFSC Code");
  				return false;
  			 }else{
  				 return true;
  			 }
  		 }else if(value === "Wallet"){
  			 
  			 if(UPI === ""){
  				 window.alert("Please Fill UPI");
  				 return false;
  			 }else{
  				 return true;
  			 }
  		 }
  	}
  </script>
  
     <script>
    function checkAlternateMobileNo() {
    	
    	var checkedcount = 0;
    	var checkBoxGroup = document.getElementsByName('jobCategories');			
    	
    	
    			for (var i = 0; i < checkBoxGroup.length; i++) {
    				checkedcount += (checkBoxGroup[i].checked) ? 1 : 0;
    			}
    			
    			if (checkedcount == 0) {
    				console.log("Please select atleast one job category");
    				alert("Please select atleast one job category");						
    				return false;
    			}
    		
    	
        var mobile = $("#mobileNo").val();
        var alternateMobile = $("#alternateMobileNo").val();
        if (mobile == alternateMobile){
            $("#alternateMobileNoDiv").html("Alternate Mobile Number can not be same as mobile no.");
            document.getElementById("alternateMobileNoDiv").scrollIntoView();
            return false;
        }else
        	{
        	
        	return true;
        	
        	}
        
        
    }
    
    
    function checkBoxLimit() {
    	var checkBoxGroup = document.getElementsByName('jobCategories');			
    	var limit = 5;
    	for (var i = 0; i < checkBoxGroup.length; i++) {
    		checkBoxGroup[i].onclick = function() {
    			var checkedcount = 0;
    			for (var i = 0; i < checkBoxGroup.length; i++) {
    				checkedcount += (checkBoxGroup[i].checked) ? 1 : 0;
    			}
    			
    			if (checkedcount > limit) {
    				console.log("You can select maximum of " + limit + " Job Categories.");
    				alert("You can select maximum of " + limit + " Job Categories.");						
    				this.checked = false;
    			}
    		}
    	}
    }
    
    
    function selectLocality()
    {
    	var city = document.getElementById('cityDropDown').value;
    	if(city==="Indore")
    	{
    		document.getElementById('localityInputDiv').style.display = 'none';
    		document.getElementById('localityDiv').style.display = 'block';
    	}else
    	{
    		document.getElementById('localityDiv').style.display = 'none';
    		document.getElementById('localityInputDiv').style.display = 'block';
    	}
    	
    }
    
    
    $(document).ready(function(){
    	var city = document.getElementById('cityDropDown').value;
    	if(city==="Indore")
    	{
    		document.getElementById('localityInputDiv').style.display = 'none';
    		document.getElementById('localityDiv').style.display = 'block';
    	}else
    	{
    		document.getElementById('localityDiv').style.display = 'none';
    		document.getElementById('localityInputDiv').style.display = 'block';
    	}
	});
  
    </script>


</body>

</html>
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

	<link href="assets-2/css/app.css" rel="stylesheet">

	<link href="assets-2/css/style.css" rel="stylesheet">
	<link href="assets-2/css/style2.css" rel="stylesheet">
    <link href="assets-2/css/style3.css" rel="stylesheet">
    <link href="assets-2/css/edit.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<link href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">

<script src="//code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<!-- <script src="https://cdn.datatables.net/buttons/1.7.0/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.7.0/js/buttons.html5.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

       <style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

<style>
    .main{
        height: 2200px;
    }
       /* xs */
        @media (max-width: 767px) {
            .main{
                height: 5200px;
            }
        }
        /* sm */
        @media (min-width: 768px) and (max-width: 991px) {
            .main{
                height: 3200px;
            }
        }
        /* md */
        @media (min-width: 992px) and (max-width: 1199px) {
            .main{
                height: 2500px;
            }
        }
    .content .back{
		background-color: #F15336;
		padding: 1rem;
		float: right; 
		margin: 1rem;
		width: 8rem;
		border: none;
		border-radius: .5rem;
	}
	.content .back a{
		color: white;
		font-weight: bold;
		text-decoration: none;
	}
    form #category{
        width: 100%;
    }
    table, td {
        /* border: 1px solid black; */
        width: 100%;
        padding: 1.5rem;
        margin: .5rem;
    }
    table th{
        padding: 1.5rem;
        width: 50%;
        
    }
   table thead{
       border-bottom: 1px solid white;
   }
    .colboxtable{
        margin-top: 1rem;
    }
    /* sm */
    @media (min-width: 768px) and (max-width: 991px) {
        table thead{
            border-bottom: 1px solid white;
            width: 50%;
        }
        table th{
            /* padding: 1.5rem; */
            width: auto !important;
        }
    } 

    /* xs */
    @media (max-width: 767px) {
        form .colboxtable{
            width: 100%;
        }
        table th{
            /* padding: 1.5rem; */
            width: auto !important;
        }
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
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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

        .show {display: block;}

        .sidebar .sidebar-nav .sidebar-item a {
            height: 60px;
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
				<a href="index.html"><img src="assets-1/img/icons/Genzest Logo.png" alt="" class="img-responsive logo"></a></a>


				<ul class="sidebar-nav">
				<br>

				    <li class="sidebar-item top">
					<a class="sidebar-link first" href="index.html"><i class="fa fa-user-circle-o align-middle" aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>${user.firstName}</b><i class="fa fa-angle-down" aria-hidden="true"></i></span>
						<p style="margin-left: 7.5rem; margin-top: -.9rem;">Administrator</p>
            		</a>
				</li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="genzest-d.html"><i class="align-middle" data-feather="home"></i> <span class="align-middle"><b>Dashboard</b></span>
            		</a></li>

					<li class="sidebar-item active">
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

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="stud-genz.html"><i class="fa fa-smile-o align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Student</b></span>
                    </a></li>

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="searchcandi-genz.html"><i class="fa fa-search align-middle" style="font-size:19px"></i> <span class="align-middle"><b>Search Candidate</b></span>
                    </a></li>

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="searchjobs-genz.html"><i class="fa fa-magic align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Search Job</b></span>
                    </a></li>

                    <li class="sidebar-item">
                        <div class="dropdown">
                            <button onclick="myFunction()" class="dropbtn"><i class="fa fa-graduation-cap" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;  Master  <i class="fa fa-caret-down" aria-hidden="true"></i></button>
                            <div id="myDropdown" class="dropdown-content">
                                <a href="access-right-genz.html">Access Right</a>
                                <a href="team-genz.html">Team</a>
                                <a href="category-genz.html">Category</a>
                                <a href="jobtype-genz.html">Job Types</a>
                                <a href="timeslot-genz.html">Time Slot</a>
                                <a href="bloodgrp-genz.html">Blood Group</a>
                                <a href="course-genz.html">Courses</a>
                                <a href="vehicle-genz.html">Vehicle Type</a>
                                <a href="citystate-genz.html">City Country State</a>
                            </div>
                          </div>
                    </li>
				
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
				<a class="sidebar-toggle js-sidebar-toggle">
					<img src="assets-2/img/icons/Shape@1X (3).png">
               </a>
			   <h4><b>Jobs/ Openings</b></h4>

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
					<button class="btn-forth">Genzest Login</button>
					<button class="btn-fifth">Recruiter Login</button>
					<button class="btn-sixth">Student Login</button>
				</div> 
			</nav>

			<main class="content">
			
                <div class="row two">
                    <div class="container-fluid">
                        <!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <div id="profile-container">
                                <image id="profileImage" src="http://lorempixel.com/100/100" />
                            </div>
                            <input id="imageUpload" type="file" name="profile_photo" placeholder="Photo" required="" capture>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <h4>General profile (data once entered can not be altered)</h4>
                        </div> -->
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <button class="back" style="float: right; margin: 1rem;"><a href="jobs-genz.html">Back  <i class="fa fa-chevron-circle-left" aria-hidden="true"></i></a></button>
                        </div>
                    </div>
                </div>
				
                <div class="container-fluid">
                    <form:form action="/updatejobs-genz.html" method="post" modelAttribute="jobAccount">
                       <div class="form-row">
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                        <form:input id="id" name="id" path="id" placeholder="Job Name" type="hidden" class="form-control"/> 
                            <h4>Employer <span>*</span></h4>
                            <form:select class="form-control" path="employer">
                            <form:option value="">Select</form:option>
                            <c:forEach var="employer" items="${employers}">  
                            <form:option  value="${employer.id}" label="${employer.employerName}" />
                            </c:forEach>
                            </form:select>
                             <form:errors path="employer" cssClass="error"></form:errors>
                          </div>
                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>Job Name <span>*</span></h4>
                            <form:input id="jobName" name="jobName" path="jobName" placeholder="Job Name" class="form-control"/>
                             <form:errors path="employer" cssClass="error"></form:errors>
                          </div>
                          <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
                            <h4>Job Categories <span>*</span></h4>
                    
                            <form:select class="form-control" path="category">
                            <form:option value="">Select</form:option>
                            <c:forEach var="category" items="${categories}">  
                            <form:option  value="${category.id}" label="${category.categoryName}" />
                            </c:forEach>
                            </form:select>
                             <form:errors path="employer" cssClass="error"></form:errors>
                        </div>
                   
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>No of Vacancy <span>*</span></h4>
                            <div class="input-group">
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                         <span class="glyphicon glyphicon-minus"></span>
                                    </button>
                                </span>
                                <form:input type="text" path="noOfVacancy" id="quantity" name="quantity" class="form-control input-number" min="1" max="100"/>
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                    </button>
                                </span>
                            </div>
                             <form:errors path="employer" cssClass="error"></form:errors>
                        </div>

                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>Vacancy for Male <span>*</span></h4>
                            <div class="input-group">
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-left-minus-male btn btn-danger btn-number"  data-type="minus" data-field="">
                                        <span class="glyphicon glyphicon-minus"></span>
                                    </button>
                                </span>
                                <form:input type="text" path="vacancyForMale" id="quantity_male" name="quantity" class="form-control input-number" min="1" max="100"/>
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-right-plus-male btn btn-success btn-number" data-type="plus" data-field="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>Vacancy for Female <span>*</span></h4>
                            <div class="input-group">
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-left-minus-female btn btn-danger btn-number"  data-type="minus" data-field="">
                                    <span class="glyphicon glyphicon-minus"></span>
                                    </button>
                                </span>
                                <form:input type="text" path="vacancyForFemale" id="quantity_female" name="quantity" class="form-control input-number" min="1" max="100"/>
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-right-plus-female btn btn-success btn-number" data-type="plus" data-field="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>Vacancy for Any Other <span>*</span></h4>
                            <div class="input-group">
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-left-minus-other btn btn-danger btn-number"  data-type="minus" data-field="">
                                    <span class="glyphicon glyphicon-minus"></span>
                                    </button>
                                </span>
                                <form:input type="text" path="vacancyForOther" id="quantity_other" name="quantity" class="form-control input-number" min="1" max="100"/>
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-right-plus-other btn btn-success btn-number" data-type="plus" data-field="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

<!--                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox"> -->
<!--                             <h4>Effective From <span>*</span></h4> -->
<%--                             <form:input path="effectiveFrom" class="form-control" type="date" placeholder="MM/DD/YYYY" id="Effectivefrom" name="Effectivefrom" /> --%>
<!--                          </div> -->

<!--                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox"> -->
<!--                             <h4>Effective Till <span>*</span></h4> -->
<%--                             <form:input path="effectiveTill" class="form-control" type="date" placeholder="MM/DD/YYYY" id="Effectivefrom" name="Effectivefrom" /> --%>
<!--                          </div> -->

                         <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>Rate (per hr) <span>*</span></h4>
                            <form:input class="form-control" type="rate" placeholder="Rate" id="rate" name="rate" path="rate"/>
                             <form:errors path="employer" cssClass="error"></form:errors>
                         </div>

                     
                         <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4> Locality <span>*</span></h4>
                            <form:input id="locality" name="locality" type="text" placeholder="Locality" class="form-control" path="locality"/>
                         </div>
                         
                         <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
							<h4>
								State <span>*</span>
							</h4>
							<form:select path="state" id="editState" class="form-control" onchange="myFunction()">
								<form:option class="first-op" value="">Select</form:option>
									<c:forEach var="state" items="${states}">
									<form:option value="${state[1]}"
										label="${state[1]}" />
								</c:forEach>
							</form:select>

						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
							<h4>
								City <span>*</span>
							</h4>
							<form:select path="city"  id="cityDropDown" class="form-control">
								<option value="">Select</option>
							</form:select>
						</div>                         
                         <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4> Postal Code <span>*</span></h4>
                             <form:input id="postal-code" name="postal-code" path="postalCode" type="text" placeholder="zip or postal code" class="form-control" />
                         </div>
                         
                     
                      
                      
                         <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
                            <h4> Description <span>*</span></h4>
                           <form:textarea width="100%" type="textarea" style="padding: 1rem; width: 100%;" placeholder="Description" path="description" />
                         </div>

                         <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4> Job Code </h4>
                           <form:input path="jobCode" width="100%" type="text" style="padding: 1rem; width: 100%;" disabled="true"/>
                         </div>
                       </div>

                         <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
                            <button type="submit">Save</button>
                         </div>
                     </form:form>
                     
                     
               </div>

			 <div class="container-fluid">
                <div class="row two">
                    <div class="container-fluid">
                
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <h4>Add Time Slots (You may provide additional timeslots for this job)</h4>
                        </div>
                        
                    </div>
                </div>
                    <div class="form-row">
                       <form:form action="/updateJobTimeSlots.html" method="post"
					modelAttribute="jobTimeSlot">
                            <div class="form-row">
                            
<!--                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox"> -->
<!--                                 <h4>Days <span>*</span></h4> -->
                        
<!--                                 <select class="form-control" required> -->
<!--                                     <option value="">Select</option>  -->
<!--                                     <option value="Monday">Monday</option> -->
<!--                                     <option value="Tuesday">Tuesday</option> -->
<!--                                     <option value="Wednesday">Wednesday</option> -->
<!--                                     <option value="Thrusday">Thrusday</option> -->
<!--                                     <option value="Friday">Friday</option> -->
<!--                                     <option value="Saturday">Saturday</option> -->
<!--                                     <option value="Sunday">Sunday</option> -->
<!--                                 </select> -->
<!--                             </div> -->
                     <form:input id="id" name="id" type="hidden" placeholder="id" class="form-control" path="jobId" value="${jobAccount.id}"/>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 colbox">
                                <h4>Time-Slots <span>*</span></h4>
                                <form:select class="form-control" path="timeSlot">
										<form:option value="">Select</form:option>
										<c:forEach var="timeSlot" items="${timeSlots}">
											<form:option value="${timeSlot.id}"
												label="${timeSlot.timeSlotName}" />
										</c:forEach>
									</form:select>
                            </div>
                            
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
                                <button type="submit">Add</button>
                            </div>
                        </form:form>
                        <br/><br/>
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxtable">
                                <table id="myTable">
                                    <thead>
                                        <tr>
                                          <th scope="col">Job Code</th>
                                          <th scope="col">Time-Slots</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <tr>
                                        	 <c:forEach var="timeSlot" items="${jobAccount.timeSlots}">	
                                          <th scope="row">${jobAccount.jobCode}</th>
                                          <td>${timeSlot.timeSlotName}</td>
                                          </c:forEach>
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
            </div>

			</main>

		</div>
	</div>

    <script>
        $(document).ready(function(){

        var quantitiy=0;
        $('.quantity-right-plus').click(function(e){
                
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity').val());
                
                // If is not undefined
                    
                    $('#quantity').val(quantity + 1);

                
                    // Increment
                
            });

            $('.quantity-left-minus').click(function(e){
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity').val());
                
                // If is not undefined
            
                    // Increment
                    if(quantity>0){
                    $('#quantity').val(quantity - 1);
                    }
            });
            
        });
    </script>
    
    
      <script>
        $(document).ready(function(){

        var quantitiy=0;
        $('.quantity-right-plus-female').click(function(e){
                
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity_female').val());
                
                // If is not undefined
                    
                    $('#quantity_female').val(quantity + 1);

                
                    // Increment
                
            });

            $('.quantity-left-minus-female').click(function(e){
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity_female').val());
                
                // If is not undefined
            
                    // Increment
                    if(quantity>0){
                    $('#quantity_female').val(quantity - 1);
                    }
            });
            
        });
    </script>
    
    
      <script>
        $(document).ready(function(){

        var quantitiy=0;
        $('.quantity-right-plus-male').click(function(e){
                
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity_male').val());
                
                // If is not undefined
                    
                    $('#quantity_male').val(quantity + 1);

                
                    // Increment
                
            });

            $('.quantity-left-minus-male').click(function(e){
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity_male').val());
                
                // If is not undefined
            
                    // Increment
                    if(quantity>0){
                    $('#quantity_male').val(quantity - 1);
                    }
            });
            
        });
    </script>
    
      <script>
        $(document).ready(function(){

        var quantitiy=0;
        $('.quantity-right-plus-other').click(function(e){
                
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity_other').val());
                
                // If is not undefined
                    
                    $('#quantity_other').val(quantity + 1);

                
                    // Increment
                
            });

            $('.quantity-left-minus-other').click(function(e){
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity_other').val());
                
                // If is not undefined
            
                    // Increment
                    if(quantity>0){
                    $('#quantity_other').val(quantity - 1);
                    }
            });
            
        });
    </script>
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
    
       <script>
function myFunction() {
  var x = document.getElementById("editState").value;
  $.ajax({
		type: 'GET',
		url: '${pageContext.request.contextPath }/loadCitiesByState/' + x,
		success: function(result) {
			var s = '';
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

	<script src="assets-2/js/app.js"></script>
	<script src="https://material-ui.com/components/tables/#DataTable.js"></script>


</body>

<script>'undefined'=== typeof _trfq || (window._trfq = []);'undefined'=== typeof _trfd && (window._trfd=[]),_trfd.push({'tccl.baseHost':'secureserver.net'}),_trfd.push({'ap':'cpsh'},{'server':'sg3plcpnl0184'}) // Monitoring performance to make your website faster. If you want to opt-out, please contact web hosting support.</script><script src='https://img1.wsimg.com/tcc/tcc_l.combined.1.0.6.min.js'></script></html>




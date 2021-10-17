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

	<link href="assets-1/css/app.css" rel="stylesheet">
    <link href="student-d.css" rel="stylesheet">

	<link href="assets-1/css/style.css" rel="stylesheet">
	<link href="assets-1/css/style2.css" rel="stylesheet">

	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">


    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">



   <style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>


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

        .card {
            border-radius: 1.4rem;
            width: 50%;
            height: 217px;
        }

   /* xs */
	@media (max-width: 767px) {
		main{
			height: 800px;
		}
	}
    main .firstrow h4{
        color: #F15336;
        margin: 1rem;
        font-weight: bold;
        padding: 1.5rem;
    }
    form h4{
        color: #A4A4A4;
        font-size: 1.8rem;
        margin-left: .5rem;
    }
    form .searchjobs{
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
    .last .lastcol{
        text-align: center;
    }
    main .firstrow button{
        background-color: #F15336;
        float: right;
        padding: 1rem;
        margin: 1rem;
        border: none;
        border-radius: .5rem;
    }
    main .firstrow button a{
        color: white;
        font-weight: bold;
        text-decoration: none;
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

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="stud-genz.html"><i class="fa fa-smile-o align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Student</b></span>
                    </a></li>

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="searchcandi-genz.html"><i class="fa fa-search align-middle" style="font-size:19px"></i> <span class="align-middle"><b>Search Candidate</b></span>
                    </a></li>

                    <li class="sidebar-item">
                    <a class="sidebar-link" href="searchjobs-genz.html"><i class="fa fa-magic align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Search Job</b></span>
                    </a></li>

                    <li class="sidebar-item active">
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
					<img src="assets-1/img/icons/Shape@1X (3).png">
               </a>
			   <h4><b>Job Type</b></h4>

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
					<!-- <a class="dropdown-item" href="#">Log out</a> -->
				</div> 
			</nav>

			<main class="content">
                <div class="container-fluid1">
                   <div class="row firstrow">
                       <div class="col-lg-12">
                        <button type="submit" class="csv"><a href="jobtype-genz.html">Back  <i class="fa fa-chevron-left" aria-hidden="true"></i></a></button>
                       </div>
                   </div>
                   <form:form action="/jobtype-edit-genz.html" method="post" modelAttribute="jobType">
                    <div class="form-row">
                    <form:input path="id" placeholder="First Name"
								class="form-control" type="hidden" />
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 searchjobs">
                            <h4>Job Type <span>*</span></h4>
<%-- 							<form:select  path="jobTypeName" class="form-control"> --%>
<%--                               <form:option class="first-op" value="">Select</form:option>  --%>
<%--                               <form:option value="Other Onsite Job"/> --%>
<%--                               <form:option  value="Remote/Online Job"/> --%>
<%--                               <form:option  value="Field Job"/> --%>
<%--                               <form:option value="Office Job"/> --%>
<%--                               <form:option value="Freelance"/> --%>
<%--                             </form:select> --%>


 							<form:input class="form-control" path="jobTypeName"
								placeholder="Job Type Name" id="example-tel-input" />
                            <form:errors path="jobTypeName" cssClass="error"></form:errors>
                          </div>
                      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 searchjobs">
                        <h4>Status <span>*</span></h4>
                         <form:select path="jobTypeStatus" class="form-control">
                          <form:option class="first-op" value="">Select</form:option> 
                          <form:option value="Active">Active</form:option>
                          <form:option value="In-Active">In-Active</form:option>
                        </form:select>
                        <form:errors path="jobTypeStatus" cssClass="error"></form:errors>
                      </div>
      
                    </div>
                    <div class="form-row last">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 lastcol">
                          <button type="submit">Save</button>
                      </div>
                    </div>
                   
                  </form:form>
                </div>

			</main>

		
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${not empty successMessage}">
		toastr.success('${successMessage}', 'Success Alert', {timeOut: 5000})
		</c:if>
	});
	
	$(document).ready(function(){
		<c:if test="${not empty errorMessage}">
		toastr.error('${errorMessage}', 'Error Alert', {timeOut: 5000})
		</c:if>
	});
	
	</script>

	<script src="assets-1/js/app.js"></script>


</body>

</html>
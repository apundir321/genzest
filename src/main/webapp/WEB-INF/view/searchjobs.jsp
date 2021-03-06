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
    <link href="assets-2/css/earning.css" rel="stylesheet">

	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<link href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">

<script src="//code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>


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
    .last .lastcol button{
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
        padding: 2rem;
        text-align: center;
    }
   form{
       padding: 1.5rem;
   }
   form .searchjobs{
       margin-bottom: 30px;
   }
  
   /* sm */
  @media (min-width: 768px) and (max-width: 991px) {
    table{
     overflow: auto;
     display: block;
   }
  } 

  /* xs */
  @media (max-width: 767px) {
    table{
     overflow: auto;
     display: block;
   }
  }
  
.content .container-fluid h4 {
	color:white;
}
.content .container-fluid h4 span{
	color:red;
}
</style>

<script>


var dataSet = new Array();
<c:forEach items="${jobs}" var="job" varStatus="status">
jobArray = new Array();
jobArray.push('${job.jobCode}');
jobArray.push('${job.employer.employerName}');
jobArray.push('${job.jobName}');
jobArray.push('<c:forEach var="timeSlot" items="${job.timeSlots}">${timeSlot.timeSlotName}   </c:forEach>');
jobArray.push('${job.category.categoryName}');
jobArray.push('${job.noOfVacancy}');
jobArray.push('${job.city}');
jobArray.push('${job.jobDate}');
jobArray.push('<input class="form-check-input" name="applyJob" type="checkbox" value="${job.id}" id="defaultCheck1_${job.id}">')
dataSet.push(jobArray);
</c:forEach>
 
$(document).ready(function() {
    $('#example').DataTable( {
        data: dataSet,
        columns: [
			{ title: "Job code" },
            { title: "Employer" },
            { title: "Job Name" },
            { title: "Time Slot" },
            { title: "Job Category" },
            { title: "No of vacancy" },
            { title: "City" },
            { title: "Date of Job" },
            { title: "Apply" }
        ],
		
    } );
} );
</script>

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
						<p style="margin-left: 7.5rem; margin-top: -.9rem;">Student</p>
            		</a>
				</li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="student-d.html"><i class="align-middle" data-feather="home"></i> <span class="align-middle"><b>Dashboard</b></span>
            		</a></li>


					<li class="sidebar-item">
					<a class="sidebar-link" href="profile.html"><i class="fa fa-user-o align-middle" style="font-size:19px"></i> <span class="align-middle"><b>My Profile</b></span>
					</a></li>

					<li class="sidebar-item active">
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
				<p>???? 2021 All Rights Reserved</p>
			</div>
		</nav>

		<div class="main">
			<!-- ---------------TOP BAR-------------- -->
			<nav class="navbar navbar-expand">
				<a class="sidebar-toggle js-sidebar-toggle">
					<img src="assets-1/img/icons/Shape@1X (3).png">
               </a>
			   <h4><b>Search Jobs</b></h4>

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
                <div class="container-fluid">
                     <form:form action="/searchJobs.html" method="post"
					modelAttribute="searchJob" >
                        <div class="form-row">
                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
                            <h4>Job Category <span>*</span></h4>
                            <form:select class="form-control" path="jobCategory">
										<form:option value="">Select</form:option>
										<c:forEach var="category" items="${categories}">
											<form:option value="${category.id}"
												label="${category.categoryName}" />
										</c:forEach>
									</form:select>
                          </div>
                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
                            <h4>Job Type <span>*</span></h4>
                            <form:select class="form-control" path="jobType">
										<form:option value="">Select</form:option>
										<c:forEach var="jobType" items="${jobTypes}">
											<form:option value="${jobType.id}"
												label="${jobType.jobTypeName}" />
										</c:forEach>
									</form:select>
                          </div>
                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
                            <h4>Time-Slot <span>*</span></h4>
                           <form:select class="form-control" path="timeSlot">
										<form:option value="">Select</form:option>
										<c:forEach var="timeSlot" items="${timeSlots}">
											<form:option value="${timeSlot.id}"
												label="${timeSlot.timeSlotName}" />
										</c:forEach>
									</form:select>
                          </div>
                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
                            <h4>Employer <span>*</span></h4>
                             <form:select class="form-control" path="employerName">
                            <form:option value="">Select</form:option>
                            <c:forEach var="employer" items="${employers}">  
                            <form:option  value="${employer.id}" label="${employer.employerName}" />
                            </c:forEach>
                            </form:select>
                          </div>
                          
                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
                             <h4>City <span>*</span></h4>
                              <form:select path="city" class="form-control">
                               <form:option class="first-op" value="">Select</form:option> 
                               <form:option value="Gurgaon">Gurgaon</form:option>
                               <form:option value="Indore">Indore</form:option>
                               <form:option value="Kolkata">Kolkata</form:option>
                               <form:option value="Pune">Pune</form:option>
                               <form:option value="Mumbai">Mumbai</form:option>
                               <form:option value="Delhi">Delhi</form:option>
                             </form:select>    
                           </div>
                        
                        </div>
                        
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>Date From <span>*</span></h4>
                            <form:input path="dateFrom" class="form-control" type="date" placeholder="MM/DD/YYYY" id="Effectivefrom" name="Effectivefrom" />
                         </div>

                         <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 colbox">
                            <h4>Date To <span>*</span></h4>
                            <form:input path="dateTo" class="form-control" type="date" placeholder="MM/DD/YYYY" id="Effectivefrom" name="Effectivefrom" />
                         </div>
                        
                        <div class="form-row last">
                          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 lastcol">
                              <button type="submit">Get Data</button>
                          </div>
                        </div>
                       
                      </form:form>
						<c:if test="${jobs.size() > 0 }">   

<div style="padding-top: 20%">
<button class="csv"><a href="/downloadJobs">Download CSV</a></button>
<table id="example" class="display" width="100%"></table>
</div>
<!--  <table class="table"> -->
<!--                         <thead> -->
                        
<!--                           <tr> -->
<!--                             <th scope="col">Job Code</th> -->
<!--                             <th scope="col">Employer</th> -->
<!--                             <th scope="col">Job Name</th> -->
<!--                             <th scope="col">Time Slot</th> -->
<!--                             <th scope="col">Job Category</th> -->
<!--                             <th scope="col">No of Vacancy</th> -->
<!--                             <th scope="col">City</th> -->
<!--                             <th scope="col">Date of Job</th> -->
<!--                             <th scope="col">Apply</th> -->
<!--                           </tr> -->
<!--                         </thead> -->
<!--                         <tbody> -->
<%--                         <c:forEach var="job" items="${jobs}">  --%>
<!--                          <tr>  -->
<%--                             <th scope="row">${job.jobCode}</th> --%>
<%--                             <td>${job.employer.employerName}</td> --%>
<%--                             <td>${job.jobName}</td> --%>
<%--                             <td><c:forEach var="timeSlot" items="${job.timeSlots}">${timeSlot.timeSlotName}   </c:forEach></td> --%>
<%--                             <td>${job.category.categoryName}</td> --%>
<%--                             <td>${job.noOfVacancy}</td> --%>
<%--                             <td>${job.city}</td> --%>
<%--                             <td>${job.jobDate}</td> --%>
<!--                             <td><div class="form-check"> -->
<%--                               <input class="form-check-input" name="applyJob" type="checkbox" value="${job.id}" id="defaultCheck1_${job.id}"> --%>
<!--                               <label class="form-check-label" for="defaultCheck1"> -->
<!--                                Apply -->
<!--                               </label> -->
<!--                             </div></td> -->
<!--                           </tr> -->
<%--                           </c:forEach> --%>
<!--                         </tbody> -->
<!--                       </table> -->
                      
                      <div class="form-row last">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 lastcol">
                            <button type="submit" onclick="applyJob()">Apply</button>
                        </div>
                      </div>
                      </c:if>
                </div>
			</main>
		</div>
	</div>
	<script>
	
	function applyJob()
    {
        var checkboxes = document.getElementsByName('applyJob');
        var selected = new Array();
        var ids = "";
        for (var i=0; i<checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                selected.push(checkboxes[i].value);
                ids += checkboxes[i].value + ",";
            }
        }
        location.href = "/applyJob?jobId="+ids;
    }
	</script>

	<script src="assets-1/js/app.js"></script>


</body>

</html>
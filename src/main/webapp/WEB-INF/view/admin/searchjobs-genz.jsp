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
    

	<link href="assets-1/css/style.css" rel="stylesheet">
	<link href="assets-1/css/style2.css" rel="stylesheet">

  
	<link href="assets-2/css/app.css" rel="stylesheet">

	<link href="assets-2/css/style.css" rel="stylesheet">
	<link href="assets-2/css/style2.css" rel="stylesheet">
	<link href="assets-2/css/style3.css" rel="stylesheet">

	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">

	<!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <link href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
  
  <script src="//code.jquery.com/jquery-3.5.1.js"></script>
  <script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
  
  
  
  
<!--       <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script> -->
<!--     <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
  

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
  .sidebar .sidebar-nav .sidebar-item a {
    height: 55px;
}
</style>
<script>



var dataSet = new Array();
<c:forEach items="${jobs}" var="job" varStatus="status">
jobArray = new Array();
jobArray.push('${job.id}');
jobArray.push('${job.jobName}');
jobArray.push('${job.jobCode}');
jobArray.push('${job.category.categoryName}');
jobArray.push('${job.noOfVacancy}');
jobArray.push('${job.employer.employerName}');
jobArray.push('${job.status}');
jobArray.push('${job.createdBy.firstName}');
jobArray.push('${job.createdDate}');

jobArray.push('<a href="/updatejobs-genz.html?jobId=${job.id}">View</a>');

dataSet.push(jobArray);
</c:forEach>
	var dataSet1 = [
    [ "002", "Den", "Office Job", "8am-5am", "Designing", "4", "Gurgaon", "6/20/2021", "----" ],
	  //  [ "12", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "10", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "8", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "6", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "4", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "3", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "5", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "7", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "9", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	  //  [ "11", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
    // // [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ],
    // [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ],
    // [ "Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224", "2012/03/29", "$433,060" ],
    [ "001", "Henny", "Remote/Online Job", "8am-5am", "Billing", "5", "Gurgaon", "6/20/2021", "----" ]
    // [ "Brielle Williamson", "Integration Specialist", "New York", "4804", "2012/12/02", "$372,000" ],
    // [ "Herrod Chandler", "Sales Assistant", "San Francisco", "9608", "2012/08/06", "$137,500" ],
    // [ "Rhona Davidson", "Integration Specialist", "Tokyo", "6200", "2010/10/14", "$327,900" ],
    // [ "Colleen Hurst", "Javascript Developer", "San Francisco", "2360", "2009/09/15", "$205,500" ],
];



    

    // New record
    $('a.editor-create').on('click', function (e) {
        e.preventDefault();
 
        editor.create( {
            title: 'Create new record',
            buttons: 'Add'
        } );
    } );
 
    // Edit record
    $('#example').on('click', 'td.editor-edit', function (e) {
        e.preventDefault();
 
        editor.edit( $(this).closest('tr'), {
            title: 'Edit record',
            buttons: 'Update'
        } );
    } );
 
    // Delete a record
    $('#example').on('click', 'td.editor-delete', function (e) {
        e.preventDefault();
 
        editor.remove( $(this).closest('tr'), {
            title: 'Delete record',
            message: 'Are you sure you wish to remove this record?',
            buttons: 'Delete'
        } );
    } );
 
    $(document).ready(function() {
        $('#example').DataTable( {
            data: dataSet,
            columns: [
    			{ title: "Id" },
                { title: "Job" },
                { title: "Job Code" },
                { title: "Category" },
                { title: "Vacancy" },
                { title: "Company" },
                { title: "Status" },
    			{ title: "Created By" },
    			{ title: "Created Date" },
    			{
    				 title: "view"
    			}
//                 {
//                     data: null,
//                     className: "dt-center editor-edit",
//                     defaultContent: '<a href="editjobs-genz.html"><i class="fa fa-pencil"/></a>',
//                     orderable: false
//                 },
//                 {
//                     data: null,
//                     className: "dt-center editor-delete",
//                     defaultContent: '<i class="fa fa-trash"/>',
//                     orderable: false
//                 }
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
					<a class="sidebar-link first" href="#"><i class="fa fa-user-circle-o align-middle" aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>${user.firstName}</b><i class="fa fa-angle-down" aria-hidden="true"></i></span>
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

                        <li class="sidebar-item active">
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
                                         <form:form action="/searchjobs-genz.html" method="post"
					modelAttribute="searchJob" >
                        <div class="form-row">
                          <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 searchjobs">
                            <h4>Category <span>*</span></h4>
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

                     <table id="example" class="display" width="100%"></table>
                     <!-- <table class="table">
                       <thead>
                         <tr>
                           <th scope="col">Job Code</th>
                           <th scope="col">Employer</th>
                           <th scope="col">Job Type</th>
                           <th scope="col">Time</th>
                           <th scope="col">Category</th>
                           <th scope="col">No of Vacancy</th>
                           <th scope="col">City</th>
                           <th scope="col">Valid Till</th>
                           <th scope="col">View</th>
                         </tr>
                       </thead>
                       <tbody>
                         <tr>
                           <th scope="row">001</th>
                           <td>Henny</td>
                           <td>Remote/ Online Job</td>
                           <td>8am - 5pm</td>
                           <td>Billing</td>
                           <td>5</td>
                           <td>Gurgaon</td>
                           <td>6/20/2021</td>
                           <td>----</td>
                           
                         </tr>
                         <tr>
                           <th scope="row">002</th>
                           <td>Den</td>
                           <td>Office Job</td>
                           <td>9:30am - 6:30pm</td>
                           <td>Customer Service</td>
                           <td>3</td>
                           <td>Gurgaon</td>
                           <td>6/20/2021</td>
                           <td>----</td>
                           
                         </tr>
                         <tr style="border-bottom: none;">
                           <th scope="row">003</th>
                           <td>Jay</td>
                           <td>Field Job</td>
                           <td>12pm - 8pm</td>
                           <td>Designing</td>
                           <td>8</td>
                           <td>Gurgaon</td>
                           <td>6/20/2021</td>
                           <td>----</td>
                          
                         </tr>
                       </tbody>
                     </table> -->
               </div>
			</main>

		
		</div>
	</div>
<script>
function myFunction() {
	  var x = document.getElementById("editState").value;
	  $.ajax({
			type: 'GET',
			url: '${pageContext.request.contextPath}/loadCitiesByState/' + x,
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
	
	
	
		<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${not empty successMessage}">
		toastr.success('${successMessage}', 'Success Alert', {timeOut: 5000})
		</c:if>
	});
	
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
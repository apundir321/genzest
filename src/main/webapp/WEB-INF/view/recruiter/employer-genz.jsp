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
    main .card1{
        margin-bottom: 2rem;
    }
    main .card1 .fa-users{
        background-color: #2769EE;
        border-radius: .5rem;
        padding: 1.5rem;
        margin: 1rem;
        font-size: 2.5rem;
    }
    main .card1 .fa-smile-o{
        background-color: #BEC747;
        border-radius: .5rem;
        padding: 1.5rem;
        margin: 1rem;
        font-size: 2.5rem;
    }
    main .card1 .fa-newspaper-o{
        background-color: #27BEEE;
        border-radius: .5rem;
        padding: 1.5rem;
        margin: 1rem;
        font-size: 2.5rem;
    }
    main .card1 .fa-file-text-o{
        background-color: #DF2C57;
        border-radius: .5rem;
        padding: 1.5rem;
        margin: 1rem;
        font-size: 2.5rem;
    }
    main .card1 .fa-thumbs-o-down{
        background-color: #EE9827;
        border-radius: .5rem;
        padding: 1.5rem;
        margin: 1rem;
        font-size: 2.5rem;
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
    .dataTables_wrapper table td {
    padding: 2rem;
    text-align: center;
}
    main .row1, .row2{
        text-align: center;
        color: #F15336;
    }
    main .row1 h4, .row2 h4{
        font-weight: bold;
        font-size: 2rem;
        padding: 1rem;
    }
    .sidebar .sidebar-nav .sidebar-item a {
    height: 55px;
}
</style>

<script>


var dataSet1 = new Array();
<c:forEach items="${employers}" var="employer" varStatus="status">
employer = new Array();
employer.push('${employer.id}');
employer.push('${employer.code}');
employer.push('${employer.employerName}');
employer.push('${employer.contactPerson}');
employer.push('${employer.email}');
employer.push('${employer.mobile}');
employer.push('${employer.city}');
employer.push('${employer.status}');
employer.push('${employer.createdDate}');
employer.push('${employer.action}');
dataSet1.push(employer);
</c:forEach>
	var cate = [
    [ "2", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "12", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "10", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "8", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "6", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "4", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "3", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "5", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "7", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "9", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
	[ "11", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
    // [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ],
    // [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ],
    // [ "Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224", "2012/03/29", "$433,060" ],
    [ "1", "Dk", "Henny", "Den", "abc@gmail.com", "9098765432", "Gurgaon", "Verified", "26/05/1998", "----" ],
    // [ "Brielle Williamson", "Integration Specialist", "New York", "4804", "2012/12/02", "$372,000" ],
    // [ "Herrod Chandler", "Sales Assistant", "San Francisco", "9608", "2012/08/06", "$137,500" ],
    // [ "Rhona Davidson", "Integration Specialist", "Tokyo", "6200", "2010/10/14", "$327,900" ],
    // [ "Colleen Hurst", "Javascript Developer", "San Francisco", "2360", "2009/09/15", "$205,500" ],
];



    

 
    // Edit record
    $('#example1').on('click', 'td.editor-edit', function (e) {
        e.preventDefault();
 
        editor.edit( $(this).closest('tr'), {
            title: 'Edit record',
            buttons: 'Update'
        } );
    } );
 
    // Delete a record
    $('#example1').on('click', 'td.editor-delete', function (e) {
        e.preventDefault();
 
        editor.remove( $(this).closest('tr'), {
            title: 'Delete record',
            message: 'Are you sure you wish to remove this record?',
            buttons: 'Delete'
        } );
    } );
 
$(document).ready(function() {
    $('#example1').DataTable( {
        data: dataSet1,
        columns: [
			{ title: "Id" },
            { title: "Code" },
            { title: "Firm" },
            { title: "Contact Person" },
            { title: "Email" },
            { title: "Phone" },
            { title: "City" },
			{ title: "Status" },
            { title: "Created Date" },
            { title: "Action" }
            // {
            //     data: null,
            //     className: "dt-center editor-edit",
            //     defaultContent: '<a href="#"><i style="margin:-1rem;" class="fa fa-pencil"/></a>',
            //     orderable: false
            // }
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
					<a class="sidebar-link first" href="#"><i class="fa fa-user-circle-o align-middle" aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>John Rambo</b><i class="fa fa-angle-down" aria-hidden="true"></i></span>
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

					<li class="sidebar-item active">
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
			   <h4><b>Employer</b></h4>

			   <div style="max-width:350px; margin:auto">
					<div class="input-icons">
						<input class="input-field" type="text">
						<i style="color: #6E6E6E;" class="fa fa-search" aria-hidden="true"></i>
					</div>
				</div>

				<div class="navbar-collapse collapse">
					<ul class="navbar-nav navbar-align">
						<li class="nav-item">
							<i class="fa fa-bell-o" aria-hidden="true"></i>&nbsp;<a href=""> Notification </a>
						</li>
						<li class="nav-item">
							<i class="fa fa-cog" aria-hidden="true"></i>&nbsp;<a href=""> Settings </a>
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
             
          
               <br>
               <!-- <div class="row2">
                    <div class="col-lg-12">
                        <h4>Present Student</h4>
                    </div>
                </div> -->
               <table id="example1" class="display1" width="100%"></table>
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
                    <th scope="col">Apply</th>
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
                    <td><a href="">View</a></td>
                    <td><div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                      <label class="form-check-label" for="defaultCheck1">
                       Apply
                      </label>
                    </div></td>
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
                    <td><a href="">View</a></td>
                    <td><div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                      <label class="form-check-label" for="defaultCheck1">
                       Apply
                      </label>
                    </div></td>
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
                    <td><a href="">View</a></td>
                    <td><div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                      <label class="form-check-label" for="defaultCheck1">
                       Apply
                      </label>
                    </div></td>
                  </tr>
                </tbody>
              </table> -->
           </main>

		
		</div>
	</div>
    <script>
		$(document).ready( function () {
			$('#table_id').DataTable();
		} );
	</script>
	<script src="assets-1/js/app.js"></script>


</body>

</html>
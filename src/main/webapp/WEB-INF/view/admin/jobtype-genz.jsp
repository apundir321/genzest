<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        .sidebar .sidebar-nav .sidebar-item a {
    height: 55px;
}
</style>
<script>
var dataSet = new Array();
<c:forEach items="${jobTypes}" var="jobType" varStatus="status">
jobType = new Array();
jobType.push('${jobType.id}');
jobType.push('${jobType.jobTypeName}');
jobType.push('${jobType.jobTypeStatus}');
jobType.push('${jobType.createdDate}');
jobType.push('Administrator');
jobType.push('${jobType.createdDate}');
dataSet.push(jobType);
</c:forEach>


	var cate = [
       [ "2", "Field Job", "Active", "26/05/2021", "Administrator", "----" ],
	//    [ "12", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	//    [ "10", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	//    [ "8", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	//    [ "6", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	//    [ "4", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
    [ "3", "Remote Job", "Active", "26/05/2021", "Administrator", "----" ],
	//    [ "5", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	//    [ "7", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	//    [ "9", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
	//    [ "11", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "----" ],
    // [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ],
    // [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ],
    // [ "Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224", "2012/03/29", "$433,060" ],
    [ "1", "Office Job", "Active", "26/05/2021", "Administrator", "----" ]
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
            { title: "Job Type" },
            { title: "Status" },
            { title: "Created Date" },
			{ title: "Created By" },
			{ title: "Action" },
            {
                data: null,
                className: "dt-center editor-edit",
                defaultContent: '<a href="jobtype-edit-genz.html"><i class="fa fa-pencil"/></a>',
                orderable: false
            }
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
					<a class="sidebar-link first" href="index.html"><i class="fa fa-user-circle-o align-middle" aria-hidden="true"></i>&nbsp; <span class="align-middle "><b>John Rambo</b><i class="fa fa-angle-down" aria-hidden="true"></i></span>
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
					<a class="sidebar-link" href="#"><i class="fa fa-money align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Student Earning</b></span>
					</a></li>

					<li class="sidebar-item">
					<a class="sidebar-link" href="#"><i class="fa fa-users align-middle" aria-hidden="true" style="font-size:19px"></i> <span class="align-middle"><b>Employer</b></span>
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
                <!-- <div id="example_wrapper" class="dataTables_wrapper no-footer">
               
                   <div class="dataTables_length" id="example_length">
                       <label>Show <select name="example_length" aria-controls="example" class="">
                           <option value="10">5</option>
                           <option value="25">10</option>
                           <option value="50">20</option>
                           <option value="100">50</option>
                       </select> entries</label>
                   </div>
                        <div class="dt-buttons">
                       <button class="dt-button buttons-csv buttons-html5" tabindex="0" aria-controls="example" type="button"><span>CSV</span></button> 
                   </div>
                   <div id="example_filter" class="dataTables_filter">
                       <label>Search:<input type="search" class="" placeholder="Seach job Title Here" aria-controls="example"><i class="fa fa-search" aria-hidden="true"></i></label>
                   </div>
                   <table id="example" class="display dataTable no-footer" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
                       <thead>
                           <tr role="row">
                               <th class="sorting sorting_asc" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Id: activate to sort column descending" style="width: 28px;">Id</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Job: activate to sort column ascending" style="width: 138px;">Job</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Job Code: activate to sort column ascending" style="width: 138px;">Job Code</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Category: activate to sort column ascending" style="width: 161px;">Category</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Vacancy: activate to sort column ascending" style="width: 123px;">Vacancy</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Company: activate to sort column ascending" style="width: 138px;">Company</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 93px;">Status</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Created By: activate to sort column ascending" style="width: 160px;">Created By</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Created Date: activate to sort column ascending" style="width: 188px;">Created Date</th>
                               <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Action: activate to sort column ascending" style="width: 96px;">Action</th>
                           </tr>
                       </thead>
                       <tbody>
                           <tr class="odd">
                               <td class="sorting_1">1</td>
                               <td>Developer</td>
                               <td>D1241</td>
                               <td>Computer S</td>
                               <td>10</td>
                               <td>Flybunch</td>
                               <td>Open</td>
                               <td>Flybunch</td>
                               <td>26/05/2021</td>
                               <td>---</td>
                           </tr>
                       </tbody>
                   </table>
                   <div class="dataTables_info" id="example_info" role="status" aria-live="polite">Showing 1 to 1 of 1 entries</div>
                   <div class="dataTables_paginate paging_simple_numbers" id="example_paginate">
                       <a class="paginate_button previous disabled" aria-controls="example" data-dt-idx="0" tabindex="-1" id="example_previous">Previous</a>
                       <span>
                           <a class="paginate_button current" aria-controls="example" data-dt-idx="1" tabindex="0">1</a>
                       </span>
                       <a class="paginate_button next disabled" aria-controls="example" data-dt-idx="2" tabindex="-1" id="example_next">Next</a>
                   </div>
               </div>   -->
               <button class="csv"><a href="jobtype-edit-genz.html">Add  <i class="fa fa-plus" aria-hidden="true"></i></a></button>
               <table id="example" class="display" width="100%"></table>
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


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
<!-- <script src="https://cdn.datatables.net/buttons/1.7.0/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.7.0/js/buttons.html5.min.js"></script> -->



<!--     <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script> -->
<!--     <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">




<style>
	body{
		font-family: 'Lato', sans-serif;
		font-weight: 400;
	}
</style>

<script>
var dataSet = new Array();
<c:forEach items="${applications}" var="application" varStatus="status">
courseType = new Array();
courseType.push('${application.job.jobCode}');
courseType.push('${application.job.jobName}');
courseType.push('${application.job.category.categoryName}');
courseType.push('<c:forEach var="timeSlot" items="${application.job.timeSlots}">${timeSlot.timeSlotName}   </c:forEach>');
courseType.push('${application.job.city}');
courseType.push('${application.job.jobDate}');
courseType.push('${application.job.employer.employerName}');
dataSet.push(courseType);
</c:forEach>
	var dataSet12 = [
    //    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
	//    [ "2", "Designer", "D2241", "Computer S", "20", "Techworld", "Open", "Techworld", "26/05/2021", "---" ],
    // [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ],
    // [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ],
    // [ "Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224", "2012/03/29", "$433,060" ],
    [ "001", "Tester", "CSE", "Full Time", "9:30am - 6:30pm", "abc@gmail.com", "9098765432", "06/01/2021", "---" ]
    // [ "Brielle Williamson", "Integration Specialist", "New York", "4804", "2012/12/02", "$372,000" ],
    // [ "Herrod Chandler", "Sales Assistant", "San Francisco", "9608", "2012/08/06", "$137,500" ],
    // [ "Rhona Davidson", "Integration Specialist", "Tokyo", "6200", "2010/10/14", "$327,900" ],
    // [ "Colleen Hurst", "Javascript Developer", "San Francisco", "2360", "2009/09/15", "$205,500" ],
    // [ "Sonya Frost", "Software Engineer", "Edinburgh", "1667", "2008/12/13", "$103,600" ],
    // [ "Jena Gaines", "Office Manager", "London", "3814", "2008/12/19", "$90,560" ],
    // [ "Quinn Flynn", "Support Lead", "Edinburgh", "9497", "2013/03/03", "$342,000" ],
    // [ "Charde Marshall", "Regional Director", "San Francisco", "6741", "2008/10/16", "$470,600" ],
    // [ "Haley Kennedy", "Senior Marketing Designer", "London", "3597", "2012/12/18", "$313,500" ],
    // [ "Tatyana Fitzpatrick", "Regional Director", "London", "1965", "2010/03/17", "$385,750" ],
    // [ "Michael Silva", "Marketing Designer", "London", "1581", "2012/11/27", "$198,500" ],
    // [ "Paul Byrd", "Chief Financial Officer (CFO)", "New York", "3059", "2010/06/09", "$725,000" ],
    // [ "Gloria Little", "Systems Administrator", "New York", "1721", "2009/04/10", "$237,500" ],
    // [ "Bradley Greer", "Software Engineer", "London", "2558", "2012/10/13", "$132,000" ],
    // [ "Dai Rios", "Personnel Lead", "Edinburgh", "2290", "2012/09/26", "$217,500" ],
    // [ "Jenette Caldwell", "Development Lead", "New York", "1937", "2011/09/03", "$345,000" ],
    // [ "Yuri Berry", "Chief Marketing Officer (CMO)", "New York", "6154", "2009/06/25", "$675,000" ],
    // [ "Caesar Vance", "Pre-Sales Support", "New York", "8330", "2011/12/12", "$106,450" ],
    // [ "Doris Wilder", "Sales Assistant", "Sydney", "3023", "2010/09/20", "$85,600" ],
    // [ "Angelica Ramos", "Chief Executive Officer (CEO)", "London", "5797", "2009/10/09", "$1,200,000" ],
    // [ "Gavin Joyce", "Developer", "Edinburgh", "8822", "2010/12/22", "$92,575" ],
    // [ "Jennifer Chang", "Regional Director", "Singapore", "9239", "2010/11/14", "$357,650" ],
    // [ "Brenden Wagner", "Software Engineer", "San Francisco", "1314", "2011/06/07", "$206,850" ],
    // [ "Fiona Green", "Chief Operating Officer (COO)", "San Francisco", "2947", "2010/03/11", "$850,000" ],
    // [ "Shou Itou", "Regional Marketing", "Tokyo", "8899", "2011/08/14", "$163,000" ],
    // [ "Michelle House", "Integration Specialist", "Sydney", "2769", "2011/06/02", "$95,400" ],
    // [ "Suki Burks", "Developer", "London", "6832", "2009/10/22", "$114,500" ],
    // [ "Prescott Bartlett", "Technical Author", "London", "3606", "2011/05/07", "$145,000" ],
    // [ "Gavin Cortez", "Team Leader", "San Francisco", "2860", "2008/10/26", "$235,500" ],
    // [ "Martena Mccray", "Post-Sales support", "Edinburgh", "8240", "2011/03/09", "$324,050" ],
    // [ "Unity Butler", "Marketing Designer", "San Francisco", "5384", "2009/12/09", "$85,675" ]
];
 
$(document).ready(function() {
    $('#example').DataTable( {
        data: dataSet,
        columns: [
			{ title: "Job Code" },
            { title: "Job Name" },
            { title: "Category" },
            { title: "Time Slot" },
            { title: "city" },
            { title: "Job Date" },
			{ title: "Employer" }
        ],
		
    } );
} );
</script>
</head>

<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a href="index.html"><img src="assets-2/img/icons/Genzest Logo.png" alt="" class="img-responsive logo"></a></a>


				
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
	
						<li class="sidebar-item">
							<a class="sidebar-link" href="searchjobs.html"><i class="fa fa-search align-middle" style="font-size:19px"></i> <span class="align-middle"><b>Search Jobs</b></span>
						</a></li>
	
						<li class="sidebar-item">
						<a class="sidebar-link" href="earning.html"><i class="fa fa-money align-middle" style="font-size:19px"></i> <span class="align-middle"><b>My Earnings</b></span>
						</a></li>
			
						<li class="sidebar-item active">
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
				<p>© 2021 All Rights Reserved</p>
			</div>
		</nav>

		<div class="main">
			<!-- ---------------TOP BAR-------------- -->
			<nav class="navbar navbar-expand">
				<a class="sidebar-toggle js-sidebar-toggle">
					<img src="assets-2/img/icons/Shape@1X (3).png">
               </a>
			   <h4><b>Applied Jobs</b></h4>

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
				<button class="csv"><a href="/downloadAppliedJobs">Download CSV</a></button>
				<table id="example" class="display" width="100%"></table>
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
	<script>
		$(document).ready( function () {
			$('#table_id').DataTable();
		} );
	</script>

	<script src="assets-2/js/app.js"></script>
	<script src="https://material-ui.com/components/tables/#DataTable.js"></script>


</body>

<script>'undefined'=== typeof _trfq || (window._trfq = []);'undefined'=== typeof _trfd && (window._trfd=[]),_trfd.push({'tccl.baseHost':'secureserver.net'}),_trfd.push({'ap':'cpsh'},{'server':'sg3plcpnl0184'}) // Monitoring performance to make your website faster. If you want to opt-out, please contact web hosting support.</script><script src='https://img1.wsimg.com/tcc/tcc_l.combined.1.0.6.min.js'></script></html>
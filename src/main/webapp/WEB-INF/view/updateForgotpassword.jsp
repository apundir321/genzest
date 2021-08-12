
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">

<style>
    .main{
        height: 1000px;
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
        .log{
            background-color: #212130;
            border-radius: 10px;
            padding: 0px;
            width: 100%;
        }
        .main{
            height: 1100px;
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

        .colbox h4{
            color: #bebbbb;
        }
        
        .form-group label{
            color: #bebbbb;
        }
        
        .form-group{
        margin-top:15px;
        }
        .log{
            background-color: #212130;
            border-radius: 10px;
            padding: 45px;
            width: 70%;
        }
</style>


   <style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

</head>

<body>
	<div class="wrapper">
      

		<div class="main">
			<!-- ---------------TOP BAR-------------- -->
			

			<main class="content">
			
                <div class="row two">
                    <div class="container-fluid">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <button class="back" style="float: right; margin: 1rem;"><a href="/login.html">Login  <i class="fa fa-chevron-circle-left" aria-hidden="true"></i></a></button>
                        </div>
                    </div>
                </div>
				
                <div class="container log shadow">
<form:form action="/user/savePassword" modelAttribute="forgotPasswordDto" id="updateForgotPasswordForm">
                    <div class="form-row" style="text-align: center">
                    <h4 style="font-size: 22px;color: #F15336;">Update Password</h4>
                    </div>
  <div class="form-group col-md-6">
    <label for="firstName">New Password <span>*</span></label>
                            <form:input type="text" placeholder="New Password" class="form-control" path="newPassword"/>
  </div>
  <div class="form-group col-md-6">
    <label for="firstName">Confirm Password <span>*</span></label>
                            <input type="text" placeholder="Confirm Password" class="form-control" name="confirmPassword"/>
  </div>
  
  <form:input type="hidden" placeholder="token" class="form-control" path="token"/>
                         <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 colboxb">
                            <button type="submit" onclick="return Validate()">Submit</button>
                         </div>
</form:form>

               </div>
			</main>

		</div>
	</div>
	
	
	<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("exampleInputPassword1").value;
        var confirmPassword = document.getElementById("exampleInputPassword2").value;
        if(password && confirmPassword){
        if (password != confirmPassword) {
        	document.getElementById("confirmMessage").innerHTML = "Password not matched"; 
            return false;
        }
        }
        return true;
    }
</script>
	
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

	<script src="assets-2/js/app.js"></script>
	<script src="https://material-ui.com/components/tables/#DataTable.js"></script>
        <script src="assets/js/jquery-1.11.1.js"></script>
        <script src="assets/js/jquery.validate.js"></script>
        <script src="assets/validatejs/signup.js"></script>


</body>

</html>
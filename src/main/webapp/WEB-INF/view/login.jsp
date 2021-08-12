
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="assets/login.css" rel="stylesheet">
    <!-- CSS only -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
    <style>
        h2{
            font-size: 1.5rem;
        }
        .wrapper button{
            margin-top: 1.5rem;
            width: 5rem;
            padding: .7rem;
        }
        .wrapper button a{
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
        .wrapper{
            background-color: #212130;
        }
        
    </style>
</head>
<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->
          <!-- <h2 class="active"> Sign In </h2> -->
          <h2 class="inactive underlineHover">Sign In </h2>
    
          <!-- Login Form -->
          <form name='f' action="login" method='POST' id="loginForm">
							<div class="form-group">
								<label class="col-sm-3 control-label" for="username">Username</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="username" name="username" placeholder="Username" />
								</div>
							</div>
            
							<div class="form-group">
								<label class="col-sm-3 control-label  mt10" for="firstname1">Password</label>
								<div class="col-sm-9  mt10">
									<input type="password" class="form-control" id="password" name="password" placeholder="password" />
								</div>
							</div>
              <button type="submit" class="btn btn-dark">Login</button>
            </form>
            
      
          <!-- Remind Passowrd -->
          <div id="formFooter">
<!--             <a class="underlineHover" href="signup.html">Forgot Password?</a>&nbsp;&nbsp;&nbsp; -->
            <a class="underlineHover" href="/signup.html">SignUp</a>
            
            <a class="underlineHover" href="/forgotpassword">Forgot Password</a>
          </div>
      
        </div>
      </div>
        <script src="assets/js/jquery-1.11.1.js"></script>
        <script src="assets/js/jquery.validate.js"></script>
    <script>
        $(document).ready( function () {
			$( "#loginForm" ).validate( {
				rules: {
					username: "required",
					password: "required",
					username: {
						required: true,
						minlength: 2
					},
					password: {
						required: true,
						minlength: 5
					},
					
				},
				messages: {
					username: "Please enter your firstname",
					password: "Please enter your password",
					username: {
						required: "Please enter a username",
						minlength: "Your username must consist of at least 2 characters"
					},
					password: {
						required: "Please provide a password",
						minlength: "Your password must be at least 5 characters long"
					},
					
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-9" ).addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".col-sm-9" ).addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
            
        });
            </script>
            
            
            		<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${not empty successMessage}">
		toastr.success('${successMessage}', 'Success Alert', {timeOut: 5000})
		</c:if>
		<c:remove var="successMessage" scope="session"/>
	});
	
	$(document).ready(function(){
		<c:if test="${not empty errorMessage}">
		toastr.error('${errorMessage}', 'Error Alert', {timeOut: 5000})
		</c:if>
		<c:remove var="successMessage" scope="session"/>
	});
	
	</script>

</body>
</html>



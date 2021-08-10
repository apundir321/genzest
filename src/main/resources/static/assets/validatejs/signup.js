        $(document).ready( function () {
			$( "#signupForm" ).validate( {
				rules: {
					firstName: "required",
					lastName: "required",
					email: "required",
					phoneNo: "required",
					password: "required",
					matchingPassword: "required",
					firstName: {
						required: true,
						minlength: 2
					},
					lastName: {
						required: true,
						minlength: 2
					},
					email: {
						required: true,
					},
					phoneNo: {
						required: true,
						minlength: 10,
						maxlength: 10
					},
					password: {
						required: true,
						minlength: 5
					},
					matchingPassword: {
						required: true,
						minlength: 5
					},
					
				},
				messages: {
					firstName: "Please enter your firstname",
					lastName: "Please enter your lastname",
					email: "Please enter your email",
					phoneNo: "Please enter your mobile no",
					password: "Please enter password",
					matchingPassword: "Please enter confirm password",
					firstName: {
						required: "Please enter your firstname",
						minlength: "Your firstname must consist of at least 2 characters"
					},
					lastName: {
						required: "Please enter your lastName",
						minlength: "Your lastName must consist of at least 2 characters"
					},
					email: {
						required: "Please enter your email",
					},
					phoneNo: {
						required: "Please enter your mobile no",
						minlength: "Your mobile no must consist of at 10 digit"
					},
					firstName: {
						required: "Please enter your firstname",
						minlength: "Your firstname must consist of at least 2 characters"
					},
					password: {
						required: "Please enter your password",
						minlength: "Your password must consist of at least 5 characters"
					},
					matchingPassword: {
						required: "Please provide a confirm password",
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

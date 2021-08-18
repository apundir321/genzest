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
						maxlength: 10,
						digits:true
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
					$( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
            
        });

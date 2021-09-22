     
        
        $(document).ready( function () {
	
	
	 jQuery.validator.addMethod("aphadot", function (value, element) {
        if (/^[a-zA-Z. ]*$/.test(value)) {
            return true;
        } else {
            return false;
        };
    }, "Only aphabets and dot allowed");
    
	

	
	
	 jQuery.validator.addMethod("alphabet", function (value, element) {
        if (/^[a-zA-Z. ]*$/.test(value)) {
            return true;
        } else {
            return false;
        };
    }, "Only aphabets allowed");
	
	 jQuery.validator.addMethod("firstzero", function (value, element) {
        if (/^[1-9][0-9]*$/.test(value)) {
            return true;
        } else {
            return false;
        };

    }, "cannot start with zero");
	
	

    }, "Please enter valid GSTIN Number");
	
			$( "#employereditform" ).validate( {
				rules: {
					employer: "required",
					jobName: "required",
					category: "required",
					jobName: "required",
					noOfVacancy: "required",
					preference: "required",
					effectiveFrom: "required",
					rate: "required",
					state: "required",
					city: "required",
					locality: "required",
					postalCode: "required",
					description: "required",
					employer: {
						required: true
					},
					rate: {
						digits:true,
						aphadot: false
					},
					postalCode: {
						required: true,
						digits:true,
						aphadot: false,
						min: 6,
						max: 6
					}
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
 


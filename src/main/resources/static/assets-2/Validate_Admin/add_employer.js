     
        
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
	
	 jQuery.validator.addMethod("gstin", function (value, element) {
        if (/^([0][1-9]|[1-2][0-9]|[3][0-7])([a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9a-zA-Z]{1}[zZ]{1}[0-9a-zA-Z]{1})+$/.test(value)) {
            return true;
        } else {
            return false;
        };

    }, "Please enter valid GSTIN Number");
	
			$( "#employereditform" ).validate( {
				rules: {
					employerName: "required",
					contactPerson: "required",
					email: "required",
					mobile: "required",
					gstNo: "required",
					natureOfbuisness: "required",
					Effectivefrom: "required",
					state: "required",
					city: "required",
					postalCode: "required",
					clientCode: "required",
					employer: "required",
					companyAddress: "required",
					malevac: "required",
					femalevac: "required",
					state: "required",
					locality: "required",
					postalcode: "required",
					Description: "required",
					employerName: {
						required: true,
						minlength: 2,
						maxlength: 64
					},
					contactPerson: {
						required: true,
						minlength: 2,
						aphadot: true,
						maxlength: 32
					},
					email: {
						required: true
					},
					mobile: {
						required: true,
						minlength: 10,
						maxlength: 10,
						digits: true,
						firstzero: true
					},
					malevac: {
						required: true,
						digits: true,
						alphabets: false
					},
					femalevac: {
						required: true,
						digits: true,
						alphabets: false
					},
					gstNo: {
						required: true,
						gstin: true
					},
					natureOfbuisness: {
						required: true,
						minlength: 2,
						maxlength: 64
					},
					postalCode: {
						required: true,
						minlength: 6,
						maxlength: 6,
						digits: true
					},
					clientCode: {
						required: true,
						minlength: 3,
						maxlength: 3,
						alphabet: true
					},
					companyAddress: {
						required: true
					},
					Effectivefrom: {
						required: true
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
        });


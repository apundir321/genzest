     
        
        $(document).ready( function () {
	
	
	 jQuery.validator.addMethod("aphadot", function (value, element) {
        if (/^[a-zA-Z. ]*$/.test(value)) {
            return true;
        } else {
            return false;
        };
    }, "Only aphabets and dot allowed");
    
    
    	jQuery.validator.addMethod("uploaddoc", function (value, element) {
		var testDoc = !!document.getElementById("adhar");
        if (testDoc) {
            return true;
        } else {
           var value = $("#inputGroupFile01").val();
           if(value == ""){
				return	false;
			}else{
				return true;
			}
        };
    }, "This field is required");
	
	
	 	jQuery.validator.addMethod("uploadid", function (value, element) {
		var testId = !!document.getElementById("studentId");
        if (testId) {
            return true;
        } else {
           var value = $("#inputGroupFile01").val();
           if(value == ""){
				return	false;
			}else{
				return true;
			}
        };
    }, "This field is required");
    
    
	
	 jQuery.validator.addMethod("firstzero", function (value, element) {
        if (/^[1-9][0-9]*$/.test(value)) {
            return true;
        } else {
            return false;
        };
    }, "cannot start with zero");
	
			$( "#studentprofileform" ).validate( {
				rules: {
					firstName: "required",
					lastName: "required",
					email: "required",
					parentsName: "required",
					mobileNo: "required",
					alternateMobileNo: "required",
					gender: "required",
					dob: "required",
					course: "required",
					vehicleType: "required",
					doHavePc:"required",
					bloodGroup: "required",
					address: "required",
					country: "required",
					state: "required",
					city: "required",
					locality: "required",
					postalCode: "required",
					collegeName: "required",
					degreeCollegeCompletionDate: "required",
					havePc: "required",
					jobCategories: "required",
					UPI: "required",
					preference: "required",
					paymentMethod: "required",
					aadhar: "required",
					studentId: "required",
					inputother: "required",
					firstName: {
						required: true,
						minlength: 2,
						aphadot: true,
						maxlength: 32
					},
					lastName: {
						required: true,
						minlength: 2,
						aphadot: true,
						maxlength: 32
					},
					email: {
						required: true,
					},
					parentsName: {
						required: true,
						minlength: 2,
						aphadot: true,
						maxlength: 64
					},
					mobileNo: {
						required: true,
						minlength: 10,
						maxlength: 10,
						digits: true,
						firstzero: true,
					},
					alternateMobileNo: {
						required: true,
						minlength: 10,
						maxlength: 10,
						digits: true,
						firstzero: true,
					},
					gender: {
						required: true,
					},
					dob: {
						required: true,
					},
					postalCode: {
						required: true,
						minlength: 6,
						maxlength: 6,
						digits: true,
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
			
			
			
			
				$( "#otherdetailsform" ).validate( {
				rules: {
					mobileNo: "required",
					alternateMobileNo: "required",
					course: "required",
					vehicleType: "required",
					address: "required",
					country: "required",
					state: "required",
					city: "required",
					doHavePc:"required",
					locality: "required",
					postalCode: "required",
					collegeName: "required",
					degreeCollegeCompletionDate: "required",
					havePc: "required",
					jobCategories: "required",
					preference: "required",
					mobileNo: {
						required: true,
						minlength: 10,
						maxlength: 10,
						digits: true,
						firstzero: true,
					},
					alternateMobileNo: {
						required: true,
						minlength: 10,
						maxlength: 10,
						digits: true,
						firstzero: true,
					},
					postalCode: {
						required: true,
						minlength: 6,
						maxlength: 6,
						digits: true,
					},
					aadhar: {
						
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
			
			
			
			
				$( "#uploaddocumentform" ).validate( {
				rules: {
					UPI: "required",
					paymentMethod: "required",
					aadhar: "required",
					studentId: "required",
					inputother: "required",
					aadhar: {
						uploaddoc: true,
					},
					studentId: {
						uploadid: true,
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


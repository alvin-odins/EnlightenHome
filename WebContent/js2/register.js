/**
 * jquery code for registration form
 */


$(document).ready(function(){
	$("#register").click(function(){
		var memberId = $("#memberId").val();
		var name = $("#name").val();
		var address = $("#address").val();
		var pincode = $("#pincode").val();
		var phoneNo = $("#phoneNo").val();
		var mobileNo = $("#mobileNo").val();
		var email = $("#email").val();
		var newsletterSub = $("#newsletterSub").val();
		var password = $("#password").val();
		var memberCat = $("#memberCat").val();
		
		if(memberId == '' || name == '' || address == '' || mobileNo == '' || email == '' || password == '' 
			|| memberCat == ''){
			
			alert("Some Fields are Mandatory");
		}else if((password.length < 8)){
			alert("Password minimum 8 characters");
		}else if(!(password).match(cpassword)){
			alert("Password dont match");
		}else{
			$.post("register.java",{
				
			})
		}
	})
})
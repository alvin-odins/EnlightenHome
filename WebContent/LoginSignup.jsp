<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login and Registration</title>

<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/loginsignup.css">
<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-ui.js"></script>

<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>

<script type="text/javascript">
	
function validateParty() {
	//var pidExp=/^[0-9]{4,8}$/; 
	var memberIdExp = /^[a-zA-Z]{5,8}$/;
	var emailExp = /^[a-z]+[a-z0-9\.\-\_]+\@[a-z]+\.[a-z]{2,3}$/;
	
	/*if(!(pidExp.test(document.partyForm.pid.value))){
		document.getElementById("pidError").innerHTML="Enter only numarics [4-8] only";
		document.partyForm.pid.value="";
		document.partyForm.pid.focus();
		return false; 
	} */
	
	if (!(memberIdExp.test(document.registerForm.memberId.value))) {
		document.getElementById("memberIdError").innerHTML="User numbers and alphabets 5-8 in length";
		document.registerForm.memberId.value="";
		document.registerForm.memberId.focus();
		return false; 
	}
	if (!(emailExp.test(document.registerForm.email.value))) {
		document.getElementById("emailError").innerHTML="Invalid mail";
		document.registerForm.email.value="";
		document.registerForm.email.focus();
		return false; 
	}
</script>


</head>
<body>
<%@include file="Header.jsp" %>
<!-- <div id="loginName">Welcome to Part Page: <%=session.getAttribute("email") %></div> -->

<div id="nav">
	               
</div>

	<div class="wrapper1">
	<div class="container1">
	<div id="tabs">
		<ul>
			<li><a href="#login">Login</a></li>
			<li><a href="#register">Sign up</a></li>
		</ul>
		<div id="login">
			<%
				if("Invalid Email or password".equals((String)session.getAttribute("email"))){
					%>
					<h6> Invalid Email or password. Please try again. </h6>
				<%}
			%>
			
			<form action="loginController" method="post">
			
				<label for="email">Email:</label>
				<br>
				<input type="email" name="email1" id="email1" required="required" autofocus="autofocus">
				<br>
				<label for="password">Password:</label>
				<br>
				<input type="password" name="password" id="password" required="required">
				<br>
				<label for="Member Category">Member Category</label>
				<br>
				<select name="memberCat" id="memberCat" required="required">
					<option value="">Please select</option>
					<option value="1">Member</option>
					<option value="2">Seller</option>
					<option value="3">Agent</option>
				</select>
				<br>
				<br>
				
				<input type="submit" value="Login">			
			</form>
			
			<%
				if(request.getParameter("msg")!=null)
					out.print("<font color=\'red\'>"+request.getParameter("msg")+"</font>");
				
			%>
			
		</div>
		
		<script type="text/javascript">
			$(document).ready(function(){
				$("#email").blur(function(){
					var email=$("#email").val();
					$.get("checkEmailAvail",{
						email_Id:email
						},function(responseText){
								$("#ajaxResponse").text(responseText);
								if(responseText!=""){
									$("#email").val("");
								}
							});
				});
				
			});
		</script>
		
		<div id="register">
			<form action="registerController" method="post" name="registerForm" onsubmit="return validateParty();">
			
				<label for="Member Id">Member Id :</label>
				<br>
				<input type="text" id="memberId" name="memberId" required="required" autofocus="autofocus">
				<br>
				
				<label for="Name">Name :</label>
				<br>
				<input type="text" id="name" name="name" required >
				<br>
				
				<label>Address :</label>
				<br>
				<input type="text" id="address" name="address" required >
				<br>
				
				<label>Pincode :</label>
				<br>
				<input type="number" id="pincode" name="pincode">
				<br>
				
				<label>Phone Number :</label>
				<br>
				<input type="number" id="phoneNo" name="phoneNo" >
				<br>
				
				<label>Mobile Number :</label>
				<br>
				<input type="number" id="mobileNo" name="mobileNo" required>
				<br>
				
				<label>Email :</label>
				<br>
				<input type="email" id="email" name="email" required><span id="ajaxResponse"></span>
				<br>
				
				<label>Newsletter Subscription :</label>
				<br>
				<select name="newsletterSub" id="newsletterSub" >
					<option>Please select</option>
					<option value="No">No</option>
					<option value="Yes">Yes</option>
				</select>
				<br>
				
				<label>Password :</label>
				<br>
				<input type="password" id="password" name="password" required>
				<br>
				
				<label>Member Category :</label>
				<br>
				<select name="memberCat" id="memberCat" >
					<option >Please select</option>
					<option value="1">Member</option>
					<option value="2">Seller</option>
					<option value="3">Agent</option>
				</select>
				<br>
				<br>
				
				<input type="submit" name="register" id="register" value="Register">
			
			</form>		
		</div>

	</div>
	</div>
	</div>

<%@include file="Footer.jsp" %>
</body>
</html>
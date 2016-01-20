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


<div id="nav">
	               
</div>

	<div class="wrapper1">
	<div class="container1">
	<div id="tabs">
		<ul>
			<li><a href="#login">Login</a></li>
			<!-- <li><a href="#register">Sign up</a></li> -->
		</ul>
		<div id="login">
			<%
				if("Invalid Email or password".equals((String)session.getAttribute("error"))){
					%>
					<h6> Invalid Email or password. Please try again. </h6>
				<%}
			%>
			
			<form action="adminLogin" method="post">
			
				<label for="User Id">User Id:</label>
				<br>
				<input type="text" name="userId1" id="userId1" required="required">
				<br>
				<label for="password">Password:</label>
				<br>
				<input type="password" name="password" id="password" required="required">
				<br>
				
				<br>
				<br>
				
				<input type="submit" value="Login">			
			</form>
			
			<%
				if(request.getParameter("msg")!=null)
					out.print("<font color=\'red\'>"+request.getParameter("msg")+"</font>");
				
			%>
			
		</div>
		
	<!-- 
		<script type="text/javascript">
			$(document).ready(function(){
				$("#userId").blur(function(){
					var userId=$("#userId").val();
					$.get("checkAdminAvail",{
						user_Id:userId
						},function(responseText){
								$("#ajaxResponse").text(responseText);
								if(responseText!=""){
									$("#userId").val("");
								}
							});
				});
				
			});
		</script>
		
		<div id="register">
			<form action="adminRegister" method="post" name="adminRegForm" onsubmit="return validateParty();">
			
				<label for="User Id">User Id :</label>
				<br>
				<input type="text" id="userId" name="userId">
				<br>
				
				<label for="Password">Password :</label>
				<br>
				<input type="password" id="password" name="password" required >
				<br>
				
				<br>
				<br>
				
				<input type="submit" name="register" id="register" value="Register">
			
			</form>		
		</div>

		-->

	</div>
	</div>
	</div> 
	

<%@include file="Footer.jsp" %>
</body>
</html>
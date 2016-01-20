<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<jsp:useBean id="img" class="com.enlightenhome.image.model.Image" scope="page" />
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enlighten Home</title>
<link href="css/Search.css" type="text/css" rel="stylesheet">

<style type="text/css">
body{
		margin: 0;
	}

</style>
</head>
<body>
<%@include file="Header.jsp" %>

<div id="container">
	<div class="RegBtn">
	
	</div>
	
	
	<div id="nav">
               
    </div>
	
	<div id="mainArea">
	  <div class="container page">
	    

  	   <div id="pi">
  	   
  	   <sql:setDataSource var="webappDataSource"
    	driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project1"
    	user="root" password="root" />
  	   
  	   <sql:query dataSource="${webappDataSource}"
    	sql="select property_id, category_id, country, state, city, region, posted_by, area, rate, lumpsum_cost, image from property_details"  var="result" />
  	   
  	   
  	   <table class="pi" align="center" border="1" width="50%" cellpadding="4" cellspacing="0" >
  	   			<thead>
				<tr><th colspan='11'>Property Ads</th></tr>
				</thead>
				<tr>
					<td width='10%'>Property Id</td><td>Category Id</td><td>Country</td><td>State</td><td>City</td><td>Region</td><td>Posted By</td><td>Area</td><td>Rate</td><td>Lump Sum</td><td>Image</td>
				</tr>
					<c:forEach var="row" items="${result.rows }" >
						<tr>
							<td><c:out value="${row.Property_Id }"></c:out></td>
							<td><c:out value="${row.Category_Id }"></c:out></td>
							<td><c:out value="${row.Country }"></c:out></td>
							<td><c:out value="${row.State }"></c:out></td>
							<td><c:out value="${row.City }"></c:out></td>
							<td><c:out value="${row.Region }"></c:out></td>
							<td><c:out value="${row.Posted_By }"></c:out></td>
							<td><c:out value="${row.Area }"></c:out></td>
							<td><c:out value="${row.Rate }"></c:out></td>
							<td><c:out value="${row.Lumpsum_Cost }"></c:out></td>
							<td>
								<img src="">
								<c:out value="${row.Image }" ></c:out>
							</td>
						 </tr>
					</c:forEach>
				<tr><td colspan='11' align='right'><input type='button' name='reg' class='abc' value='Details'></td></tr>  	   			
  	   		</table>
  	   	   	
  	 
  	   	   				
  	   </div>
  	   
  	   
  	   		<!-- Hold the home image -->
  	   	<div class="estateImg">
  	   		<img alt="" src="img2/back1.jpg" style="width: 500px; height: 500px;">
  	   	</div>
  	   
	  </div>
	
	</div>	
</div>



<%@include file="Footer.jsp" %>
</body>
</html>
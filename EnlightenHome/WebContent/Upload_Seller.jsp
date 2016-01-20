<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Property Details</h1>
	<form action="uploadServlet_Seller" name="fileform_seller" method="post" enctype="multipart/form-data">
	<pre>
		<label for="Property Id">Property Id: </label>
			<input type="text" name="propertyId" size="50" required>
			
		<label for="Category Id">Category Id: </label>
			<select name="categoryId" id="categoryId" required >
					<option >Please select</option>
					<option value="1">Apartment</option>
					<option value="2">Studio</option>
					<option value="3">Flat</option>
					<option value="4">1 BHK</option>
					<option value="5">2 BHK</option>
					<option value="6">3 BHK</option>
			</select>
			
		<label for="Country">Country: </label>
			<input type="text" name="country" size="50" >
			
		<label for="Country">State: </label>
			<input type="text" name="state" size="50" >
		
		<label for="City">City: </label>
			<input type="text" name="city" size="50" >
		
		<label for="Region">Region: </label>
			<input type="text" name="regon" size="50">
		
		<label for="Posted By">Posted By: </label>
			<input type="text" name="postedBy" size="50" >
		
		<label for="Area">Area: </label>
			<input type="text" name="area" size="50" >
		
		<label for="Rate">Rate: </label>
			<input type="text" name="rate" size="50" >
		
		<label for="Lumpsum Cost">Lumpsum Cost: </label>
			<input type="text" name="lumpsumCost" size="50" >
		
		<label for="Image">Image: </label>
			<input type="file" name="image" size="50" required>
		<br>
		<br>
		<input type="submit" value="Save">
		
	</pre>
	</form>

</body>
</html>
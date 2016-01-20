<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/AdminHome.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function disableback(){
window.history.forward();
}
disableback();
</script>

</head>
<body onload="disableback();">
<%@include file="AdminHeader.jsp" %>

<div id="templatemo_content_wrapper">

	<div id="templatemo_content">
    
        <div class="content_section">
        
            <h2><div id="loginName">Welcome :<%=session.getAttribute("userId") %></div></h2>
            
            <div class="product_box margin_r10">
            
	            <h3>Meadows</h3>
                <img src="img2/2.jpg" alt="product" class="abcd">
              <p class="price">Price: $180</p>
                <a href="#" title="flower box">Detail</a> | <a href="#">Seasons Top Sales</a>
            </div>
            
            <div class="product_box margin_r10">
	            <h3>Lake Home</h3>
                <img src="img2/3.jpg" alt="product" class="abcd">
                    
                  <p class="price">Price: $240</p>
                    <a href="#" title="some notes">Detail</a> | <a href="#">Seasons Top Sales</a>
            </div>
            
            
            <div class="product_box ">
	            <h3>Broad Way</h3>
                <img src="img2/4.jpg" alt="product" class="abcd">
                
              <p class="price">Price: $120</p>
                <a href="#" title="notes About Floweers" target="_blank">Detail</a> | <a href="#">Seasons Top Sales</a>
            </div>
            
            <div class="cleaner"></div>
            
            <div class="button_01"><a href="#">Show All</a></div>
        
        </div> 
        
        <div class="cleaner_h40"></div>
        <div class="content_section">
        
        <h2>Administrator</h2>
        
        	<img src="images/image_05.jpg" alt="image" class="fl_image">
                    
            <p class="em_text">This is only for system administrator</p>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ac felis mauris, a fringilla ipsum. Nulla purus purus, tristique vitae tincidunt id, tincidunt in elit. Nulla facilisi. Curabitur nec leo nulla, interdum fermentum tellus.</p>
        
        </div>
    

    </div> <!-- end of content -->

    
    <div id="templatmeo_sidebar">
    
    	<div class="sidebar_section">
       		
            <h2>Right Bar</h2>
       	
       		<div class="sidebar_section_content">
                    
                <ul class="categories_list">
                    <li><a href="#">Lorem ipsum dolor</a></li>
                    <li><a href="#">Phasellus eget lorem</a></li>
                    <li><a href="#">Sed sit amet sem</a></li>
                    <li><a href="#">Cras eget est vel</a></li>
                    <li><a href="#">Quisque in ligula</a></li>
                    <li><a href="#">Donec a massa dui</a></li>
                    <li><a href="#">Aenean facilisis</a></li>
                    <li><a href="#">Etiam vitae consequat</a></li>
                    <li><a href="#">Aliquam sollicitudin</a></li>
                    <li><a href="#">Nunc fermentum</a></li>
                </ul>
            </div>
             
        </div>
        
        <div class="cleaner_h30"></div>
        <div class="sidebar_section">
        
        	<h2>Today's letter</h2>
            
            <div class="sidebar_section_content">
                <form action="#" method="get">
                <label>Please enter your email address to subscribe our newsletter.</label>
                <input type="text" value="" name="username" size="10" id="input_field" title="usernmae">
                <input type="submit" name="login" value="Subscribe" alt="login" id="submit_btn" title="Login">
                </form>
                <div class="cleaner"></div>
            </div>
			        
        </div>

	</div> <!-- end of sidebar -->
    
  	<div class="cleaner"></div>    

</div>	



<%@include file="Footer.jsp" %>
</body>
</html>
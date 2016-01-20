package com.enlightenhome.imagecontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlightenhome.dao.util.DButil;
import com.enlightenhome.image.model.Image;

@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private static final String sql = "select Image from property_details where Property_Id=?";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "select * from property_details";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Image> imgList = new ArrayList<Image>();
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			
				ps.setLong(1, Integer.valueOf(request.getParameter("Property_Id")));
				ps.setLong(2, Integer.valueOf(request.getParameter("Category_Id")));
				ps.setString(3, request.getParameter("Country"));
				ps.setString(4, request.getParameter("State"));
				ps.setString(5, request.getParameter("City"));
				ps.setString(6, request.getParameter("Region"));
				ps.setString(7, request.getParameter("Posted_By"));
				ps.setLong(8, Integer.valueOf(request.getParameter("Area")));
				ps.setString(9, request.getParameter("Rate"));
				ps.setString(10, request.getParameter("Lumpsum_cost"));
				rs = ps.executeQuery();
				if(rs.next()){
					//response.getOutputStream().write(rs.getBytes("Image"));
				}
				
			/*	
				img.setProperty_Id(rs.getString("Property_Id"));
				img.setCategory_Id(rs.getString("Category_Id"));
				img.setCountry(rs.getString("Country"));
				img.setState(rs.getString("State"));
				img.setCity(rs.getString("City"));
				img.setRegion(rs.getString("Region"));
				img.setPosted_By(rs.getString("Posted_By"));
				img.setArea(rs.getInt("Area"));
				img.setRate(rs.getFloat("Rate"));
				img.setLumpsum_Cost(rs.getFloat("Lumpsum_Cost"));
				img.setInputStream(rs.getByte("Image"));
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*try{
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);

			//HttpSession session = request.getSession();
			//List<Image> imgList = new ArrayList<Image>();
			
			//rs = ps.executeQuery();
			
			//while(rs.next()){
				//Image img = new Image();
				//img.setProperty_Id(rs.getString("Property_Id"));
				//img.setCategory_Id(rs.getString("Category_Id"));
				//img.setCountry(rs.getString("Country"));
				//img.setState(rs.getString("State"));
				//img.setCity(rs.getString("City"));
				//img.setRegion(rs.getString("Region"));
				//img.setPosted_By(rs.getString("Posted_By"));
				//img.setArea(rs.getInt("Area"));
				//img.setRate(rs.getFloat("Rate"));
				//img.setLumpsum_Cost(rs.getFloat("Lumpsum_Cost"));
				
				
				ps.setInt(1, request.getParameter("Property_Id"));
				ps.setInt(2, request.getParameter("Category_Id"));
				ps.setString(3, request.getParameter("Country"));
				ps.setString(4, request.getParameter("State"));
				ps.setString(5, request.getParameter("City"));
				ps.setString(6, request.getParameter("Region"));
				ps.setString(7, request.getParameter("Posted_By"));
				ps.setInt(8, request.getParameter("Area"));
				ps.setFloat(9, request.getParameter("Rate"));
				ps.setFloat(10, request.getParameter("Lumpsum_cost"));
				
				rs = ps.executeQuery();
				if(rs.next()){
					Blob blob = rs.getBlob("Image");
					InputStream inputStream = blob.getBinaryStream();
					OutputStream outputStream = new FileOutputStream("Search.jsp");
					
					int bytesRead = -1;
					byte[] buffer = new byte[BUFFER_SIZE];
					while((bytesRead = inputStream.read(buffer)) != -1){
						outputStream.write(buffer, 0, bytesRead);
					}
				//if(inputStream != null){
					//files are treated as BLOB objects in database
	                //here we're letting the JDBC driver
	                //create a blob object based on the
	                //input stream that contains the data of the file
					
					//ps.setBlob(11, inputStream);
				//}
				//img.setInputStream(rs.getBinaryStream("Image"));
				//imgList.add(img);
				
				//}
			
			//request.setAttribute("propList", imgList);
			//request.getRequestDispatcher("Search.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		*/
		
		/*
		try {
			con = DButil.getConnection();
			
			IImageDao imgDao = new IImageDaoImpl();
			imgList = imgDao.getPropertyDetails(imgList);
			request.setAttribute("imageList", imgList);
			String url = "Search.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		String imageName = request.getPathInfo().substring(1);
		try {
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, imageName);
			
			try {
				rs = ps.executeQuery();
				
				if(rs.next()){
					byte[] Image = rs.getBytes("Image");
					response.setContentType(getServletContext().getMimeType(imageName));
					response.setContentLength(Image.length);
					response.getOutputStream().write(Image);
				}
				else{
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

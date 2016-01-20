package com.enlightenhome.image.seller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.enlightenhome.dao.util.DButil;

@MultipartConfig(maxFileSize = 16177215)//upload upto 16MB
public class UploadServlet_Seller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//private static final int BUFFER_SIZE = 4096;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		String message = null;
		String sql = "insert into property_details values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		/*
		String Property_Id = null;
		String Category_Id = null;
		String Country = null;
		String State = null;
		String City = null;
		String Region = null;
		String Posted_By = null;
		String Area = null;
		String Rate = null;
		String Lumpsum_Cost = null;
		Blob Image = null;
		Part filePart = null;
		InputStream inputStream = null;
		*/
		
		try {
			
			con  =DButil.getConnection();
			
			String Property_Id = request.getParameter("propertyId");
			String Category_Id = request.getParameter("categoryId");
			String Country = request.getParameter("country");
			String State = request.getParameter("state");
			String City = request.getParameter("city");
			String Region = request.getParameter("region");
			String Posted_By = request.getParameter("postedBy");
			int Area = Integer.parseInt(request.getParameter("area"));
			float Rate = Float.parseFloat(request.getParameter("rate"));
			float Lumpsum_Cost = Float.parseFloat(request.getParameter("lumpsumCost"));
			InputStream inputStream = null;
			Part filePart = request.getPart("image");
			if(filePart != null){
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());
				
				inputStream = filePart.getInputStream();
			}
			
			ps = con.prepareStatement(sql);
			ps.setString(1, Property_Id);
			ps.setString(2, Category_Id);
			ps.setString(3, Country);
			ps.setString(4, State);
			ps.setString(5, City);
			ps.setString(6, Region);
			ps.setString(7, Posted_By);
			ps.setInt(8, Area);
			ps.setFloat(9, Rate);
			ps.setFloat(10, Lumpsum_Cost);
			
			if(inputStream != null){
				//files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
				
				ps.setBlob(11, inputStream);
			}
			//send stmt to db server
			
			int row = ps.executeUpdate();
			if(row > 0){
				message = "file uploaded and saved in database";
			}
			
			PrintWriter out = response.getWriter();
			out.println("<font color='blue' >" + message +"</font>");
			out.println("<font color='bue'><a href='Seller.jsp'>BACK</a></font>");
			out.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}



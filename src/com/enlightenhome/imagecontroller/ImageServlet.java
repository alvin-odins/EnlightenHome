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


		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

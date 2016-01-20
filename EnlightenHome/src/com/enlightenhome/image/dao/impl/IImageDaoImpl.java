package com.enlightenhome.image.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.enlightenhome.dao.util.DButil;
import com.enlightenhome.image.dao.IImageDao;
import com.enlightenhome.image.model.Image;

public class IImageDaoImpl implements IImageDao {

	public List<Image> getPropertyDetails(List<Image> imageList) {
		
		String sql = "select * from property_details";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Image> imgList = null;
		
		
		try {
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			imgList = new ArrayList<Image>();
			
			while(rs.next()){
				Image image = new Image();
				image.setProperty_Id(rs.getString("Property_Id"));
				image.setCategory_Id(rs.getString("Category_Id"));
				image.setCountry(rs.getString("Country"));
				image.setState(rs.getString("State"));
				image.setCity(rs.getString("City"));
				image.setRegion(rs.getString("Region"));
				image.setPosted_By(rs.getString("Posted_By"));
				image.setArea(rs.getInt("Area"));
				image.setRate(rs.getFloat("Rate"));
				image.setLumpsum_Cost(rs.getFloat("Lumpsum_Cost"));
				image.setInputStream(rs.getBinaryStream("Image"));
				
				imgList.add(image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
					ps.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return imgList;
	}

}

package com.enlightenhome.userRegister.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.enlightenhome.dao.util.DButil;
import com.enlightenhome.user.model.User;
import com.enlightenhome.userRegister.dao.IUserRegisterDao;

public class IUserRegisterDaoImpl implements IUserRegisterDao{
	
	public boolean createUser(User usr) {
		
		String sql = "INSERT INTO member_detail VALUES (?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		
		
		try {
			con = DButil.getConnection();
			System.out.println("Connection established");
			ps = con.prepareStatement(sql);
			Random r = new Random();
			
			ps.setString(1, usr.getMember_Id()+r.nextInt(99999));
			ps.setString(2, usr.getMember_Name());
			ps.setString(3, usr.getAddress());
			ps.setString(4, usr.getPincode());
			ps.setString(5, usr.getPhone_Number());
			ps.setString(6, usr.getMobile_Number());
			ps.setString(7, usr.getEmail_Id());
			ps.setString(8, usr.getNewsletter_Subscription());
			ps.setString(9, usr.getPassword());
			ps.setString(10, usr.getMember_Category_Id());
			
			
			if(ps.executeUpdate() == 1){
				flag=true;
			}
			
		} catch (SQLException e) {
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
		return flag;
	}

	public boolean userLogin(String email, String password, String memberCat) {
		
		String sql="SELECT * FROM member_detail where Email_Id=? and Password=? and Member_Category_Id=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		
		try{
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, memberCat);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				flag=true;
			}
			
			/*while(rs.next()){
				userName = rs.getString("name");
			}*/
		}catch(SQLException e){
			e.getMessage();
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.getMessage();
					e.printStackTrace();
				}
			}
		}
		return flag;

	}

	public boolean checkEmailId(String email) {
		
		String sql = "select * from member_detail where Email_Id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()){
				flag = true;
			}
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
		return flag;
	}
}

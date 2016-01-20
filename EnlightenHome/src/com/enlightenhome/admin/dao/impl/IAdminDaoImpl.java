package com.enlightenhome.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.enlightenhome.admin.dao.IAdminDao;
import com.enlightenhome.admin.model.Administrator;
import com.enlightenhome.dao.util.DButil;

public class IAdminDaoImpl implements IAdminDao{

	public boolean adminLogin(String userId, String password) {
		String sql = "select * from administrator_login where User_Id=? and Password=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				flag = true;
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

	public boolean newAdmin(Administrator admin) {
		String sql = "insert into administrator_login values (?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		
		try {
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, admin.getUser_Id());
			ps.setString(2, admin.getPassword());
			
			if(ps.executeUpdate() == 1){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public boolean checkAdminExistId(String userId) {
		String sql = "select * from administrator_login where User_Id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			con = DButil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				flag = true;
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

	
}

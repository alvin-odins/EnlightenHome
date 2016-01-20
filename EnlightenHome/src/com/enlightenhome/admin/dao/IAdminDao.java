package com.enlightenhome.admin.dao;

import com.enlightenhome.admin.model.Administrator;

public interface IAdminDao {
	
	public boolean adminLogin(String userId, String password);
	
	public boolean newAdmin(Administrator admin);
	
	public boolean checkAdminExistId(String userId);
}

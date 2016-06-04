package com.enlightenhome.userRegister.dao;

import com.enlightenhome.user.model.User;

public interface IUserRegisterDao {
	
	public boolean createUser(User usr);
	
	public boolean userLogin(String email, String password, String memberCat);
	
	public boolean checkEmailId(String email);

}

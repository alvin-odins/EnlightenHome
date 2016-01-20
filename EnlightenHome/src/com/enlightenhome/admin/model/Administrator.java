package com.enlightenhome.admin.model;

public class Administrator {
	
	private String User_Id;
	private String Password;
	
	
	public Administrator(){
		super();
	}
	
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public String getPassword() {
		return Password;
	}
	
	

}

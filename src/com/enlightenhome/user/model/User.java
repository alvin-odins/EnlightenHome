package com.enlightenhome.user.model;

public class User {
	
	private String Member_Id;
	private String Member_Name;
	private String Address;
	private String Pincode;
	private String Phone_Number;
	private String Mobile_Number;
	private String Email_Id;
	private String Newsletter_Subscription;
	private String Password;
	private String Member_Category_Id;
	
	public User(){
		super();
	}

	public String getMember_Id() {
		return Member_Id;
	}

	public void setMember_Id(String member_Id) {
		Member_Id = member_Id;
	}

	public String getMember_Name() {
		return Member_Name;
	}

	public void setMember_Name(String member_Name) {
		Member_Name = member_Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getMobile_Number() {
		return Mobile_Number;
	}

	public void setMobile_Number(String mobile_Number) {
		Mobile_Number = mobile_Number;
	}

	public String getEmail_Id() {
		return Email_Id;
	}

	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}

	public String getNewsletter_Subscription() {
		return Newsletter_Subscription;
	}

	public void setNewsletter_Subscription(String newsletter_Subscription) {
		Newsletter_Subscription = newsletter_Subscription;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMember_Category_Id() {
		return Member_Category_Id;
	}

	public void setMember_Category_Id(String Member_Category_Id) {
		this.Member_Category_Id = Member_Category_Id;
	}

	
	
	

}

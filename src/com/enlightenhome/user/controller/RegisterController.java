package com.enlightenhome.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.enlightenhome.mailservice.util.MailServiceUtil;
import com.enlightenhome.user.model.User;
import com.enlightenhome.userRegister.dao.IUserRegisterDao;
import com.enlightenhome.userRegister.dao.impl.IUserRegisterDaoImpl;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Member_Id = null;
    	String Member_Name = null;
    	String Address = null;
    	String Pincode = null;
    	String Phone_Number = null;
    	String Mobile_Number = null;
    	String Email_Id = null;
    	String Newsletter_Subscription = null;
    	String Password = null;
    	String Member_Category_Id = null;
    	boolean flag=false;
    	
    	try {
			Member_Id = request.getParameter("memberId");
			Member_Name = request.getParameter("name").toUpperCase();
			Address = request.getParameter("address").toUpperCase();
			Pincode = request.getParameter("pincode");
			Phone_Number = request.getParameter("phoneNo");
			Mobile_Number = request.getParameter("mobileNo");
			Email_Id = request.getParameter("email").toUpperCase();
			Newsletter_Subscription = request.getParameter("newsletterSub");
			Password = request.getParameter("password");
			Member_Category_Id = request.getParameter("memberCat");
			
			User usr = new User();
			usr.setMember_Id(Member_Id);
			usr.setMember_Name(Member_Name);
			usr.setAddress(Address);
			usr.setPincode(Pincode);
			usr.setPhone_Number(Phone_Number);
			usr.setMobile_Number(Mobile_Number);
			usr.setEmail_Id(Email_Id);
			usr.setNewsletter_Subscription(Newsletter_Subscription);
			usr.setPassword(Password);
			usr.setMember_Category_Id(Member_Category_Id);
			
			
			IUserRegisterDao dao = new IUserRegisterDaoImpl();
			flag = dao.createUser(usr);
			if(flag){
				MailServiceUtil.sendMail(Email_Id, "Your Password Details", "user Name: "+Email_Id+", Password: "+Password);
			}
			
			request.getRequestDispatcher("Success.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

package com.enlightenhome.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlightenhome.userRegister.dao.IUserRegisterDao;
import com.enlightenhome.userRegister.dao.impl.IUserRegisterDaoImpl;

public class MemeberEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email_Id = "";
		boolean flag = false;
		String responseText = "";
		
		try{
			Email_Id = request.getParameter("email_Id");
			IUserRegisterDao dao = new IUserRegisterDaoImpl();
			flag = dao.checkEmailId(Email_Id);
			if(flag){
				responseText = Email_Id + " email already exist";
			}
			response.getWriter().write(responseText);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}

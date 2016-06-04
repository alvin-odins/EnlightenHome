package com.enlightenhome.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlightenhome.admin.dao.IAdminDao;
import com.enlightenhome.admin.dao.impl.IAdminDaoImpl;
import com.enlightenhome.admin.model.Administrator;

public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String User_Id = null;
		String Password = null;
		boolean flag = false;
		try {
			User_Id = request.getParameter("userId");
			Password = request.getParameter("password");
			
			Administrator admin = new Administrator();
			admin.setUser_Id(User_Id);
			admin.setPassword(Password);
			
			IAdminDao dao = new IAdminDaoImpl();
			flag = dao.newAdmin(admin);
			
			if(flag){
				response.sendRedirect("AdminLR.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

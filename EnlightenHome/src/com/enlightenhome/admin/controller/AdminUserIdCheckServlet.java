package com.enlightenhome.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlightenhome.admin.dao.IAdminDao;
import com.enlightenhome.admin.dao.impl.IAdminDaoImpl;

public class AdminUserIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String User_Id = "";
		boolean flag = false;
		String responseText = "";
		
		try {
			User_Id = request.getParameter("userId");
			
			IAdminDao dao = new IAdminDaoImpl();
			flag = dao.checkAdminExistId(User_Id);
			
			if(flag){
				responseText = User_Id + "already in use";
			}
			
			response.getWriter().write(responseText);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

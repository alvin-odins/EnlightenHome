package com.enlightenhome.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		Cookie [] cookArry = null;
		
		try {
			session = request.getSession(false);
			if(session != null)
				session.invalidate();
			
			cookArry = request.getCookies();
			for(int i = 0; i < cookArry.length; i++){
				Cookie cook = cookArry[i];
				cook.setMaxAge(0);
			}
			
			response.sendRedirect("Home.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.enlightenhome.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequestt(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequestt(request, response);
	}
	
	protected void processRequestt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		HttpSession session1 = null;
		Cookie [] cookArry1 = null;
		
		try {
			session1 = request.getSession(false);
			if(session1 != null){
				//session1.removeAttribute("userId1");// i added this to see if an solve logout problem
				session1.invalidate();
				
				cookArry1 = request.getCookies();
				for(int i = 0; i < cookArry1.length; i++){
					Cookie cook = cookArry1[i];
					cook.setMaxAge(0);
				}
				
				response.sendRedirect("Home.jsp");
			}
			
			//request.getRequestDispatcher("AdminLR.jsp").forward(request, response);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		response.setContentType("text/html");
		Cookie adminCookie = null;
		Cookie [] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("userId")){
					adminCookie = cookie;
					break;
				}
			}
		}
		if(adminCookie != null){
			adminCookie.setMaxAge(0);
			response.addCookie(adminCookie);
		}
		response.sendRedirect("AdminLR.jsp");
	}

}

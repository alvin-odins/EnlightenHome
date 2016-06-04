package com.enlightenhome.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enlightenhome.admin.dao.IAdminDao;
import com.enlightenhome.admin.dao.impl.IAdminDaoImpl;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String User_Id = null;
		String password = null;
		String path = null;
		boolean isExist = false;
		HttpSession session = null;
		
		try {
			User_Id = request.getParameter("userId1");
			password = (request.getParameter("password"));
			
			if(User_Id == null || password == null){
				/*
				 * can redrect to another page or display error message
				 * e.g
				 * RequestDispathcher rd = request.getRequestDispatcher("#modal");
				 * rd.forard(request, response);
				 */
				path = "Home.jsp";
				//path = "Home.jsp?msg=Provide sign in credentials";
			}
			if(request.getQueryString() != null){
				path = "Home.jsp";
				//path = "Home.jsp?msg=Action not allowed";
			}
			if("".equals(User_Id) || "".equals(password)){
				//data is empty
				path = "Home.jsp";
				//path = "Home.jsp?msg=Enter your username and password";
			}
			else{
				IAdminDao dao = new IAdminDaoImpl();
				isExist = dao.adminLogin(User_Id, password);
				
				if(isExist){
					path = "Admin.jsp";
					session = request.getSession(false);//i set this false trying to solve logour problem
					session.setAttribute("userId", User_Id);
					Cookie adminCookie = new Cookie("userId", User_Id);
					//set cookie to expire in 30mins
					adminCookie.setMaxAge(30*60);
					response.addCookie(adminCookie);
					//response.sendRedirect(path);
					/*
					path = "Admin.jsp";
					session = request.getSession(false);//i set this false trying to solve logour problem
					session.setAttribute("userId", User_Id);
					*/
				}else{
					path = "AdminLR.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
					//PrintWriter out = response.getWriter();
					//out.println("<font color=red>Check username and password</font>");
					//rd.include(request, response);
					/*
					path = "AdminLR.jsp";
					//path = "AdminLR.jsp?msg=Something went wrong";
					 */
				}
			}
			
			request.getRequestDispatcher(path).forward(request, response);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}

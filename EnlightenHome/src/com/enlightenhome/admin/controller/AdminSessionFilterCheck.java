package com.enlightenhome.admin.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminSessionFilterCheck implements Filter {

    public AdminSessionFilterCheck() {
       
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession(false);
		System.out.println("request :"+req.getRequestURI()+"   "+new Date());
		
		if(req.getRequestURI().equals("/EnlightenHome/adminLogin")){
			chain.doFilter(request, response);
		}if(!req.getRequestURI().equals("/EnlightenHome/AdminLR.jsp")){
			if(session == null){
				//available
				res.sendRedirect("AdminLR.jsp");
			}
			else if(session != null && session.getAttribute("userId1") == null){
				res.sendRedirect("AdminLR.jsp");
			}else{
				
				chain.doFilter(request, response);
				
			}
		}else{

		chain.doFilter(request, response);
		
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

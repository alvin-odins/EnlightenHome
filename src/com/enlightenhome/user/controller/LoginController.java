package com.enlightenhome.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enlightenhome.userRegister.dao.IUserRegisterDao;
import com.enlightenhome.userRegister.dao.impl.IUserRegisterDaoImpl;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session = null;

    public LoginController() {
        super();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String error;
		String Email_Id = null;
		String Password = null;
		String Member_Category_Id = null;
		String path = null;
		boolean isExist = false;

		try {
			Email_Id = request.getParameter("email1");
			Password = request.getParameter("password");
			Member_Category_Id = request.getParameter("memberCat");

			if (Email_Id == null ||  Password == null || Member_Category_Id == null) {


				path="LoginSignup.jsp";
				//path="LoginSignup.jsp?msg=Invalid Access";
			}
			if (request.getQueryString() != null) {
				path="LoginSignup.jsp";
				//path="LoginSignup.jsp?msg=Improper Input";
			}
			if ("".equals(Email_Id) || "".equals(Password) || "".equals(Member_Category_Id)) {
				//data is empty
				path="LoginSignup.jsp";
				//path="LoginSignup.jsp?msg=Invalid Data";
			}
			else{
				IUserRegisterDao usr = new IUserRegisterDaoImpl();
				isExist = usr.userLogin(Email_Id, Password, Member_Category_Id);


				if(isExist){
					session=request.getSession(false);
					session.setAttribute("email", Email_Id);


					if("1".equals(Member_Category_Id)){
						path = "Member.jsp";
					}else if("2".equals(Member_Category_Id)){
						path = "Seller.jsp";
					}else if("3".equals(Member_Category_Id)){
						path = "Agent.jsp";
					}
				}else{
					path = "LoginSignup.jsp";
					//path = "LoginSignup.jsp?msg=Invalid Username and Password";
				}
			}


			request.getRequestDispatcher(path).forward(request, response);


		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}

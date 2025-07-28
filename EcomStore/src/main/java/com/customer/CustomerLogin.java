package com.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.service.DBService;

@WebServlet("/user_login")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/customer/user_login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		DBService dbs1 = new DBService();
		String username2 = dbs1.CustomerLogin(username,password);
		
		if (username2 != null) {
			HttpSession hts = request.getSession();
			hts.setAttribute("customer", username2);
			
			response.sendRedirect(request.getContextPath() + "/user/userdashboard");
			
		}else {
			
			request.getRequestDispatcher("/customer/user_login.jsp").forward(request, response);
			request.setAttribute("sts", "Login Failed! try again");
			
		}

	}

}

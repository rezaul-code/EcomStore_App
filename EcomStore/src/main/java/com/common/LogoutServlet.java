package com.common;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String role = request.getParameter("role");
		HttpSession https = request.getSession();
		https.invalidate();
		
		if ("admin".equalsIgnoreCase(role)) {
			
			response.sendRedirect(request.getContextPath()+ "/admin_login");
			
		}else if("seller".equalsIgnoreCase(role)) {
			
			response.sendRedirect(request.getContextPath()+ "/seller_login");
			
		}else if("user".equalsIgnoreCase(role)) {
						
			response.sendRedirect(request.getContextPath()+ "/user_login");
		}
		
	}

}

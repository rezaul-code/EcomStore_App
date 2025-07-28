package com.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.DBService;

@WebServlet("/admin_login")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/admin/admin_login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DBService serobj = new DBService();
		String adminName = serobj.adminLogin(username, password);
		
if (adminName != null) {
			
			request.getSession().setAttribute("admin", adminName);
			
			response.sendRedirect(request.getContextPath() + "/admin/admindashbord");
	        
		}else {
			 RequestDispatcher rs = request.getRequestDispatcher("/admin/admin_login.jsp");
			 rs.forward(request, response);
		}
		
		
	}

}

package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.CustomerDTO;
import com.service.AdminService;


@WebServlet("/admin/manage_user")
public class ManageUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminService adminService = new AdminService();
		List<CustomerDTO> userlist = adminService.getAllUsers();
		
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("/admin/manage_user.jsp").forward(request, response);
		
	}

	
}

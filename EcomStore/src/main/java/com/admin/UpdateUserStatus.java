package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.AdminService;

@WebServlet("/admin/UpdateUserStatus")
public class UpdateUserStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
        String status = request.getParameter("status");

        AdminService adminService = new AdminService();
        adminService.updateUserStatus(userId, status);

        response.sendRedirect("manage_user");
	}

}

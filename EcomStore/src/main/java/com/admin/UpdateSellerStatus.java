package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.AdminService;

@WebServlet("/admin/UpdateSellerStatus")
public class UpdateSellerStatus extends HttpServlet {
    private static final long serialVersionUID = 1L;

    AdminService adminService = new AdminService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int sellerId = Integer.parseInt(request.getParameter("sellerId"));
        String status = request.getParameter("status");

        // Call AdminService to update seller status
        adminService.updateSellerStatus(sellerId, status);

        // Redirect back to seller management
        response.sendRedirect(request.getContextPath() + "/admin/manage_seller");
    }
}

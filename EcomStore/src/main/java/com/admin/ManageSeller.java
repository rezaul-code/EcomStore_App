package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.SellerDTO;
import com.service.AdminService;

@WebServlet("/admin/manage_seller")
public class ManageSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminService adminService = new AdminService();
		 List<SellerDTO> sellerList = adminService.getAllSellers();
		
		 
		 request.setAttribute("sellerList", sellerList);
		request.getRequestDispatcher("/admin/manage_seller.jsp").forward(request, response);
		
	}


}

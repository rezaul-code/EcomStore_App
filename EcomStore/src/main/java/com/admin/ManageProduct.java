package com.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.database_connection.DatabaseConnection;
import com.dto.ProductDto;
import com.service.AdminService;

@WebServlet("/admin/manage_product")
public class ManageProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminService ads = new AdminService();
		List<ProductDto> productlist = ads.getAllProduct();
		request.setAttribute("pList", productlist);

		
		RequestDispatcher rs = request.getRequestDispatcher("/admin/manage_product.jsp");
		rs.forward(request, response);
	}

}

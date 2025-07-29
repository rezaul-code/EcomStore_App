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
import com.service.ProductService;

@WebServlet("/admin/manage_product")
public class ManageProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p_id = request.getParameter("p_id");
		
		if(null != p_id) {
			int id = Integer.parseInt(p_id);
			String action = request.getParameter("action");
			
			ProductService service = new ProductService();
			int status = service.updateProductStatus(id, action);
			
			if(status>0) {
				request.setAttribute("msg", "Status Update Success");
			}else {
				request.setAttribute("msg", "Status Update Failed");
				
			}
		}
		
		
		
		AdminService ads = new AdminService();
		List<ProductDto> productlist = ads.getAllProduct();
		request.setAttribute("pList", productlist);
		
		System.out.println("Product list size: " + productlist.size());

		
		RequestDispatcher rs = request.getRequestDispatcher("/admin/manage_product.jsp");
		rs.forward(request, response);
	}

}

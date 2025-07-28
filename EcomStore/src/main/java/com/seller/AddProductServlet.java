package com.seller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dto.ProductDto;
import com.service.ProductService;


@WebServlet("/seller/add_product")
public class AddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/seller/product.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("p_name");
		String description = request.getParameter("p_description");
		String category = request.getParameter("category");
		String price = request.getParameter("p_price");
		int p_price = Integer.parseInt(price);
		
		
		ProductDto dto = new ProductDto();
		dto.setP_name(name);
		dto.setP_description(description);
		dto.setP_category(category);
		dto.setP_price(p_price);
		
		ProductService pService = new ProductService();
		int status = pService.isertProduct(dto);
		if(status>0) {
			request.setAttribute("msg", "insert success");
		}else {
			request.setAttribute("msg", "insert failed");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/seller/product.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}

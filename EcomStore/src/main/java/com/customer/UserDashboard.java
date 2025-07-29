package com.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.ProductDto;
import com.service.CustomerService;
import com.service.ProductService;

@WebServlet("/user/userdashboard")
public class UserDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService pd1 = new ProductService();
		List<ProductDto> productList = pd1.showAllProduct();
		
		request.setAttribute("pList", productList);
		
		
		request.getRequestDispatcher("/customer/user_dashbord.jsp").forward(request, response);
	}

	
}

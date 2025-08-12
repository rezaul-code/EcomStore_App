package com.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.OrderDTO;
import com.service.ProductService;


@WebServlet("/user/user_orders")
public class UserOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (String) request.getSession().getAttribute("customer");
		
		ProductService ps1 = new ProductService();
		List<OrderDTO> orderDetails = ps1.getOrdersByUsername(username);
		
		request.setAttribute("orderDetails", orderDetails);
		
		RequestDispatcher rs = request.getRequestDispatcher("/customer/user_orders.jsp");
		rs.forward(request, response);
	}

	
}

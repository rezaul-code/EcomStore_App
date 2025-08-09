package com.product;

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
public class OrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (String) request.getSession(false).getAttribute("username");
	   
	    ProductService pd1 = new ProductService();
	    List<OrderDTO>  orders = pd1.getOrdersByUsername(username);
	    request.setAttribute("orders", orders);
	    request.getRequestDispatcher("/customer/order.jsp").forward(request, response);
		
	}

	
}

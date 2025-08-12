package com.seller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.OrderDetailsDTO;
import com.service.SellerService;



@WebServlet("/seller/orders")
public class SellerOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String) request.getSession().getAttribute("seller");
		
		SellerService slr = new SellerService();
		List<OrderDetailsDTO> list = slr.sellerOrderDetails(username);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("seller_orders.jsp").forward(request, response);
		
	}

}

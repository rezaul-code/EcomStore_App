package com.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.ProductService;



@WebServlet("/user/cancel_order")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (String) request.getSession().getAttribute("customer");
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		ProductService ps1 = new ProductService();
		int status = ps1.CancelOrderbyUser(username, id);
		
		if(status > 0) {
			
			request.setAttribute("status", "Your order has been cancelled! as per your request.");
			response.sendRedirect(request.getContextPath()+ "/user/user_orders");
			
		}else {
			request.setAttribute("status", "Order cancelled! try again after sometime");
			response.sendRedirect(request.getContextPath()+ "/user/user_orders");
		}
		
	}


}

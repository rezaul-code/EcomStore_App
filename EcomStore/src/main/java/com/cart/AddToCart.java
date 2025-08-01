package com.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.ProductService;

@WebServlet("/user/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String user_name = (String) request.getSession().getAttribute("customer");
		
		String p_ids = request.getParameter("p_id");
		int p_id = Integer.parseInt(p_ids);
		String quantitys = request.getParameter("quantity");
		int quantity = Integer.parseInt(quantitys);
		
		ProductService p_details = new ProductService();
		
		
		int result = p_details.addToCart(p_id, user_name, quantity);
		
		if (result>0) {
			
			request.setAttribute("msg", "Add to cart successfully");
			response.sendRedirect(request.getContextPath()+ "/user/userdashboard");
		}else {
			request.setAttribute("msg", "Add to cart failed!");
		}

	}


}

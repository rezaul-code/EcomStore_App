package com.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.ProductService;

@WebServlet("/user/remove")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p_ids = request.getParameter("p_id");
		int p_id = Integer.parseInt(p_ids);
		String user_name =  (String) request.getSession().getAttribute("customer");
		
		ProductService ps1 = new ProductService();
		int result = ps1.removeProductFromCart(p_id, user_name);

		if (0<result) {
			
			request.setAttribute("result", "Product remove successfuly");
			response.sendRedirect(request.getContextPath()+ "/user/user_Cart");
		}else {
			
			request.setAttribute("result", "Failed! try again");
		}
		
	}

}

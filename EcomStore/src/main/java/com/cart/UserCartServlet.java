package com.cart;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.CartProductDto;
import com.dto.ProductDto;
import com.service.ProductService;

@WebServlet("/user/user_Cart")
public class UserCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_name =  (String) request.getSession().getAttribute("customer");

		
		ProductService p_obj = new ProductService();
		List<CartProductDto> cartList = p_obj.myCartProduct(user_name);
		
		request.setAttribute("cart_product", cartList);
		
		
		
		
		RequestDispatcher  rs = request.getRequestDispatcher("/customer/user_cart.jsp");
		rs.forward(request, response);
	}

}

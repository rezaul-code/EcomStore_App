package com.cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dto.AddressDTO;
import com.dto.CartProductDto;
import com.service.CustomerService;
import com.service.ProductService;

@WebServlet("/user/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String username = (String) request.getSession().getAttribute("customer");

	        if (username == null) {
	            response.sendRedirect(request.getContextPath() + "/login.jsp");
	            return;
	        }

	        CustomerService cs1 = new CustomerService();
	        List<AddressDTO> addressList = cs1.getAddressByUsername(username);
	        request.setAttribute("addressList", addressList);

	        ProductService pService = new ProductService();
	        List<CartProductDto> cartList = pService.myCartProduct(username);
	        request.setAttribute("cart_product", cartList);

	        double grandTotal = 0;
	        for (CartProductDto item : cartList) {
	            grandTotal += item.getQuantity() * item.getPrice();
	        }

	        double shippingFee = 50.0;
	        double finalTotal = grandTotal + shippingFee;

	        request.setAttribute("grandTotal", grandTotal);
	        request.setAttribute("shippingFee", shippingFee);
	        request.setAttribute("finalTotal", finalTotal);

	        RequestDispatcher rs = request.getRequestDispatcher("/customer/checkout.jsp");
	        rs.forward(request, response);
	    }


}

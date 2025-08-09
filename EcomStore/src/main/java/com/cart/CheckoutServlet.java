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
import java.util.List;

import com.dto.AddressDTO;

@WebServlet("/user/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = (String) request.getSession().getAttribute("customer");
		
		List<AddressDTO> addressList = AddressDTO.getAddressesByUsername(username);
		request.setAttribute("addressList", addressList);
		
		RequestDispatcher rs = request.getRequestDispatcher("/customer/checkout.jsp");
		rs.forward(request, response);

	}


}

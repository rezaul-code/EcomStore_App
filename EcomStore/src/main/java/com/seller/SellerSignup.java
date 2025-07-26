package com.seller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dto.SellerDTO;
import com.service.DBService;

@WebServlet("/seller_signup")
public class SellerSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/seller/seller_signup.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String shop_name = request.getParameter("shop_name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		
		SellerDTO sd1 = new SellerDTO();
		
		sd1.setName(name);
		sd1.setEmail(email);
		sd1.setPassword(password);
		sd1.setShop_name(shop_name);
		sd1.setPhone(phone);
		sd1.setAddress(address);
		
		DBService dbs = new DBService();
		int status = dbs.sellerSignUp(sd1);
		
		if (status > 0) {
			request.setAttribute("message", "SignUp successfull");
		}else {
			request.setAttribute("message", "SignUp Failed!");
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("/seller/seller_signup.jsp");
		rs.forward(request, response);
	}
}

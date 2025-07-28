package com.seller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dto.SellerDTO;
import com.service.DBService;


@WebServlet("/seller/profile")
public class SellerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (String) request.getSession().getAttribute("seller");
		
		
		DBService dbs = new DBService();
		List<SellerDTO> seller = dbs.sellerProfile(username);
		
		
		request.setAttribute("sellerProfile", seller);

		request.getRequestDispatcher("seller_profile.jsp").forward(request, response);
		
	}


}

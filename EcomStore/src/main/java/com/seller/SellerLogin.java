package com.seller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.DBService;

@WebServlet("/seller_login")
public class SellerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher  rs = request.getRequestDispatcher("/seller/seller_login.jsp");
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		DBService serobj = new DBService();
		String sellerName = serobj.sellerLogin(name, password);
		
		if (sellerName != null) {
			
			request.getSession().setAttribute("seller", sellerName);
			
			response.sendRedirect(request.getContextPath() + "/seller/sellerdashbord");
			
		}else {
		    request.setAttribute("msg", "Invalid username or password");
		    RequestDispatcher rs = request.getRequestDispatcher("/seller/seller_login.jsp");
		    rs.forward(request, response);
		}

		
	}

}

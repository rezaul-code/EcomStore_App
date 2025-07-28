package com.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dto.CustomerDTO;
import com.service.DBService;

@WebServlet("/user_signup")
public class CustomerSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher  rs = request.getRequestDispatcher("/customer/customer_signup.jsp");
		rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		CustomerDTO cus1 = new CustomerDTO();
		cus1.setUsername(username);
		cus1.setEmail(email);
		cus1.setPassword(password);
		cus1.setPhone(phone);
		cus1.setAddress(address);
		
		DBService dbs = new DBService();
		int status = dbs.customerSignUp(cus1);
		
		if(status > 0){
		    request.setAttribute("message", "Registration Successful!");
		} else {
		    request.setAttribute("message", "Registration Failed.");
		}
		request.getRequestDispatcher("/customer/customer_signup.jsp").forward(request, response);
	}

}

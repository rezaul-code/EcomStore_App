package com.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.CustomerDTO;
import com.service.CustomerService;


@WebServlet("/user/user_profile")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String) request.getSession().getAttribute("customer");
		
		CustomerService user1 = new CustomerService();
		List<CustomerDTO> list3 = user1.userProfile(name);
		
		request.setAttribute("userProfile", list3);

		request.getRequestDispatcher("/customer/user_profile.jsp").forward(request, response);

	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
	}

}

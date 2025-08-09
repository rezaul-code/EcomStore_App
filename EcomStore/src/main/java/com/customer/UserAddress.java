package com.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dto.AddressDTO;
import com.service.CustomerService;

@WebServlet("/user/user_address")
public class UserAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/customer/user_address.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String full_name = request.getParameter("full_name");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postal_code = request.getParameter("postal_code");
		String country = request.getParameter("country");
		
		
		AddressDTO address1 = new AddressDTO();
		address1.setName(name);
		address1.setFull_name(full_name);
		address1.setStreet(street);
		address1.setCity(city);
		address1.setState(state);
		address1.setPostal_code(postal_code);
		address1.setCountry(country);
		
		
		CustomerService cstm1 = new CustomerService();
		int result = cstm1.insertUserAddress(address1);
		
		if (result>0) {
		
			request.setAttribute("status", "Address insert successfully");
			request.getRequestDispatcher("/customer/user_address.jsp").forward(request, response);

			
		}else {
			request.setAttribute("status", "Address insertion Failed!");
			request.getRequestDispatcher("/customer/user_address.jsp").forward(request, response);

		}

	}

}

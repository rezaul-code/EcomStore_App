package com.seller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.ProductDto;
import com.service.SellerService;

@WebServlet("/seller/seller_view_products")
public class SellerViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String seller = (String) request.getSession().getAttribute("seller");
	    System.out.println("Seller from session: " + seller);

	    SellerService slr = new SellerService();
	    List<ProductDto> productList = slr.getProductsBysellername(seller);

	    request.setAttribute("seller", seller); // ✅ for JSP header
	    request.setAttribute("productList", productList); 

	    request.getRequestDispatcher("/seller/seller_view_products.jsp").forward(request, response);
	}


}

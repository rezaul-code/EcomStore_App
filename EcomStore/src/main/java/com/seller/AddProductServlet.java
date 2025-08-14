package com.seller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

import com.dto.ProductDto;
import com.service.ProductService;

@MultipartConfig
@WebServlet("/seller/add_product")
public class AddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/seller/product.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sellername = (String) request.getSession().getAttribute("seller");
		
		String name = request.getParameter("p_name");
		String description = request.getParameter("p_description");
		String category = request.getParameter("category");
		String price = request.getParameter("p_price");
		int p_price = Integer.parseInt(price);
		Part p_image = request.getPart("product_image");
		
		
		ProductDto dto = new ProductDto();
		
		dto.setSellername(sellername);
		dto.setP_name(name);
		dto.setP_description(description);
		dto.setP_category(category);
		dto.setP_price(p_price);
		
		ProductService pService = new ProductService();
		
		String imageRelativePath = pService.insertProduct(dto);
		
		if(null != imageRelativePath) {
			String uploadPath = getServletContext().getRealPath("/")+ imageRelativePath;
			uploadPath = "E:\\Ecomerce\\EcomStore_App\\EcomStore\\src\\main\\webapp\\" +imageRelativePath;
			p_image.write(uploadPath);
		}else {
			
			String uploadPath = "E:\\Ecomerce\\EcomStore_App\\EcomStore\\src\\main\\webapp\\image\\product\\default.jpg";
//			request.setAttribute("Message", "image uploading failed !!");
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/seller/product.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}

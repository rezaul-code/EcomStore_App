package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;
import com.dto.AddressDTO;
import com.dto.OrderDetailsDTO;
import com.dto.ProductDto;

public class SellerService {

	public List<OrderDetailsDTO> sellerOrderDetails(String username) {
		
		int rows = 0;
		List<OrderDetailsDTO> odList = new ArrayList<OrderDetailsDTO>();
		Connection con = DatabaseConnection.getConnection();
		String sql = QueryClass.seller_order_details;
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
			    OrderDetailsDTO Odt = new OrderDetailsDTO();
			    Odt.setOrder_id(rs.getInt("order_id"));
			    Odt.setImg_path(rs.getString("img_path"));
			    Odt.setId(rs.getInt("id"));
			    Odt.setName(rs.getString("name"));
			    Odt.setDescription(rs.getString("description"));
			    Odt.setCategory(rs.getString("category"));
			    Odt.setPrice(rs.getInt("price"));
			    Odt.setQuantity(rs.getInt("quantity"));
			    Odt.setUsername(rs.getString("username"));
			    Odt.setAddress_id(rs.getInt("address_id"));
			    Odt.setPayment_method(rs.getString("payment_method"));
			    Odt.setTotal_amount(rs.getInt("total_amount"));
			    Odt.setOrder_date(rs.getTimestamp("order_date"));
			    odList.add(Odt);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return odList;
	}
	
	
	
	
	public List<ProductDto> getProductsBysellername(String sellername) {
	    Connection con = DatabaseConnection.getConnection();
	    List<ProductDto> productlist = new ArrayList<>();
	    String query = QueryClass.getProductBySellerName;

	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, sellername);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String description = rs.getString("description");
	            String category = rs.getString("category");
	            int price = rs.getInt("price");
	            String img_path = rs.getString("img_path");
	            String status = rs.getString("status");

	            ProductDto pdt = new ProductDto();
	            
	            pdt.setP_id(id);
	            pdt.setP_name(name);
	            pdt.setP_description(description);
	            pdt.setP_category(category);
	            pdt.setP_price(price);
	            pdt.setP_img(img_path);
	            pdt.setP_status(status);
	            productlist.add(pdt);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return productlist;
	}

	
	
	
	
	
}

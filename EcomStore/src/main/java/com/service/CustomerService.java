package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;
import com.dto.ProductDto;

public class CustomerService {
	
	public List<ProductDto> showAllProduct() {
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.show_product_query;
		List<ProductDto> pList = new ArrayList<ProductDto>();
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				String ids = rs.getString("id");
				int id = Integer.parseInt(ids);
				String name = rs.getString("name");
				String description = rs.getString("description");
				String category = rs.getString("category");
				String prices = rs.getString("price");
				int price = Integer.parseInt(prices);
				String image_path = rs.getString("img_path");
				String status = rs.getString("status");
				
				ProductDto p_list = new ProductDto();
				p_list.setP_id(id);
				p_list.setP_name(name);
				p_list.setP_description(description);
				p_list.setP_category(category);
				p_list.setP_price(price);
				p_list.setP_img(image_path);
				p_list.setP_status(status);
				
				pList.add(p_list);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pList;
	}
	
}

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

public class ProductService {
	

	
	public int updateProductStatus(int id ,String action) {
		
		Connection connection = DatabaseConnection.getConnection();
		String product_status_update = QueryClass.product_status_update;
		int rows =0;
		try {
			PreparedStatement ps = connection.prepareStatement(product_status_update);
			ps.setString(1, action);
			ps.setInt(2, id);
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows ;
		
	}
	

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
	
	
	
	

	public int isertProduct(ProductDto dto) {
		
		Connection connection = DatabaseConnection.getConnection();
		String product_insert_query = QueryClass.product_insert_query;
		String product_update_query = QueryClass.product_update_query;
		
		int rows = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(product_insert_query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getP_name());
			ps.setString(2, dto.getP_description());
			ps.setString(3, dto.getP_category());
			ps.setInt(4, dto.getP_price());
			
			rows = ps.executeUpdate();
			
			//Get the generated Id
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				 String imgPath = "image/product/" + id + ".jpg";
				 
				 //Update the image path
				PreparedStatement preparedStatement =  connection.prepareStatement(product_update_query);
				preparedStatement.setString(1, imgPath);
				preparedStatement.setInt(2, id);
				rows = preparedStatement.executeUpdate();
				

			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
		
	}

}

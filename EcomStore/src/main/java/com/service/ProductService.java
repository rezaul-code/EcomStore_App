package com.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

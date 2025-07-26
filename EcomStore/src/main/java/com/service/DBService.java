package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database_connection.DatabaseConnection;
import com.dto.SellerDTO;


public class DBService {
	
	
	public String sellerLogin(String username, String password) {
		
		String name1 = null;
		Connection con = DatabaseConnection.getConnection();
		String query = " ";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				name1 = rs.getString("username");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return name1;
	}
	
	
	public int sellerSignUp(SellerDTO sd1) {
		int rows = 0;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.seller_insert_query;
		
		try {
			PreparedStatement  ps = con.prepareStatement(query);
			ps.setString(1, sd1.getName());
			ps.setString(2, sd1.getEmail());
			ps.setString(3, sd1.getPassword());
			ps.setString(4, sd1.getShop_name());
			ps.setString(5, sd1.getPhone());
			ps.setString(6, sd1.getAddress());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	

	public String adminLogin(String username, String password) {
		
		String name = null;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.admin_check_query;
		
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("username");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
	
}

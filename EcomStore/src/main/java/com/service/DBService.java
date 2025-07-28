package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;
import com.dto.CustomerDTO;
import com.dto.SellerDTO;


public class DBService {
	
	
	public List<SellerDTO> sellerProfile(String username) {
		
		Connection con = DatabaseConnection.getConnection();
		List<SellerDTO> sellerD = new ArrayList<SellerDTO>();
		String query = QueryClass.seller_getDetails_query;
		
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet rs =  ps.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String shop_name = rs.getString("shop_name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				SellerDTO seller = new SellerDTO();
	            seller.setName(name);
	            seller.setEmail(email);
	            seller.setPassword(password);
	            seller.setShop_name(shop_name);
	            seller.setPhone(phone);
	            seller.setAddress(address);

	            sellerD.add(seller);
			
			}
			
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return sellerD;
	}
	
	
	
	
	
	
	
	
	
	
	public String CustomerLogin(String username, String password) {
		String name1 = null;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.user_check_query;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				name1 = rs.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name1;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int customerSignUp(CustomerDTO cus1) {
		
		int rows = 0;
		Connection  con = DatabaseConnection.getConnection();
		String query = QueryClass.user_insert_query;
		
		try {
			PreparedStatement  ps = con.prepareStatement(query);
			ps.setString(1, cus1.getUsername());
			ps.setString(2, cus1.getEmail());
			ps.setString(3, cus1.getPassword());
			ps.setString(4, cus1.getPhone());
			ps.setString(5, cus1.getAddress());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	
	
	public String sellerLogin(String name, String password) {
		
		String name1 = null;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.seller_check_query;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				name1 = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(name1);
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

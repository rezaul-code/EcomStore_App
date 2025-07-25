package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database_connection.DatabaseConnection;


public class DBService {

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

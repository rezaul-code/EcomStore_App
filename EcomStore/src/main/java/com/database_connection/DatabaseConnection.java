package com.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	static String db_url = "jdbc:mysql://localhost:3306/ecomerce_db";
	static String username = "root";
	static String password = "root";
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(db_url, username, password);
		}
		
		catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
		
		catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
		
		return con;
	}
	
	
	
}

package com.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // On Railway, these values are usually provided via Environment Variables
    // You can find these in your Railway Dashboard under the 'Variables' tab
    private static final String DB_URL = System.getenv("MYSQL_URL") != null 
            ? System.getenv("MYSQL_URL") 
            : "mysql://root:jHwpEfHIjfmgpuEallkQFKflQUXXjPBG@mysql.railway.internal:3306/railway"; // Replace with your actual Railway URL

    private static final String USERNAME = System.getenv("MYSQLUSER") != null 
            ? System.getenv("MYSQLUSER") 
            : "root"; 

    private static final String PASSWORD = System.getenv("MYSQLPASSWORD") != null 
            ? System.getenv("MYSQLPASSWORD") 
            : "your_password";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to Railway MySQL successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed. Check your Railway credentials and Whitelist (if applicable).");
            e.printStackTrace();
        }
        return con;
    }
}
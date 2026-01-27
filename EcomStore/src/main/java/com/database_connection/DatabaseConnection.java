package com.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Added "jdbc:" prefix to the Railway URL
    private static final String DB_URL = System.getenv("MYSQL_URL") != null 
            ? "jdbc:" + System.getenv("MYSQL_URL") 
            : "jdbc:mysql://root:jHwpEfHIjfmgpuEallkQFKflQUXXjPBG@mysql.railway.internal:3306/railway"; 

    private static final String USERNAME = System.getenv("MYSQLUSER") != null 
            ? System.getenv("MYSQLUSER") 
            : "root"; 

    private static final String PASSWORD = System.getenv("MYSQLPASSWORD") != null 
            ? System.getenv("MYSQLPASSWORD") 
            : "rootonline";

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Ensure you have the mysql-connector-j dependency in your pom.xml
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to Railway MySQL successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            // This will help you see the exact error if the credentials fail
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
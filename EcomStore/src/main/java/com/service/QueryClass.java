package com.service;

public class QueryClass {
	
	
	public static String admin_check_query = "SELECT * FROM admin WHERE username = ? AND password = ?";
	
	public static String seller_insert_query = "INSERT INTO seller (name, email, password, shop_name, phone, address, approved) VALUES (?, ?, ?, ?, ?, ?, TRUE)";
	public static String seller_check_query = "SELECT * FROM admin WHERE username = ? AND password = ?"; 
	
	
	
	
	
	
}
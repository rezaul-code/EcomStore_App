package com.service;

public class QueryClass {
	
	
	// <login-signup 
	public static String admin_check_query = "SELECT * FROM admin WHERE username = ? AND password = ?";
	public static String seller_insert_query = "INSERT INTO seller (name, email, password, shop_name, phone, address, approved) VALUES (?, ?, ?, ?, ?, ?, TRUE)";
	public static String seller_check_query = "select * from seller where name = ? and password = ?"; 
	public static String user_insert_query = "INSERT INTO customer (name, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
	public static String user_check_query = "select * from customer where name = ? and password = ?";
	
	public static String product_insert_query = "Insert into product (name,description,category,price)values (?,?,?,?)";
			
	public static String product_update_query = "UPDATE product SET img_path = ? WHERE id = ?";
	
	// seller - panel
	public static String seller_getDetails_query = "select * from seller where name = ?";
	
	
	
	// Admin Panel
	public static String product_getDetails_query = "select * from product ";
	
	public static String product_status_update = "UPDATE product SET status = ? WHERE id = ?";
	
	
	
}
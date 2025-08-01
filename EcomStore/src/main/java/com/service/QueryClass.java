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
	
	
	
	
	// customer panel																																																					
	public static String show_product_query = "select * from product where status = 'Approved'";
	public static String insert_to_cart = "INSERT INTO cart (user_name, p_id, quantity) VALUES (?, ?, ?)";
	public static String is_p_existIn_cart = "select * from cart where user_name = ? and p_id = ?";
	public static String update_p_quantity = "UPDATE cart SET quantity = ? WHERE user_name = ? AND p_id = ?";
	public static String my_cart_product = "SELECT c.user_name, c.p_id, c.quantity, p.name AS p_name, p.img_path AS p_img, p.price FROM cart c JOIN product p ON c.p_id = p.id WHERE c.user_name = ?";
	
	
	
	
}
package com.service;

public class QueryClass {
	
	
	// <login-signup 
	public static String admin_check_query = "SELECT * FROM admin WHERE username = ? AND password = ?";
	public static String seller_insert_query = "INSERT INTO seller (name, email, password, shop_name, phone, address, approved) VALUES (?, ?, ?, ?, ?, ?, TRUE)";
	public static String seller_check_query = "select * from seller where name = ? and password = ? and approved = 'Approved'"; 
	public static String user_insert_query = "INSERT INTO customer (name, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
	public static String user_check_query = "select * from customer where name = ? and password = ?";
	
	public static String product_insert_query = "Insert into product (seller_name, name, description, category, price, img_path)values (?,?,?,?,?,?)";
	
	public static String product_update_query = "UPDATE product SET img_path = ? WHERE id = ?";
	public static String user_status_query = "update customer set status = ? where id = ?";
	
	// seller - panel
	public static String seller_getDetails_query = "select * from seller where name = ?";																																																																																																					
	public static String getProductBySellerName = "select * from product where seller_name = ?";
	public static String seller_order_details = "select o.order_id, p.img_path, p.id, p.name, p.description, p.category, p.price, oi.quantity, o.username, o.address_id, o.payment_method, o.total_amount, o.order_date   from   product p join seller s on p.seller_name = s.name join order_items oi on oi.product_id = p.id join orders o on o.order_id=oi.order_id  where s.name = ?";
	
			
			
			
			
			
			// Admin Panel
	public static String product_getDetails_query = "select * from product ";
	public static String get_all_seller = "select * from seller ";
	public static String get_all_user = "select * from customer";
	
	public static String product_status_update = "UPDATE product SET status = ? WHERE id = ?";
	
	
	
	
	// customer panel																																																					
	public static String show_product_query = "select * from product where status = 'Approved'";
	public static String insert_to_cart = "INSERT INTO cart (user_name, p_id, quantity) VALUES (?, ?, ?)";
	public static String is_p_existIn_cart = "select * from cart where user_name = ? and p_id = ?";
	public static String update_p_quantity = "UPDATE cart SET quantity = ? WHERE user_name = ? AND p_id = ?";
	public static String my_cart_product = "SELECT c.user_name, c.p_id, c.quantity, p.name AS p_name, p.img_path AS p_img, p.price FROM cart c JOIN product p ON c.p_id = p.id WHERE c.user_name = ?";
	public static String remove_from_cart = "delete from cart where user_name = ? and p_id = ?";
	public static String user_profile_query = "select * from customer where name = ? ";
	public static String order_details = "select * from orders where username = ?";
	public static String insert_into_address = "INSERT INTO address (name, full_name, street, city, state, postal_code, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static String get_address_by_name = "select * from address where name = ?";
	
	
	
	public static String insert_order_sql = "INSERT INTO orders (username, address_id, payment_method, total_amount, order_date, status) VALUES (?, ?, ?, ?, ?, ?)";
	public static String insert_item_sql = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
	public static String delete_cart_item = "DELETE FROM cart WHERE user_name = ?";
	public static String cancel_order_query = "delete from orders where username= ? and order_id = ?";
	
	
	
	
	
	
	
	
	
	
	
	
}
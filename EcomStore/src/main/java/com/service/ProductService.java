package com.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;
import com.dto.CartProductDto;
import com.dto.OrderDTO;
import com.dto.ProductDto;

public class ProductService {
	
	public List<OrderDTO> getOrdersByUsername(String username) {
        List<OrderDTO> orders = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();

        try {
            String sql = QueryClass.order_details;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setOrderId(rs.getInt("order_id"));
                order.setName(rs.getString("name"));
                order.setOrderDate(rs.getTimestamp("order_date"));
                order.setTotalAmount(rs.getBigDecimal("total_amount"));
                order.setPaymentStatus(rs.getString("payment_status"));
                order.setShippingAddress(rs.getString("shipping_address"));

                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int removeProductFromCart(int p_id , String user_name) {
		
		int rows = 0;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.remove_from_cart;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user_name);
			ps.setInt(2, p_id);
			
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
		
	public int updateProductStatus(int id ,String action) {
		
		Connection connection = DatabaseConnection.getConnection();
		String product_status_update = QueryClass.product_status_update;
		int rows =0;
		try {
			PreparedStatement ps = connection.prepareStatement(product_status_update);
			ps.setString(1, action);
			ps.setInt(2, id);
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows ;
		
	}
	

	
	public List<CartProductDto> myCartProduct(String user_name) {
		
		String query = QueryClass.my_cart_product;
		List<CartProductDto> p_list = new ArrayList<CartProductDto>();
		Connection con = DatabaseConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user_name);
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				String name = rs.getString("user_name");
				int p_id = rs.getInt("p_id");
				int quantity = rs.getInt("quantity");
				String p_name = rs.getString("p_name");
				String p_img = rs.getString("p_img");
				double price = rs.getDouble("price");

				CartProductDto p_list2 = new CartProductDto();
				p_list2.setUser_name(name);
				p_list2.setP_id(p_id);
				p_list2.setQuantity(quantity);
				p_list2.setP_name(p_name);
				p_list2.setP_img(p_img);
				p_list2.setPrice(price);

				p_list.add(p_list2);
				


			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p_list;
	}
	
	
	
	public int addToCart(int p_id, String user_name, int quantity) {
		
		int rows = 0;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.insert_to_cart;
		String query2 = QueryClass.is_p_existIn_cart;
		String query3 = QueryClass.update_p_quantity;
		int newQty = quantity;
		boolean doUpdate = false;
		
		try {
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setString(1, user_name);
			ps.setInt(2, p_id );
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				newQty= quantity + rs.getInt("quantity");
				doUpdate = true;
			}
			
			if(doUpdate) {
				ps = con.prepareStatement(query3);
				ps.setInt(1, newQty);
				ps.setString(2, user_name);
				ps.setInt(3, p_id);
				
				rows = ps.executeUpdate();
				
			}else {
				ps = con.prepareStatement(query);
				ps.setString(1, user_name);
				ps.setInt(2, p_id);
				ps.setInt(3, newQty);
				
				rows = ps.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	
	public List<ProductDto> showAllProduct() {
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.show_product_query;
		List<ProductDto> pList = new ArrayList<ProductDto>();
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				String ids = rs.getString("id");
				int id = Integer.parseInt(ids);
				String name = rs.getString("name");
				String description = rs.getString("description");
				String category = rs.getString("category");
				String prices = rs.getString("price");
				int price = Integer.parseInt(prices);
				String image_path = rs.getString("img_path");
				String status = rs.getString("status");
				
				ProductDto p_list = new ProductDto();
				p_list.setP_id(id);
				p_list.setP_name(name);
				p_list.setP_description(description);
				p_list.setP_category(category);
				p_list.setP_price(price);
				p_list.setP_img(image_path);
				p_list.setP_status(status);
				
				pList.add(p_list);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
	
	
	

	public int isertProduct(ProductDto dto) {
		
		Connection connection = DatabaseConnection.getConnection();
		String product_insert_query = QueryClass.product_insert_query;
		String product_update_query = QueryClass.product_update_query;
		
		int rows = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(product_insert_query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getP_name());
			ps.setString(2, dto.getP_description());
			ps.setString(3, dto.getP_category());
			ps.setInt(4, dto.getP_price());
			
			rows = ps.executeUpdate();
			
			//Get the generated Id
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				 String imgPath = "image/product/" + id + ".jpg";
				 
				 //Update the image path
				PreparedStatement preparedStatement =  connection.prepareStatement(product_update_query);
				preparedStatement.setString(1, imgPath);
				preparedStatement.setInt(2, id);
				rows = preparedStatement.executeUpdate();
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
}

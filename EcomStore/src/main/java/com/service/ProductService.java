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
	
	public int CancelOrderbyUser(String username, int order_id) {
		
		int rows = 0;
		Connection con = DatabaseConnection.getConnection();
		String sql = QueryClass.cancel_order_query;
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, order_id);
			
			rows = ps.executeUpdate();		
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int placeOrder(String username, int addressId, String paymentMethod, double grandTotal) {
	    Connection con = DatabaseConnection.getConnection();
	    List<CartProductDto> cartItems = myCartProduct(username);
	    int orderId = 0;

	    try {
	       
	        if (cartItems.isEmpty()) {
	            return 0;
	        }

	        con.setAutoCommit(false);

	        String insertOrderSQL = QueryClass.insert_order_sql;
	        PreparedStatement psOrder = con.prepareStatement(insertOrderSQL, PreparedStatement.RETURN_GENERATED_KEYS);
	        psOrder.setString(1, username);
	        psOrder.setInt(2, addressId);
	        psOrder.setString(3, paymentMethod);
	        psOrder.setDouble(4, grandTotal);
	        psOrder.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
	        psOrder.setString(6, "Pending");
	        psOrder.executeUpdate();

	        ResultSet rsKeys = psOrder.getGeneratedKeys();
	        if (rsKeys.next()) {
	            orderId = rsKeys.getInt(1);
	        }

	        // Insert order items
	        String insertItemSQL = QueryClass.insert_item_sql;
	        PreparedStatement psItem = con.prepareStatement(insertItemSQL);
	        for (CartProductDto item : cartItems) {
	            psItem.setInt(1, orderId);
	            psItem.setInt(2, item.getP_id());
	            psItem.setInt(3, item.getQuantity());
	            psItem.setDouble(4, item.getPrice());
	            psItem.addBatch();
	        }
	        psItem.executeBatch();

	        // Clear the cart
	        String clearCartSQL = QueryClass.delete_cart_item;
	        PreparedStatement psClear = con.prepareStatement(clearCartSQL);
	        psClear.setString(1, username);
	        psClear.executeUpdate();

	        con.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
	        return 0;
	    } finally {
	        try { con.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
	    }

	    return orderId;
	}

	
	
	
	public List<OrderDTO> getOrdersByUsername(String username) {
		
        List<OrderDTO> orders = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String sql = QueryClass.order_details;
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                
                order.setOrder_id(rs.getInt("order_id"));
                order.setUsername(rs.getString("username"));
                order.setAddress_id(rs.getString("address_id"));
                order.setPayment_method(rs.getString("payment_method"));
                order.setTotal_amount(rs.getBigDecimal("total_amount"));
                order.setOrder_date(rs.getTimestamp("order_date"));
                order.setStatus(rs.getString("status"));
                
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
	
	
	
	

	public String insertProduct(ProductDto dto) {
	    Connection connection = DatabaseConnection.getConnection();
	    String insert_query = QueryClass.product_insert_query;
	    String update_query = QueryClass.product_update_query;

	    try {
	        PreparedStatement ps = connection.prepareStatement(insert_query,Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, dto.getSellername());
	        ps.setString(2, dto.getP_name());
	        ps.setString(3, dto.getP_description());
	        ps.setString(4, dto.getP_category());
	        ps.setInt(5, dto.getP_price());
	        ps.setString(6, "/image/product/defaul.jsp");
	       
	         ps.executeUpdate();
	         
	         ResultSet rs = ps.getGeneratedKeys();
	         int p_id = 0;
	         if (rs.next()) {
	        	 p_id = rs.getInt(1);
	         }
	         
	         String fileName = p_id + ".jpg";
	         String imageRelativePath = "/image/product/" + fileName;
	         
	         PreparedStatement ps2 = connection.prepareStatement(update_query);
	         ps2.setString(1, imageRelativePath);
	         ps2.setInt(2, p_id);
	         int sts = ps2.executeUpdate();
	         
	         if(sts >0) {
	        	 return imageRelativePath;
	         }
	         
	         
	         

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}

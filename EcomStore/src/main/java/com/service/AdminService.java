package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;
import com.dto.CustomerDTO;
import com.dto.ProductDto;
import com.dto.SellerDTO;

public class AdminService {
	
	
	public void updateUserStatus(int userId, String status) {
	    String sql = QueryClass.user_status_query;
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, status);
	        ps.setInt(2, userId);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	
			public List<CustomerDTO> getAllUsers() {
				
		        List<CustomerDTO> userList = new ArrayList<CustomerDTO>();
		        Connection conn = DatabaseConnection.getConnection();
		        String sql = QueryClass.get_all_user;
		        try {
		           
		        	Statement ps = conn.createStatement();
		            ResultSet rs = ps.executeQuery(sql);
		
		            while (rs.next()) {
		            	
		            	CustomerDTO user = new CustomerDTO();
		            	user.setId(rs.getInt("id"));
		            	user.setUsername(rs.getString("name"));
		            	user.setEmail(rs.getString("email"));
		            	user.setPassword(rs.getString("password"));
		            	user.setPhone(rs.getString("phone"));
		            	user.setAddress(rs.getString("address"));
		            	user.setStatus(rs.getString("status"));
		               
		            	userList.add(user);
		            	
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		
		        return userList;
		    }
	
	
	
	
	
	
	
	public List<SellerDTO> getAllSellers() {
		
        List<SellerDTO> sellerlist = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        String sql = QueryClass.get_all_seller;
        try {
           
        	Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
            	
                SellerDTO seller = new SellerDTO();
                seller.setId(rs.getInt("id"));
                seller.setName(rs.getString("name"));
                seller.setEmail(rs.getString("email"));
                seller.setApproved(rs.getString("approved"));
                sellerlist.add(seller);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sellerlist;
    }
	
	
	
	
	
	

    public void updateSellerStatus(int sellerId, String status) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE seller SET approved = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, sellerId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	
	
	
	public List<ProductDto> getAllProduct() {
		
		Connection  con = DatabaseConnection.getConnection();
		String query = QueryClass.product_getDetails_query;
		List<ProductDto> productList = new ArrayList<ProductDto>();
		
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
				
				productList.add(p_list);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}


}

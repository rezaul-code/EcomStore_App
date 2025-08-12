package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;
import com.dto.AddressDTO;
import com.dto.CustomerDTO;
import com.dto.ProductDto;

public class CustomerService {
	
	
	public List<AddressDTO> getAddressByUsername(String username) {
	    Connection con = DatabaseConnection.getConnection();
	    List<AddressDTO> addressL = new ArrayList<>();
	    String query = QueryClass.get_address_by_name; // Example: SELECT * FROM addresses WHERE username = ?

	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, username);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            AddressDTO add1 = new AddressDTO();
	            add1.setAddress_id(rs.getInt("address_id"));
	            add1.setFull_name(rs.getString("full_name"));
	            add1.setStreet(rs.getString("street"));
	            add1.setCity(rs.getString("city"));
	            add1.setState(rs.getString("state"));
	            add1.setPostal_code(rs.getString("postal_code"));
	            add1.setCountry(rs.getString("country"));
	            addressL.add(add1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return addressL;
	}

	
	
	public int insertUserAddress(AddressDTO address) {
		Connection con = DatabaseConnection.getConnection();
		int rows = 0;
		String query = QueryClass.insert_into_address;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, address.getName());
			ps.setString(2, address.getFull_name());
			ps.setString(3, address.getStreet());
			ps.setString(4, address.getCity());
			ps.setString(5, address.getState());
			ps.setString(6, address.getPostal_code());
			ps.setString(7, address.getCountry());
			
			rows = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	public List<CustomerDTO> userProfile(String name) {
		
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.user_profile_query;
		List<CustomerDTO> list1 = new ArrayList<CustomerDTO>();
		
		
			try {
				
				PreparedStatement  ps = con.prepareStatement(query);
				ps.setString(1, name);
				
				ResultSet  rs = ps.executeQuery();
				
				while(rs.next()) {
					
					String username = rs.getString("name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					
					CustomerDTO cus1 = new CustomerDTO();
					cus1.setUsername(username);
					cus1.setEmail(email);
					cus1.setPassword(password);
					cus1.setPhone(phone);
					cus1.setAddress(address);
					list1.add(cus1);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list1;
	}
	
	
	
	
	
}

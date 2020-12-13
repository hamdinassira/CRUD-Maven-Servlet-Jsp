package com.mobile.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobile.dao.MobileDao;
import com.mobile.db.Database;
import com.mobile.domain.Mobile;

public class MobileDaoImpl implements MobileDao {

	private static MobileDaoImpl mobileDaoImpl = null;

	private Connection connection = Database.getConnection();

	public void addMobile(Mobile mobile) {
		String sql = "INSERT INTO mobile"+"(reference, brand, price)" 
					+ "VALUES"+"(?,?,?)";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mobile.getReference());
			pstmt.setString(2, mobile.getBrand());
			pstmt.setFloat(3, mobile.getPrice());
			

			// Creating Customer Account
			pstmt.executeUpdate();
	
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void updateMobile(Mobile mobile) {
		String sql = "UPDATE mobile SET reference=?, brand=?, price=?" 
					+ "WHERE mobile_id=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mobile.getReference());
			pstmt.setString(2, mobile.getBrand());
			pstmt.setFloat(3, mobile.getPrice());
			

			// Update Customer Account
			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteMobile(int id) {
		String sql = "DELETE FROM mobile WHERE mobile_id=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, id);

			// Delete Customer Account
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Mobile findMobileById(int id) {
		Mobile mobile = null;
		String sql = "SELECT * FROM mobile WHERE mobile_id=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			// Getting Customer Detail
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				
				int mobile_id=resultSet.getInt("mobile_id");
				String reference=resultSet.getString("reference");
				String brand=resultSet.getString("brand");
				float price=resultSet.getFloat("price");
			mobile=new Mobile( reference, brand, price);
				
				
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return mobile;
	}

	public List<Mobile> findAllMobiles() {
		String sql = "SELECT * FROM mobile";
		List<Mobile> mobiles = new ArrayList<Mobile>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);

			// Getting Customer's Detail
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				int mobile_id = resultSet.getInt("mobile_id");
				String reference=resultSet.getString("reference");
				String brand=resultSet.getString("brand");
				float price=resultSet.getFloat("price");
				
				mobiles.add(new Mobile( reference, brand, price));

			}

		} catch (Exception ex) {
			
			
			
			System.out.println(ex.getMessage());
		}

		return mobiles;
	}

	
	
}

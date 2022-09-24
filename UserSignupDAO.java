package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.UserSignup;

public class UserSignupDAO {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	
	public UserSignup insertUser(UserSignup us) {
		String query="INSERT INTO user VALUES(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, us.getFirstname());
			ps.setString(2, us.getLastname());
			ps.setString(3, us.getEmail());
			ps.setString(4, us.getPassword());
			ps.setLong(5, us.getPhone());
			ps.setString(6, us.getDob());
			ps.setString(7, us.getGender());
			int row = ps.executeUpdate();
			if(row==1) {
				return us;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public UserSignup updateUser(UserSignup us) {
		String query="UPDATE user SET firstname=?, lastname=?, password=?, phone=?, dob=?, gender=? WHERE email=?";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, us.getFirstname());
			ps.setString(2, us.getLastname());
			ps.setString(7, us.getEmail());
			ps.setString(3, us.getPassword());
			ps.setLong(4, us.getPhone());
			ps.setString(5, us.getDob());
			ps.setString(6, us.getGender());
			int row = ps.executeUpdate();
			if(row==1) {
				return us;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int deleteUser(String email) {
		String query="DELETE FROM user WHERE EMAIL=?";
		try {
			Class.forName(path);
			Connection con= DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			int row=ps.executeUpdate();
			if(row==1) {
			return 1;	
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public UserSignup getUser(String email) {
		String query="SELECT * FROM user WHERE email=?";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(ps!=null) {
				UserSignup us = new UserSignup();
				while(rs.next()) {
					us.setFirstname(rs.getString(1));
					us.setLastname(rs.getString(2));
					us.setEmail(rs.getString(3));
					us.setPassword(rs.getString(4));
					us.setPhone(rs.getLong(5));
					us.setDob(rs.getString(6));
					us.setGender(rs.getString(7));
				}
				return us;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public List<UserSignup> getAllUser() {
		String query="SELECT * FROM user";
		try {
			Class.forName(path);
			Connection con= DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<UserSignup> list = new ArrayList<UserSignup>();
			while(rs.next()) {
				UserSignup us = new UserSignup();
				us.setFirstname(rs.getString(1));
				us.setLastname(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPassword(rs.getString(4));
				us.setPhone(rs.getLong(5));
				us.setDob(rs.getString(6));
				us.setGender(rs.getString(7));
				list.add(us);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UserSignup getUserByEmailAndPassword(String email, String password) {
		String query="SELECT * FROM user WHERE email=? and password=?";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, username, this.password);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					UserSignup us = new UserSignup();
					us.setFirstname(rs.getString(1));
					us.setLastname(rs.getString(2));
					us.setEmail(rs.getString(3));
					us.setPassword(rs.getString(4));
					us.setPhone(rs.getLong(5));
					us.setDob(rs.getString(6));
					us.setGender(rs.getString(7));
				return us;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}

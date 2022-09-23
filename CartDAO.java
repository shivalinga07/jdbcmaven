package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ty.dto.Cart;



public class CartDAO {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	
	public Cart insertCart(Cart c) {
		String query="INSERT INTO cart VALUES(?,?,?,?,?)";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getUsername());
			ps.setString(5, c.getAddress());
			int a=ps.executeUpdate();
			if(a==1) {
				return c;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cart updateCart(Cart c1) {
		String query="UPDATE cart SET email=?, password=?, username=?, address=? WHERE id=?";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(5, c1.getId());
			ps.setString(1, c1.getEmail());
			ps.setString(2, c1.getPassword());
			ps.setString(3, c1.getUsername());
			ps.setString(4, c1.getAddress());
			int a=ps.executeUpdate();
			if(a==1) {
				return c1;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int deleteCard(int id) {
		String query="DELETE FROM cart WHERE (id=?)";
		try {
			Class.forName(path);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1, id);
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
	
	public Cart getCart(int id) {
		String query="select * from cart WHERE id=?";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st= con.prepareStatement(query);
				st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			
			if(st!=null) {
				Cart m = new Cart();
				while(rs.next()) {
					m.setId(rs.getInt(1));
					m.setEmail(rs.getString(2));
					m.setPassword(rs.getString(3));
					m.setUsername(rs.getString(4));
					m.setAddress(rs.getString(5));
				}
				return m;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cart getAllCart() {
		String query="SELECT * FROM cart";
		try {
			Class.forName(path);
			Connection con=DriverManager.getConnection(url, username, password);
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getString(4)+" ");
				System.out.print(rs.getString(5)+" ");
				System.out.println();
			}
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

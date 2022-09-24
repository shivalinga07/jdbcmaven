package com.ty.controller;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class InsertCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartDAO cd = new CartDAO();
		Cart c = new Cart();
		c.setId(3);
		c.setEmail("mahesh@123");
		c.setPassword("kal@fg");
		c.setUsername("hi dear");
		c.setAddress("hyd");
		cd.insertCart(c);
		System.out.println("inserted");
	}

}

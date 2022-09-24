package com.ty.controller;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class UpdateCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartDAO cd = new CartDAO();
		Cart c1 = new Cart();
		c1.setId(2);
		c1.setEmail("shiva@456");
		c1.setPassword("kal@kd");
		c1.setUsername("bye");
		c1.setAddress("bly");
		cd.updateCart(c1);
		System.out.println("updated");

	}

}

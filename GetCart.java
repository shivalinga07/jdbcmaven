package com.ty.controller;


import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class GetCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartDAO cd = new CartDAO();
		Cart c1=cd.getCart(1);
		System.out.println(c1.getId());
		System.out.println(c1.getEmail());
		System.out.println(c1.getPassword());
		System.out.println(c1.getUsername());
		System.out.println(c1.getAddress());
		
	}

}

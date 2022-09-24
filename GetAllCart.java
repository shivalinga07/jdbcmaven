package com.ty.controller;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class GetAllCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartDAO cd = new CartDAO();
		cd.getAllCart();
	}

}

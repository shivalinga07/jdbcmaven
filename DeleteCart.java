package com.ty.controller;

import com.ty.dao.CartDAO;

public class DeleteCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartDAO cd =new  CartDAO();
		cd.deleteCard(3);
		System.out.println("deleted suceessfully");
		

	}

}

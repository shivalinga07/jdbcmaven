package com.ty.controller;

import com.ty.dao.UserSignupDAO;

public class DeleteUser {

	public static void main(String[] args) {
		UserSignupDAO usd = new UserSignupDAO();
		usd.deleteUser("kalyan@123");
		System.out.println("deleted successfully..!!!");

	}

}

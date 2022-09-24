package com.ty.controller;

import com.ty.dao.UserSignupDAO;
import com.ty.dto.UserSignup;

public class UpdateUser {

	public static void main(String[] args) {
		UserSignupDAO usd = new UserSignupDAO();
		UserSignup us = new UserSignup();
		us.setFirstname("kalyan1");
		us.setLastname("ryali1");
		us.setPassword("kalyan#1234");
		us.setPhone(94820017450l);
		us.setDob("18-04-1997");
		us.setGender("male");
		us.setEmail("kalyan@123");
		usd.updateUser(us);
		System.out.println("updated");


	}

}

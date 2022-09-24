package com.ty.controller;

import com.ty.dao.UserSignupDAO;
import com.ty.dto.UserSignup;

public class InsertUser {

	public static void main(String[] args) {
		UserSignupDAO usd = new UserSignupDAO();
		UserSignup us = new UserSignup();
		us.setFirstname("kalyan1");
		us.setLastname("ryali1");
		us.setEmail("kalyan@1234");
		us.setPassword("kalyan$123");
		us.setPhone(9482001746l);
		us.setDob("18-04-1996");
		us.setGender("male");
		usd.insertUser(us);
		System.out.println("inserted");

	}

}

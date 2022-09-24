package com.ty.controller;


import java.util.List;

import com.ty.dao.UserSignupDAO;
import com.ty.dto.UserSignup;

public class GetAllUser {

	public static void main(String[] args) {
		UserSignupDAO usd = new UserSignupDAO();
		List<UserSignup> us =usd.getAllUser();
		System.out.println(us);

	}

}

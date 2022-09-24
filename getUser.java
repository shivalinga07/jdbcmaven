package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserSignupDAO;
import com.ty.dto.UserSignup;

public class getUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserSignupDAO usd = new UserSignupDAO();
		System.out.println("enter mail");
		String email=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		UserSignup uu=usd.getUserByEmailAndPassword(email, password);
		System.out.println(uu);
	//	UserSignup uu=usd.getUser("kalyan@123");
	//	System.out.println(uu);
		if(uu!=null) {
		System.out.println("Welcome"+ uu.getFirstname());
		}else {
			System.out.println("Invalid email and password");
		}

	}

}

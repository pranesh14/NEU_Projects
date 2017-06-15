package com.fifa.controller;

import com.fifa.dao.UserDAO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("***** EXECUTING *****");
			UserDAO userDao = new UserDAO();
			System.out.println("***** DONE *****");
			
		}
		catch (Exception e) {
			System.out.println("***** EXCEPTION: " + e.getMessage());
		}
	}

}

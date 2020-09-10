package com.general;

public class SharedLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String to ascii
		int l= (int)'A' - 64;
		System.out.println(l);
		
		//Substring complete iteration.
		String s= "1262";
		for (int i = 1; i <= s.length(); i++) {
			System.out.println(s.substring(0, i));
		}
	}

}

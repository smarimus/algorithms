package com.leetcode;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(gcd(30, 21));
		System.out.println(gcd(105, 30));
		System.out.println(gcd(270,192));
		System.out.println(gcd(192,192));
		
	}
	
	public static int gcd(int a, int b){
		
		if(a < b) gcd(b, a);
		if(b == 0) return a;
		
		return gcd(b, a%b);
	}

}

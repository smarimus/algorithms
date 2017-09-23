package com.algo.recursion;

public class BitwiseOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		and();
		or();
		xor();
		not();
	}
	
	static void and(){
		System.out.println("And: ");
		int a =10; int b=20;
		System.out.println(a&b);
		System.out.println();
	}
	static  void or(){
		System.out.println("Or: ");
		int a =10; int b=20;
		System.out.println(a|b);
		System.out.println();
	}
	static  void xor(){
		System.out.println("xor: ");
		int a =20; int b=20;
		System.out.println(a^b);
		a=0;b=20; 
		System.out.println(a^b);
		a=20;b=0; 
		System.out.println(a^b);
		a=0;b=0; 
		System.out.println(a^b);
		a=21;b=10; 
		System.out.println(a^b);
		System.out.println();
	}
	static void not(){
		int a = 0 ;
		System.out.println(~a);
	}
	
	static void bitWiseLeftShift(){}
	static void bitWiseRightShift(){}
}

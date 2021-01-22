package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printOneComplement("00010000".substring(12, 5));
		
		int x=5;
		x=10;
		System.out.println(x);
		
		List b = new ArrayList();
		b.add("hello");
		b.add(2);
		
		//main(null);
		
		LinkedList ls = new LinkedList<>();
		ls.add(5);
		ls.add(1);
		ls.add(10);
		System.out.println(ls);
		
		
		System.out.println(100%3);
		
	}
	
	static void printOneComplement(String bin) {
		int n = bin.length();
		int i;
		String ones = "";

		for (i = 0; i < n; i++) {
			ones += (bin.charAt(i) == '0') ? '1' : '0';
		}
		System.out.println("1's complement: " + ones);
	}

}

package com.general;

public class Maths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MathChallenge(11312);
		MathChallenge(4321);
		MathChallenge(12);
		MathChallenge(21876);
	}
	
	public static int MathChallenge(int num) {
		
		char[] chars = ("" + num).toCharArray();
		
		if(chars.length < 2)
			return -1;
		int len = chars.length-1;
		
		int i=len;
		while(i-1 >= 0 && chars[i-1] > chars[i]){
			i--;
		}
		
		if(i==0){
			System.out.println("-1");
			return -1;
		}
		
		// find next biggest number
		//swap(i, );
		
		
		
		System.out.println(chars[i]);
		
		return 0;
	}
	
}

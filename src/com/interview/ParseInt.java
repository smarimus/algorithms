package com.interview;

public class ParseInt {

	public static void main(String[] args) {

		String s = "1234567891898776554";
		char c[] = s.toCharArray();
		
		long baseNumber =1;
		long num=0;
		long sum=0;
		
		for(int i=c.length-1; i>= 0; i--){
			   char numberString = c[i];
			   
			   int number = Character.getNumericValue(numberString);
			   
			   num = number*baseNumber;
			   baseNumber = baseNumber*10;
			   
			   sum = sum+num;
		}
		System.out.println(sum);
		
	

	}

}

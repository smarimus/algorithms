package com.algo.recursion;

public class FindMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3,5,6,4,2,8,1};
		//int[] arr = {10,13,15,16,14};
		//System.out.println(findMissingNumber(arr, arr.length));
		System.out.println(findMissingNumber2(arr));

	}
	
	static int findMissingNumber(int[] arr, int len){
		
		int total = ((len+1) * (len+2)/2);
		
		for (int i = 0; i < arr.length; i++) {
			total -= arr[i];
		}
		
		return total;
	}
	
	static int findMissingNumber2(int[] arr){
		int len = arr.length;
		int i;
		int x1=arr[0];
		int x2=1;
	
		// xor the array elements
		for (i = 1; i < len; i++) {
			x1 = x1 ^ arr[i];
			System.out.println("x1: " + x1);
		}
		
		// From xor 1 to n 
		for (i = 2; i <= len+1; i++) {
			x2 = x2 ^ i;
			System.out.println("x2: " + x2);
		}
		
		return (x1 ^ x2);
	}

}

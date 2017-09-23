package com.recursion;

public class PermuteString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static void permute(char[] a, int i ){
		
		int n = a.length;
		
		//base case
		if(i == n-1){
			System.out.println(a);
			return ;
		}
		
		for (int j = i; j < n-1; j++) {
			swap(a, i, j);
			permute(a, i+1);
			swap(a, j, i);
		}
	}
	
	static void swap(char[] a, int i, int j){
		
	}
}

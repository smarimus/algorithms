package com.ik.recursion.tt;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,2,3};
		
		sum(0, a.length-1, a, 5);
	}
	
	public static void sum(int soFar, int rest, int[] a, int k){
		if(rest == -1){
			//a[]
		}else{
			sum(soFar + soFar++, rest-1, a, k);
			sum(soFar, rest, a, k);
		}
	}
	
}
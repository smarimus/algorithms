package com.ik.array.part1;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pascalTriangle(8);
	}
	
	static void pascalTriangle(int n){
		
		int[] a = new int[n];
		for (int i = 1; i < n+1; i++) {
			int[] b = new int[i];
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < i; j++) {
				
				//first and last index will have value 1.
				if(j == 0 || j+1 == i){
					b[j] = 1;
					sb.append(b[j] + " ");
				}else{
					// the value of current element is sum of 2 previous element
					b[j] = a[j] + a[j-1];
					sb.append(b[j] + " ");
				}
			}
			System.out.println(sb.toString());
			a = b;
		}
	}
	
	
}
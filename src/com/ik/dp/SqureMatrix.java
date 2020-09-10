package com.ik.dp;

public class SqureMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 
		 * 1. formula to find the square
		 * 2. If first the row and column.
		 * 3. Else fill row and column with the value from the left, top, top left 
		 * 4. Also check for the the max square up to now.
		 * 
		 */
		
		/*
		 * cache
		 * array
		 * 
		 * 
		 * 
		 */	
	}
	
	public static int squareMatrix(boolean arr[][]){
		
		int cache[][] = new int[arr.length][arr[0].length];
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				
				if(i == 0 || j == 0){
					cache[i][j] = arr[i][j] ? 1 : 0;
				}else if(arr[i][j]){
					// the actual logic min
				}
				if(cache[i][j] > max) max = cache[i][j]; 
			}
		}
		return max;
	}
	
	
}
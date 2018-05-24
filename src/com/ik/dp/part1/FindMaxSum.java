package com.ik.dp.part1;

public class FindMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] b  = {
				{5, 1, 0},
				{0, 1, 0},
				{5, 13, 5},
				{11, 5, 0}
				};
		int[][] cache = new int[4][3];
		
		System.out.println(findMaxSum(b));
		System.out.println(findMaxSumDP(b, cache));
		
		System.out.println(maxSumIterative(b));
		
		System.out.println(Integer.MAX_VALUE +1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
	
	// Recursion
	public static int findMaxSum(int[][] a){
		return maxSum(a, 0, 0);
	}
	public static int maxSum(int[][] a, int r, int c){
		
		if(r == a.length-1 && c == a[0].length-1)
			return a[r][c];
		
		if(r > a.length-1 || c > a[0].length-1)
			return Integer.MIN_VALUE;

		return a[r][c] + Math.max(maxSum(a, r+1, c), maxSum(a, r, c+1));
	}
	
	
	// Dynamic Programming
	public static int findMaxSumDP(int[][] a, int[][] cache){
		return maxSumDP(a, cache, 0, 0);
	}
	
	public static int maxSumDP(int[][] a, int[][] cache, int r, int c){
		
		if(cache[r][c] != 0)
			return cache[r][c];
		
		if(r == a.length-1 && c == a[0].length-1)
			return a[r][c];
		
		if(r > a.length-1 || c > a[0].length-1)
			return Integer.MIN_VALUE;
		
		cache[r][c] = a[r][c] + Math.max(maxSum(a, r+1, c), maxSum(a, r, c+1));
		return cache[r][c];
	}
	
	public static int maxSumIterative(int[][] a){
		int[][] cache = new int[a.length][a[0].length];
		int rows = a.length-1;
		int cols = a[0].length-1;
		
		for (int row = rows; row >= 0; row--) {
			for (int col = cols; col >= 0; col--) {
				int curr = a[row][col]; 
				
				if(row == rows && col == cols){
					cache[row][col] = curr; continue;  
				}
				if(row+1 > rows){
					cache[row][col] = curr + cache[row][col+1];
					continue;
				}
				if(col+1 > cols){
					cache[row][col] = curr + cache[row+1][col];
					continue;
				}
				cache[row][col]= curr + Math.max(cache[row+1][col], cache[row][col+1]);
			}
		}
		return cache[0][0];
	}
}

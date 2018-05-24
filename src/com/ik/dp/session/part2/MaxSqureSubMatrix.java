package com.ik.dp.session.part2;

public class MaxSqureSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean [][] arr1 = {
				{false, false, false},
				{false, false, false},
				{false, true, true},
				{false, true, true},
				{false, true, true}};
		
		boolean [][] arr = {
				{false, false, false},
				{false, false, false},
				{false, true, false},
				{false, false, false},
				{false, false, false}};
		
		System.out.println(squareSubmatrix1(arr));
		System.out.println(squareSubmatrix(arr));
	}
	
	// corner
	public static int squareSubmatrix1(boolean[][] arr) {
		int max = 0;
		// Compute for each cell the biggest subarray
		
		int cache[][] = new int[arr.length][arr[0].length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j])
					max = Math.max(max, squareSubmatrix1(cache, arr, i, j));
			}
		}
		return max;
	}

	// Overloaded recursive function
	public static int squareSubmatrix1(int[][] cache, boolean[][] arr, int i, int j) {
		// Base case at bottom or right of the matrix
		if (i == arr.length || j == arr[0].length){
			System.out.println(arr.length + " " + i + " - " + arr[0].length + "  " + j );
			return 0;
		}
		// If the cell is false then it’s not part // of a valid submatrix
		if (!arr[i][j])
			return 0;
		
		if(cache[i][j] > 0 ) 
			return cache[i][j];
		
		// Find the size of the right, bottom, and
		// bottom right submatrices and add 1 to the // minimum of those 3 to
		// get the result
		cache[i][j] = 1 + Math.min(Math.min(squareSubmatrix1(cache, arr, i + 1, j), squareSubmatrix1(cache, arr, i, j + 1)),
				squareSubmatrix1(cache, arr, i + 1, j + 1));
		
		return cache[i][j];
	}
	
	// Bottom up solution. Start from the
	// upper left corner and compute each larger // submatrix
	public static int squareSubmatrix(boolean[][] arr) {
		int max = 0;
		// Initialize cache
		int[][] cache = new int[arr.length][arr[0].length];
		// Iterate over matrix to compute each value
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				// If we’re in the rst row/column then // the value is just 1 if
				// that cell is // true and 0 otherwise. In other rows and //
				// columns need to look up and to the left
				if (i == 0 || j == 0) {
					cache[i][j] = arr[i][j] ? 1 : 0;
				} else if (arr[i][j]) {
					cache[i][j] = Math.min(Math.min(cache[i][j - 1], cache[i - 1][j]), cache[i - 1][j - 1]) + 1;
				}
				if (cache[i][j] > max)
					max = cache[i][j];
			}
		}
		return max;
	}
	
	
}

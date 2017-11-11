package com.ik.recursion.session;

public class CountPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a1 = {{4,6,9,2},
						{4,6,9,2},
						{4,6,9,2},
						{4,6,9,2}};
		int[][] a2 = {{4,6,9,2,3},
				{4,6,9,2,3},
				{4,6,9,2,3},
				{4,6,9,2,3},
				{4,6,9,2,3}};
		
		
		int[][] a = {{4,6,1},
				{4,6,2},
				{7,0,1}};
		
		System.out.println(countPath(a1));
	}
	
	static int countPath(int[][] a){
		if(a== null || a.length < 0) 
			return 0;
	
		return countPath(a, 0, 0);
	}
	
	static int countPath(int[][] a, int r, int c){
		int m = a[0].length;
		int n = a.length;
		
		if(m-1 == c || n-1 == r)
			return 1;
		
		int left =0;
		if(r+1 < n ){
			left = countPath(a, r+1, c);
		}	
		int right=0;	
		if(c+1 < m ){
			right = countPath(a, r, c+1);
		}
		return left + right;
	}

}

package com.ik.array.part1;

public class TwoDSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a = {
				{1,10,20,30},
				{15,21,31,41},
				{17,25,35,43},
				{28,29,39,49}
				};
		
		System.out.println(search(a, 28));
		System.out.println();
	}
	
	
	static int search(int[][] a, int k){
		int result = -1;
		
		int i, j;
		i=0; j=a.length-1;
		
		while((i>=0 && j>=0) && (i<=a.length-1 && j<=a.length-1)){
			
			int val = a[i][j];
			System.out.print(val + " , ");
			if(val == k) return val;
			if(val > k){
				j--;continue;
			}
			if(val < k){
				i++; continue;
			}
		}
		return result;
	}
		
	
	static int searchBF(int[][] a, int k){
		int result = -1;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				int val = a[i][j];
				if(val == k){
					result=val;
					break;
				}	
			}
		}
		return result;
	}
}

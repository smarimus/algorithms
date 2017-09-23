package com.algo.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void binarySearch(int[] sorted, int value){
		int low = 0;
		int high = sorted.length; 
		
		while(low < high){
			
			int mid = sorted.length/2;
			int val = sorted[mid];
			
			if(value == val){
				System.out.println(val);
			}else if(value > val){
				low = 0;
				high = mid-1;
			}else if(value < val){
				low = mid+1;
				high = sorted.length ;
			}
		}
	}
	
	/*int magic (int[] sorted){
		int start = 0;
		int end = sorted.length;
		
		int mid = (start+end)/2;
		return rank;
	}*/
	
}

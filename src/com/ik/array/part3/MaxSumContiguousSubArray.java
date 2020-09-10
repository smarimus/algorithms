package com.ik.array.part3;

public class MaxSumContiguousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr = {-2, 1, -1};
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		System.out.println(maxProductSubset_N_2(arr));
	}
	//
	static int maxProductSubset_N_2(int arr[]){
		
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			int top = arr[i];
			int newSum=0;
			
			if(top > maxSum){
				maxSum = top;
				newSum=top;
			}
			
			for (int j = i+1; j < arr.length; j++) {
				int inner = arr[j];
				newSum = newSum + inner;
				
				if(newSum > maxSum)
					maxSum = newSum;
			}
		}
		return maxSum;
	}
	
	static int maxProductSubset_O_N(int arr[]){
		
		int maxEndingHere = 0;
		int maxSoFar = Integer.MIN_VALUE;;
		
		for (int i = 0; i < arr.length; i++) {
			
		}
		return maxSoFar;
	}
	
	/*
	 * Inner sum
	 * 	update when the new sum + new element is larger
	 * New element is > than inner sum
	 * 	update the max sum 
	 *
	 *	-2, -3, 4, -1, -2, 1, 5, -3
	 *			4, -1, -2, 1, 5
	 *
	 *	1, -3, 2, 1, -1
	 *  
	 *  
	 *  
	 *  Loop for each element of the array
		  (a) max_ending_here = max_ending_here + a[i]
		  (b) if(max_ending_here < 0)
		            max_ending_here = 0
		  (c) if(max_so_far < max_ending_here)
		            max_so_far = max_ending_here
	 * 
	 * 
	 * 	maxEndingHere = maxEndingHere + a[i]
	 * 
	 * if	(maxEndingHere < 0
	 * 	maxEndingHere  = 0;
	 * if	(maxEndingHere > maxSoFar 	
	 * 	 		maxSoFar = maxEndingHere
	 *  
	 */

}

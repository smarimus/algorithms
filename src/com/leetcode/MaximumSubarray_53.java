package com.leetcode;

public class MaximumSubarray_53 {

	public static void main(String[] args) {
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(maxSubArray(a));
	}
	
	public static int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	int totalSum=0;
			for (int j = i; j < nums.length; j++) {
				totalSum += nums[j];
				result = Math.max(totalSum, result);
			}
		}
        return result;
    }
}

package com.leetcode.array;

import java.util.Arrays;

public class RotateArray_189 {
	public static void rotate1(int[] nums, int K) {
		
		int len = nums.length;
        int[] b = new int[nums.length];
        
        int i = len-K;
        int j =0;
        for (; i<len; i++) {
            b[j] = nums[i];
            j++;
        }
        for(int l=0; l<len-K; l++ ){
            b[j] = nums[l];
            j++;
        }
        for (int j2 = 0; j2 < b.length; j2++) {
			nums[j2] = b[j2]; 
		}
	}
	
	public static void rotate(int[] nums, int k) {
	    int[] a = new int[nums.length];
	    for (int i = 0; i < nums.length; i++) {
	    	System.out.println(i + k + " " + (i + k) % nums.length);
	      a[(i + k) % nums.length] = nums[i];
	    }
	    for (int i = 0; i < nums.length; i++) {
	      nums[i] = a[i];
	    }
	  }
	
	public static void main(String[] args) {
		//int[] nums = {1,2}; int k = 3;
		int[] nums = {1,2,3,4,5,6,7}; int k = 3;
		rotate(nums, k);
		
		System.out.println();
//		Arrays.stream(nums).forEach(System.out::print);
		System.out.println(k %= nums.length);
	}
}
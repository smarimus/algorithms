package com.leetcode.twopointer;

import java.util.Arrays;

public class Trapping_Rain_Water_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
		System.out.println(maxWater(height, height.length));
		System.out.println(maxWater(height));
	}

	public static int trap(int[] height) {

		int result = 0;
		for (int i = 1; i < height.length - 1; i++) {
			int leftMax, rightMax;
			leftMax = rightMax = height[i];
			
			int left = 0;
			while (left < i) {
				leftMax = Math.max(height[left], leftMax);
				++left;
			}
			
			int right = i + 1;
			while (right < height.length) {
				rightMax = Math.max(height[right], rightMax);
				++right;
			}

			int maxHight = Math.min(leftMax, rightMax);
			int val = maxHight - height[i];
			if (val > 0)
				result = result + val;

		}
		return result;
	}

	public static int maxWater(int[] arr, int n) {

		int res = 0;
		for (int i = 1; i < n - 1; i++) {

			// Find maximum element on its left
			int left = arr[i];
			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}

			// Find maximum element on its right
			int right = arr[i];
			for (int j = i + 1; j < n; j++) {
				right = Math.max(right, arr[j]);
			}

			// Update maximum water value
			res += Math.min(left, right) - arr[i];
		}
		return res;
	}
	
	public static int maxWater(int height[]){
		
		int result=0;
		int[] leftMax = new int[height.length], rightMax = new int[height.length];
		
		leftMax[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i-1]);
		}
		
		rightMax[height.length-1] = height[height.length-1];
		for (int i = height.length-2; i > 0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i+1]);
		}
		
		Arrays.stream(leftMax).forEach(System.out::print);
		System.out.println("");
		Arrays.stream(rightMax).forEach(System.out::print);
		System.out.println("");
		
		for (int i = 1; i < rightMax.length-1; i++) {
			result +=  Math.min(rightMax[i], leftMax[i])-height[i] ;
		}
		
		return result;
	}
	
}
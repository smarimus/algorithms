package com.leetcode.twopointer;

public class ContainerWithMostWater_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		//Result rs = maxArea(height);
		//System.out.println(rs.left + " " + rs.right + " " + rs.result);
		System.out.println(maxArea(height));

	}

	public static int maxArea(int[] height) {
		Result result = new Result();

		for (int left = 0; left < height.length; left++) {
			for (int right = height.length - 1; right > left; right--) {
				int value = ((right - left)) * (Math.min(height[right], height[left]));

				if (result.result < value) {
					result = new Result(left, right, value);
				}
			}
		}
		return result.result;
	}

	public static class Result {
		int left;
		int right;
		int result;

		Result() {}
		Result(int left, int right, int result) {
			this.left = left;
			this.right = right;
			this.result = result;
		}
	}
}

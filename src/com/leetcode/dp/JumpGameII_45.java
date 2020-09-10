package com.leetcode.dp;

public class JumpGameII_45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3};
		System.out.println(jump(arr));
	}

	public static int jump(int[] nums) {
		return minJumps(nums, 0, 0);
	}

	public static int minJumps(int[] arr, int index, int count) {
		if (index == arr.length - 1) {
			System.out.println("len: " + arr.length);
			return count;
		}
		int result = Integer.MAX_VALUE;
		for (int i = arr[index]; i > 0; i--) {
			result = Integer.MAX_VALUE;
			if (i + index <= arr.length - 1) {
				result = minJumps(arr, i + index, ++count);
			}
			result = Math.min(result, count);
		}
		return result;
	}
}

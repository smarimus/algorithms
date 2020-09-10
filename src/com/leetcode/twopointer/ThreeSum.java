package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] nums = {-1, 0, 1, 2, -1, -4};
		// int[] nums = {0,0,0,0};
		//int[] nums = {-2, 0, 1, 1, 2};
		
		int[] nums = {-1,0,1,2,-1,-4};

		List<List<Integer>> ls = threeSum(nums);

		for (List<Integer> l : ls) {
			System.out.println("");
			for (Integer k : l) {
				System.out.print(k + ",");
			}
		}

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		if (nums == null)
			return result;
		if (nums.length < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
			if (i == 0 || nums[i - 1] != nums[i]) {
				sum2(nums, i, result);
			}
		}

		return result;
	}

	private static void sum2(int[] nums, int i, List<List<Integer>> result) {
		int lo = i+1, high = nums.length - 1;
		while (lo < high) {

			int sum = nums[i] + nums[lo] + nums[high];
			if (sum < 0) {
				lo++;
			} else if (sum > 0) {
				high--;
			} else {
				result.add(Arrays.asList(nums[i], nums[lo++] , nums[high--]));
				
				while (lo < high && nums[lo] == nums[lo - 1]) {
					lo = lo + 1;
				}
			}
		}
	}
	void twoSumII(int[] nums, int i, List<List<Integer>> res) {
		int lo = i + 1, hi = nums.length - 1;
		while (lo < hi) {
			int sum = nums[i] + nums[lo] + nums[hi];
			if (sum < 0) {
				++lo;
			} else if (sum > 0) {
				--hi;
			} else {
				res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
				while (lo < hi && nums[lo] == nums[lo - 1])
					++lo;
			}
		}
	}

	public List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
			if (i == 0 || nums[i - 1] != nums[i]) {
				twoSumII(nums, i, res);
			}
		return res;
	}


}

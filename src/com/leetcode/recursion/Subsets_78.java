package com.leetcode.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Subsets_78 {

	public static void main(String[] args) {

		
		int[] nums1 = { 1, 2, 3, 4 };
		List<List<Integer>> ls = subsets(nums1); 
		ls.forEach(e -> {
			System.out.println(e.toString());
		});
		

		System.out.println(" br ");

		int[] S = { 1, 2, 1, 1 };
		// sort the set
		Arrays.sort(S);
		List<List<Integer>> res = subsetsWithDuplicate(S);
		
		res.stream().forEach(list -> {
			//System.out.println(list.toString());
		});
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		
		int[] resInd = new int[nums.length];
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		subsets(nums, 0, 0, resInd, res);
		return res;
	}
	
	public static void subsets(int[] nums, int index, int resInd, int[] res, List<List<Integer>> list) {
		
		if(index == nums.length) {
			addToList(nums, index, res, resInd, list);
			return;
		}
		
		res[resInd] = nums[index];
		subsets(nums, index+1, resInd+1, res, list);
		subsets(nums, index+1, resInd, res, list);
		
	}

	public static void findPowerSet(int[] S, Deque<Integer> out, int i) {
		// if all elements are processed, print the current subset
		if (i == S.length) {
			System.out.println(out);
			return;
		}

		// include current element in the current subset and recur
		out.addLast(S[i]);
		findPowerSet(S, out, i + 1);

		// backtrack: exclude current element in the current subset
		out.pollLast();

		// remove adjacent duplicate elements
		while (i+1 < S.length && S[i] == S[i + 1]) {
			i++;
		}

		// exclude current element in the current subset and recur
		findPowerSet(S, out, i + 1);
	}
	
	
	

	public static List<List<Integer>> subsetsWithDuplicate(int[] nums) {

		int[] output = new int[nums.length];
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		buildSubSetsWithDuplicate(nums, 0, output, 0, list);
		return list;
	}

	public static void buildSubSetsWithDuplicate(int[] nums, int i, int[] output, int k, List<List<Integer>> list) {
		if (i == nums.length) {
			addToList(nums, i, output, k, list);
			return;
		}
		output[k] = nums[i];
		buildSubSetsWithDuplicate(nums, i + 1, output, k + 1, list);

		// remove adjacent duplicate elements
		while (i+1 < nums.length && nums[i] == nums[i + 1]) {
			i++;
		}

		buildSubSetsWithDuplicate(nums, i + 1, output, k, list);
	}

	public static void addToList(int[] nums, int i, int[] output, int k, List<List<Integer>> list) {
		List<Integer> subList = new ArrayList<Integer>();

		for (int l = 0; l < k; l++) {
			subList.add(output[l]);
		}
		list.add(subList);
	}

}
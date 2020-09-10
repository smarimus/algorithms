package com.leetcode.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Subsets_78 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 1, 1 };

		Arrays.sort(nums);

		List<List<Integer>> ls = subsets(nums);
		ls.forEach(e -> {
			System.out.println(",");
			e.forEach(System.out::print);
		});

		System.out.println(" br ");

		int[] S = { 1, 2, 1, 1 };

		// sort the set
		Arrays.sort(S);

		// create an empty list to store elements of a subset
		Deque<Integer> out = new ArrayDeque<>();
		findPowerSet(S, out, 0);

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

	public static List<List<Integer>> subsets(int[] nums) {

		int[] output = new int[nums.length];
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		buildSubSets(nums, 0, output, 0, list);
		return list;
	}

	public static void buildSubSets(int[] nums, int i, int[] output, int k, List<List<Integer>> list) {
		if (i == nums.length) {
			addToList(nums, i, output, k, list);
			return;
		}
		output[k] = nums[i];
		buildSubSets(nums, i + 1, output, k + 1, list);

		// remove adjacent duplicate elements
		while (i+1 < nums.length && nums[i] == nums[i + 1]) {
			i++;
		}

		buildSubSets(nums, i + 1, output, k, list);
	}

	public static void addToList(int[] nums, int i, int[] output, int k, List<List<Integer>> list) {
		List<Integer> subList = new ArrayList<Integer>();

		for (int l = 0; l < k; l++) {
			subList.add(output[l]);
		}
		list.add(subList);
	}

}
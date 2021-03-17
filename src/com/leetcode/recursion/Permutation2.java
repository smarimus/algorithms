package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.leetcode.Utils;

public class Permutation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,3};
		Utils.iterateUsingForEach(permuteUnique(arr));

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {

		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			numList.add(nums[i]);
		}
		List<List<Integer>> finalRes = new ArrayList<>();
		permute(numList, finalRes, 0);
		return finalRes;
	}

	public static void permute(List<Integer> numList, List<List<Integer>> res, int index) {

		if (index == numList.size()) {
			res.add(new ArrayList<Integer>(numList));;
			return;
		}

		Set<Integer> set = new TreeSet<Integer>();
		for (int i = index; i < numList.size(); i++) {
			if (set.contains(numList.get(i))) {
				continue;
			}
			set.add(numList.get(i));
			Collections.swap(numList, index, i);
			permute(numList, res, index + 1);
			Collections.swap(numList, index, i);
		}
	}

}

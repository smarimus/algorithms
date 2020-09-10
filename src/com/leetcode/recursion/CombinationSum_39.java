package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] candidates = {2,3,7}; 
		//int target =7;
		
		
		int[] candidates = {1};
		int target =1;
		combinationSum(candidates, target);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list =  new ArrayList<>();
		combinationSum(result, list, candidates, target, 0);
		
		for(List<Integer> ls : result){
			for(Integer in: ls){
				System.out.print(in);
			}
			System.out.println("");
		}
		return result;
	}

	public static void combinationSum(List<List<Integer>> result, List<Integer> list, 
			int[] candidates, int target, int ind) {

		if (target == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		if (target < 0) return;
		
		for (int i = ind; i < candidates.length; i++) {
			int newTarget = target - candidates[i];
			if(newTarget < 0) continue;
			
			list.add(candidates[i]);
			combinationSum(result, list, candidates, newTarget, i);
			list.remove(list.size()-1);
		}
	}
	
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}

}

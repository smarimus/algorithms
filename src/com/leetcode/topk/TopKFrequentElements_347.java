package com.leetcode.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TopKFrequentElements_347 {

	public static void main(String[] args) {
		int[] nums ={4, 5, 3, 7, 2};
		
		topKFrequent(nums, 0);
	}
	
	public static int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int n: nums){
			map.put(n, map.getOrDefault(n, 0));
		}
		Set<Integer> set = map.keySet();
		
		int pivot = partition(0, nums.length-1, nums);
		
		return null;
    }
	
	public static int partition(int left, int right, int[] arr){
		
		int pivot = left;
		left = left+1;
		
		while(left <= right){
			if(arr[left] < arr[pivot]){
				left++;
				continue;
			}
			if(arr[right] > arr[pivot]){
				right--;
				continue;
			}
			swap(left++, right--, arr);
		}
		
		if(arr[pivot] > arr[right]){
			swap(right,pivot, arr);
		}
		return pivot;
	}
	
	static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
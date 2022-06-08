package com.leetcode.topk;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class KthLargestElementArray_215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Integer.MIN_VALUE);

	}
	
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		Arrays.sort(nums);
		
		Arrays.stream(nums).forEach(e ->{
			maxHeap.add(e);
		});
		int result =Integer.MIN_VALUE;
		int previousVal=Integer.MIN_VALUE;
		int count=0;
		while(maxHeap.peek() != null){
			int currentValue = maxHeap.poll();
			if(currentValue != previousVal){
				count++;
			}
			if(count == k){
				result = currentValue;
				break;
			}
		}
		return result;
    }

}

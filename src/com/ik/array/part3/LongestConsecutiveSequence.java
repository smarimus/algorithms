package com.ik.array.part3;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
	 */
	
	public static int findLCSLength(int[] num){
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}
	 
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
	 
		for (int e : num)
			set.add(e);
	 
		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;
	 
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
	 
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
	 
			max = Math.max(count, max);
		}
		return max;
	}
}

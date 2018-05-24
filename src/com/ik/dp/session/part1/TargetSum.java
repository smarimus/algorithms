package com.ik.dp.session.part1;

import java.util.HashMap;

public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,2,1};
		int target = 4;
		
		/*
		 int[] a = {1,1,1,1,1};
		int target = 3;
		*/
		
		//System.out.println(targetSum(a, target));
		//System.out.println(1-2);
		System.out.println(targetSumDP(a, target));
	}
	
	public static int targetSum(int[] a, int target){
		HashMap<Integer, HashMap<Integer, Integer>> hash = new HashMap<Integer, HashMap<Integer, Integer>>();
		return targetSum(a, target, 0, 0, hash);
	}
	
	public static int targetSum(int[] a, int target, int i, int sum, HashMap<Integer, HashMap<Integer, Integer>> cache){
		
		if(i == a.length)
			return target == sum ? 1 : 0;
		
		HashMap<Integer, Integer> innerCache;
		if(cache.get(i) != null){
			
			innerCache = cache.get(i);
			if(innerCache.get(sum) != null){
				return innerCache.get(sum);
			}
			
		}
		
		int first = targetSum(a, target, i+1, sum + a[i], cache);
		int second = targetSum(a, target, i+1, sum - a[i], cache);
		int result = first + second;
		
		innerCache = new HashMap<Integer, Integer>();
		//System.out.println("i: " + i + " sum: " + sum + " ============= " + "(+): " + first + " (-): " + second + " *** " + (result));
		innerCache.put(sum, result);
		
		return result;
	}
	
	public static int targetSumDP(int[] nums, int T) {
		  int sum = 0;
		// Our cache has to range from -sum(nums) to // sum(nums), so we offset everything by sum
		  for (int num : nums) sum += num;
		  int[][] cache =
		new int[nums.length + 1][2*sum + 1]; if (sum == 0) return 0;
		// Initialize i=0, T=0
		cache[0][sum] = 1;
		// Iterate over previous row and update the // current row
		for (int i = 1; i <= nums.length; i++) {
		    for (int j = 0; j < 2 * sum + 1; j++) {
		      int prev = cache[i-1][j];
		      if (prev != 0) {
		        cache[i][j - nums[i-1]] += prev;
		        cache[i][j + nums[i-1]] += prev;
		      }
		    }
		}
		return cache[nums.length][sum + T];
	}
}

/*
=======================================================

	 0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 10, 11, 12
	 
0   [0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,  0,  0] 
1	[0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0,  0,  0] 
2	[0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0,  0,  0]
2	[0, 1, 0, 1, 0, 2, 0, 2, 0, 1, 0,  1,  0]
1	[1, 0, 2, 0, 3, 0, 4, 0, 3, 0, 2,  0,  1]
	
=======================================================
 
 */

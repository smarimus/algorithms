package com.ik.dp.session.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinPathTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[][] = {
				{2},
				{3, 7},
				{8, 5, 6},
				{6, 1, 9, 3}
				};
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(2);
		list.add(row1);
		
		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(3); row2.add(7);
		list.add(row2);
		
		List<Integer> row3 = new ArrayList<Integer>();
		row3.add(8); row3.add(5); row3.add(6);
		list.add(row3);
		
		List<Integer> row4 = new ArrayList<Integer>();
		row4.add(6); row4.add(1); row4.add(9); row4.add(3);
		list.add(row4);
		
		System.out.println(minimumTotal(arr, 0, 0));
		
		System.out.println(minimumTotal(list));
	}
	
	public static int minimumTotal(int[][] arr, int m, int n ){
		if (m == arr.length-1)
			return arr[m][n];
		
		int previousMin = Math.min( minimumTotal(arr, m+1, n) , minimumTotal(arr, m+1, n+1) );
		int result = arr[m][n] + previousMin;
		
		return result;
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		Map<String, Integer> cache = new HashMap<String, Integer>();
        return minimumTotal(triangle, cache, 0, 0);
    }
	
	public static int minimumTotal(List<List<Integer>> list, Map<String, Integer> cache, int m, int n ){
		if( list.size() == 0) return 0;
		
		if (m == list.size()-1)
			return list.get(m).get(n);
		
		String key = m + "-" + n;
		
		if(cache.containsKey(key)){
			return cache.get(key);
		}
		
		int previousMin = Math.min( minimumTotal(list, cache, m+1, n) , minimumTotal(list, cache, m+1, n+1) );
		int result = list.get(m).get(n) + previousMin;
		
		if(!cache.containsKey(key)){
			cache.put(key, result);
		}
		
		return cache.get(key);
	}
	
	public static int minimumTotalDP(List<List<Integer>> triangle) {
		return 0;
	}
	
}

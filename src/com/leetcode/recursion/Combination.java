package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a[] = {"1","2","3"};
		String b[] = {"4","5", "11"};
		String c[] = {"6","7","8"};
		String d[] = {"9", "10", "11", "12"};
		
		String[][] inputArrays = {a,b,c,d};
		List<List<String>> results = new ArrayList<List<String>>();
		
		List<String> result = new ArrayList<String>();
		combinations(results, result, inputArrays, 0);
		
		print(results);
	}
	
	private static void combinations(List<List<String>> results, List<String> result, String[][] inputArrays,
			 int i){
		
		if(i == inputArrays.length){
			List<String> dest = new ArrayList<String>(result);
			results.add(dest);
			return;
		}
		
		String[] arr = inputArrays[i];
		for (int j = 0; j < arr.length; j++) {
			result.add(i, arr[j]);
			combinations(results, result, inputArrays, i+1);
			result.remove(i);
		}
	}
	
	static void print(List<List<String>> results){
		System.out.println(results.size());
		for(List<String> result : results){
			for (String string : result) {
				System.out.print(string + ",");
			}
			System.out.println();
		}
	}
}
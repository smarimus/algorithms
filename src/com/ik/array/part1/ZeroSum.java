package com.ik.array.part1;

import java.util.ArrayList;
import java.util.List;

public class ZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {5,1,2,-3,7,-4};
		//int[] a ={ 3, 4, 2, 1 };
		//int[] a ={ 7,7,7,7};
		
		List<List<Integer>> subsets = zeroSum(a, 0);
		
		for (int i = 0; i < subsets.size(); i++) {
			List<Integer> subset = subsets.get(i);
			System.out.println(subset);
		}
	}
	
	static List<List<Integer>> zeroSum(int[] a, int k){
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < a.length; i++) {
			int first = a[i];
			List<Integer> subset = new ArrayList<Integer>();
			
			subset.add(a[i]);
			
			if(first == k){
				list.add(subset); continue;
			}
			
			for (int j = i+1; j < a.length; j++) {
				first += a[j];
				subset.add(a[j]);
				
				if(first == k){
					list.add(subset); break;
				}
			}
		}
		return list;
	}
}
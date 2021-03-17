package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		helper(result, list, 4, 2, 1);
		
		for(List<Integer> ls : result){
			for(Integer in: ls){
				System.out.print(in);
			}
			System.out.println("");
		}
	}

	public static void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int m) {
		
		if (list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = m; i <= n; i++) {
			list.add(i);
			helper(result, list, n, k, i + 1);
			list.remove(list.size()-1);
		}
	}
	
	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if(k==0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i=start;i<=n;i++) {
			comb.add(i);
			combine(combs, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
}

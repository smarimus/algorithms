package com.ik.recursion.session;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permute();
	}
	
   public static List<List<Integer>> permute(int[] nums) {
	   return null;
    }
   
   public static void permute(){
	   List<List<Integer>> list = new ArrayList<List<Integer>>();
	   List<Integer> tempList = new ArrayList<Integer>();
	   int[] nums = {1,2,3,4};
	   //backtrack(list, tempList, nums);
	   permutation(nums, 0);
	   System.out.println(list);
   }
   
   private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
	   if(tempList.size() == nums.length){
	      list.add(new ArrayList<>(tempList));
	   } else{
	      for(int i = 0; i < nums.length; i++){
	         if(tempList.contains(nums[i])) continue; // element already exists, skip
	         tempList.add(nums[i]);
	         backtrack(list, tempList, nums);
	         tempList.remove(tempList.size() - 1);
	      }
	   }
	}
   
   private static void permutation(int [] a, int i){
	   int n = a.length;
	   
	   if(i == n-1){
		   for (int z = 0; z < a.length; z++) {
			System.out.print(a[z] + "");
		   }
		   System.out.println("");
	   }
	   
	   for (int j = i; j < a.length; j++) {
		   swap(a, i, j);
		   permutation(a, i+1);
		   swap(a, i, j);
	   }
	}
   
   private static void swap(int[] a, int i, int j){
	   int temp = a[i];
	   a[i] = a[j];
	   a[j] = temp;
   }
   
}
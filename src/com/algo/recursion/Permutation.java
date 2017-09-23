package com.algo.recursion;

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
	   backtrack(list, tempList, nums);
	   
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

}
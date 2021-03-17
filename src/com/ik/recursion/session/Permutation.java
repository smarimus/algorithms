package com.ik.recursion.session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permute();
		List<List<Integer>> list = new ArrayList<>();
		
		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(2);
		list.add(ls);
		
		List<Integer> ls1 = new ArrayList<>();
		ls1.add(3);
		ls1.add(4);
		
		int[] a = new int[]{2, 3, 5, 7, 11, 13, 17};
		
		
		list.add(ls1);
		List<Integer> source = Arrays.asList();

		list.add(IntStream.of(a).boxed().collect(Collectors.toCollection(ArrayList::new)));
		
		System.out.println(list);
		
		new ArrayList<>(ls1);
		
	}
	
   public static List<List<Integer>> permute(int[] nums) {
	   return null;
    }
   
   public static void permute(){
	   List<List<Integer>> list = new ArrayList<List<Integer>>();
	   List<Integer> tempList = new ArrayList<Integer>();
	   int[] nums = {1,1,3};
	   backtrack(list, tempList, nums);
	   //permutation(nums, 0);
	   //System.out.println(list);
	   System.out.println("");
	   char[] chars = {'1', '1', '2'};
	   //permutation(chars, 0);
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
   
   private static void permutation(char [] a, int i){
	   int n = a.length;
	   
	   if(i == n-1){
		   for (int z = 0; z < a.length; z++) {
			System.out.print(a[z] + "");
		   }
		   System.out.println("");
		   return;
	   }
	   
	  //System.out.println(i+1);
	   
	   for (int j = i; j < a.length; j++) {
		   swap(a, i, j);
		   //System.out.print(" i: " + i + " " + "j: " + j + " ");
		   permutation(a, i+1);
		   swap(a, i, j);
	   }
	}
   
   private static void swap(char[] a, int i, int j){
	   char temp = a[i];
	   a[i] = a[j];
	   a[j] = temp;
   }
   
   private static void swap(int[] a, int i, int j){
	   int temp = a[i];
	   a[i] = a[j];
	   a[j] = temp;
   }
   
}
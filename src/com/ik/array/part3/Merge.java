package com.ik.array.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
	public static void main(String[] args) {
		
		int arr1[] = {1,2,3,5,6,7};
		int arr2[] = {3,6,7,8,20};
		//System.out.println(Arrays.toString(findDuplicates(arr1, arr2)));
		//System.out.println(bSearch(arr1, 3));
		
		//System.out.println(Arrays.toString(findDuplicates1(arr1, arr2)));
		
		
		int arr4[] = {1,3,5,7};
		int arr3[] = {2,4,6,8,9,12};
		//System.out.println(Arrays.toString(merge(arr3, arr4)));
		
		//int nums[] = {0,0,1,1,1,2,2,3,3,4};
		//int nums[] = {1,2,3,4,4,4,4,5,6};
		int nums[] = {0,1,1,2,3,4,5};
		System.out.println(removeDuplicates2(nums));
		System.out.println(Arrays.toString(nums));
	}
	
	static int bSearch(int arr[], int item){
		int result=-1;
		if(arr == null || arr.length == 0) return -1;
		
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end ){
			
			int mid = (start+end)/2;
			
			if(arr[mid] == item){
				result = mid;break;
			}else if(arr[mid] < item ){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		return result;
	}

	// 3, 4, 5
	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15

	static int[] findDuplicates(int[] arr1, int[] arr2) {
		int arr1Len = arr1.length;
		int arr2Len = arr2.length;
		
		if(arr1Len > arr2Len ){
			arr1Len = 1+bSearch(arr1, arr2[arr2Len-1]);
		}else if(arr1Len < arr2Len){
			arr2Len = 1+bSearch(arr2, arr1[arr1Len-1]);
		}
		
		// your code goes here
		List<Integer> results = new ArrayList<Integer>();
		int i=0;
		int j=0;
		while(i < arr1Len && j < arr2Len ){
			if(arr1[i] == arr2[j]){
				results.add(arr1[i]);
				i++; j++;
			}else if(arr1[i] < arr2[j]){
				i++;
			}else{
				j++;
			}
		}
		int [] res = results.stream().mapToInt(Integer::valueOf).toArray();
	    return res;
	}
	
	static int[] findDuplicates1(int[] arr1, int[] arr2) {
	    // your code goes here
	    List<Integer> results = new ArrayList<Integer>();
	    int i=0;
	    int j=0;
	   while(i < arr1.length && j < arr2.length ){
	     if(arr1[i] == arr2[j]){
	       results.add(arr1[i]);
	       i++; j++;
	     }else if(arr1[i] < arr2[j]){
	       i++;
	     }else{
	       j++;
	     }
	   }
	   int [] res = results.stream().mapToInt(Integer::valueOf).toArray();
	   return res;
	  }
	
	static int[] merge(int[] arr1, int[] arr2) {
		
		int i=0;
		int j=0; int k=0;
		int[] merged = new int[arr1.length + arr2.length];
		List<Integer> res = new ArrayList<Integer>();
		while(i < arr1.length && j < arr2.length){
			
			if(arr1[i] < arr2[j]){
				merged[k] = arr1[i];
				res.add(arr1[i]);
				i++;
			}else{
				merged[k] = arr2[j];
				res.add(arr2[j]);
				j++;
			}
			k++;
		}
		
		while(i<arr1.length){
			merged[k] = arr1[i];
			res.add(arr1[i]);
			k++; i++;
		}
		
		while(j<arr2.length){
			merged[k] = arr2[j];
			res.add(arr2[j]);
			k++; j++;
		}
		
		int [] rest = res.stream().mapToInt(Integer::valueOf).toArray();
				
		return rest;
	}
	
	//0,0,1,1,1,2,2,3,3,4
	public static int[] removeDuplicates(int[] nums) {
		
		int newIndex = -1;
		boolean dupFound = false;
		for (int curr = 0; curr < nums.length - 1; curr++ ) {
			
			int innerPointer = curr;
			while (nums[innerPointer] == nums[innerPointer + 1]) {
				dupFound = true;
				innerPointer++;
			}
			
			if(dupFound){
				if(newIndex == -1){
					newIndex = curr+1;
				}
				nums[newIndex] = nums[innerPointer + 1];
				curr = innerPointer;
				newIndex++;
			}
		}
		System.out.println(newIndex);
		return nums;
	}
	
	public int removeDuplicates1(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
	
	public static int removeDuplicates2(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}
}

/*

[1,1,1,2,2,3]
[1,1,2,2,3]

0,0,0,0,0,1,1,2,2,3,3,4

1,1,1,2,2,3
	set found
	then next duplicate to be replaced with not equals char

1,2,3,4,5
	no duplicate, then replace by itself.
	
	

1,1,1,1,2,2,3
	
Things got right
	know that it's 2 pointer problem.
	How the pointer was moved was the problem

algorithm mistakes made 
	How the pointer was moved was the problem
	instead of keeping the pointer at the left, I started thinking about sliding window.
	this is more of invariant ??
	??
	
Running through an example and algorithm finding go hand in hand. 
		always take a simple example, solve for happy path
		
	Look at sliding window
	look at sorting - invariant, color sorting


Where you got struck?
What are the difficulties?

What did you learn?
What can be improved?

Multiple scenario's 
	too hard to process everything in mind.
	
	take one approach that are close enough and improve from there.
	
issue with the coding ??
*/
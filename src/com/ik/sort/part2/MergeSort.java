package com.ik.sort.part2;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[] = {2,1,4,3, 5};
		int arr[] = {5,2,3,1};
		//int arr[] = {5,1,1,2,0,0};
		//int arr[] = {5};
		
		//sortArray(arr);
		
		mergeSort(arr, 0, arr.length-1);
		
		Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
	}
	
	public static int[] sortArray(int[] nums) {
        
        if(nums == null)
            return null;
        
        if(nums.length == 1)
            return nums;
        
        mergeSort(nums, 0, nums.length);
        return nums;
    }
    
    public static void mergeSort(int arr[], int start, int end){
		if(start < end){
			int mid = start + (end - start) / 2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			
			merge(arr, start, mid, end);
		}
	}
	
	public static void merge(int[] arr, int start, int mid, int end){
		
		int cLen = (end - start) + 1;
		int[] newArr = new int[cLen];
		
		int i=start;
		int j=mid+1;
		int k=0;
		while(i <= mid && j <= end){
			if(arr[i] <= arr[j]){
				newArr[k] = arr[i];
				k++;i++;
			}else{
				newArr[k] = arr[j];
				k++;j++;
			}
		}
		for(; i<= mid; i++){
			newArr[k] = arr[i];
			k++;
		}
		for(; j<= end; j++){
			newArr[k] = arr[j];
			k++;
		}
		
		int m=0;
		for(int l=start; l<=end; l++){
			arr[l] = newArr[m];
			m++;
		}
	}
	

}

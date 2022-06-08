package com.interview.proun;

import java.util.Arrays;

public class Segregate0and1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1, 0, 1, 0, 1};
		int[] arr = {1, 1, 0, 1, 0, 0, 1, 1, 1, 1};
		
		seg0and1(arr);
		System.out.println(Arrays.toString(arr));
		

	}
	
	public static void seg0and1(int[] arr){
		
		int left =0;
		int right=arr.length-1;

		while(left < right){
			
			if(arr[left] == 0){
				left++;
				continue;
			}
			if(arr[right] == 1){
				right--;
				continue;
			}
			swap(arr, left, right);
			left++;
			right--;
		}
	}
	

	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}

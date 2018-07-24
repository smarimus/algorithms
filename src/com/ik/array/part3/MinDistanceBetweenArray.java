package com.ik.array.part3;

public class MinDistanceBetweenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		int arr1[] = {1, 2}; //x = 1, y = 2
		int arr2[] = {3, 4, 5}; // x = 3, y = 5

		System.out.println(findMinDifference(arr, 3, 6));
		System.out.println(findMinDifference(arr1, 1, 2));
		System.out.println(findMinDifference(arr2, 3, 5));
		
	}
	
	static int findMinDifference(int arr[], int x, int y){
		
		int pre = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if(val == x || val == y){
				pre = i;break;
			}
		}
		
		for (int i = pre+1; i < arr.length; i++) {
			
			if(arr[i] == x || arr[i] == y){
				if(arr[i] != arr[pre] && i - pre < min){
					min = i- pre;
					pre = i;
				}else{
					pre = i;
				}
			}
		}
		return min;
	}
	
}
package com.algo.sort;

public class KthLargeElement {
	
	static int partition(int[] arr, int low, int end){
		
		int pivot = low;
		low++;
		
		while(low <= end){
			// if pivot is greater than i increment
			if(arr[pivot] > arr[low]){
				low++;
				continue;
			}
			if(arr[pivot] <= arr[end]){
				end--;
				continue;
			}
			swap(arr, low, end);
		}
		
		if(arr[pivot] > arr[end] ){
			swap(arr, pivot, end);
		}
		return end;
	}
	
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void sort(int arr[], int start, int end){
		if(start < end){
			int range = partition(arr, start, end);
			
			sort(arr, start, range-1);
			sort(arr, range+1, end);
		}
	}
	
	static int[] findTopK(int[] iStream, int iK) {
		sort(iStream, 0, iStream.length-1);
		
		int[] result = new int[iK];
		
		
		int len = iStream.length-1;
		int j = len-iK;
		int k=0;
		for (; len > j  ; len--) {
			result[k] = iStream[len];
			k++;
		}
		return result;
	}
	
	//static int findK(int arr[], int start, int end, int k){
	static int[] topK(int[] iStream, int iK) {
		int[] result = new int[iK];
		
		int start = 0; 
		int end = iStream.length-1;
		
		while(start < end){
			int range = partition(iStream, start, end);
			
			partition(iStream, start, range-1);
			partition(iStream, range+1, end);
		}
		
		return result;
	}
	
	
	//3 - sort only left
	//2 - sort lef and right
	//5 - sort left only

	
	/* A utility function to print array of size n */
	 static void printArray(int arr[])
	 {
	     int n = arr.length;
	     for (int i=0; i<n; ++i)
	         System.out.print(arr[i]+" ");
	     System.out.println();
	 }
	
	 // Driver program
	 public static void main(String args[]){
		 int k = 2;
		 
	     //int arr[] = {10, 7, 8, 9, 1, 5};
	     int arr[] = {7, 2, 3, 4, 6, 8, 8, 9};
	     int n = arr.length;
	     printArray(arr);
	     
	     KthLargeElement ob = new KthLargeElement();
	     ob.sort(arr, 0, n-1);
	     
	     
	     printArray(arr);
	     
	     //printArray(topK(arr, k));
	     printArray(findTopK(arr, k));
	 }
	 
}


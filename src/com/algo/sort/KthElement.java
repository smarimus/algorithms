package com.algo.sort;

public class KthElement {
	
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
	
	static int findK(int arr[], int start, int end, int k){
		int result =-1;
		int range = partition(arr, start, end);
		
		while(start < end){
			
			if(k == range){
				 return arr[range];
			}
			
			if(k < range){
				return findK(arr, start, range-1, k);
			}else if(k > range){
				return findK(arr, range+1, end, k);
			}
		}
		return result;
		
	}

	
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
	     
	     KthElement ob = new KthElement();
	     ob.sort(arr, 0, n-1);
	     System.out.println("sorted array");
	     printArray(arr);
	     
	     System.out.println(findK(arr, 0, n-1, 0));
	 }
	 
}


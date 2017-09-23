package com.algo.sort;

public class NutsNBolts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {5,1,3,2,4};
		int b[] = {4,2,5,3,1};
		
		int low=0;
		int high=a.length-1;
		
		sort(a, b, low, high );
		//sort1(a, low, high );
		printArray(a);
		System.out.println();
		printArray(b);
	}
	
	static int partition(int[] a, int low, int high){
		int pivot = low;
		low++;
		while( low <= high ){
			if(a[low] < a[pivot]){
				low++;
				continue;
			}
			if(a[high] >= a[pivot]){
				high--;
				continue;
			}
			swap(a, low, high);
		}
		if(a[pivot] > a[high]){
			swap(a, pivot, high);
		}
		return high;
	}
	
	static void sort(int[] a, int[] b, int low, int high){
		if(low< high){

			int range = partition(a, low, high);
			
			partition(b, low, high);
			
			// Use recursion to sort left and right of the Range
			sort(a, b, low, range-1);
			sort(a, b, range+1, high);
		}
	}

	static void swap(int[] a, int i, int j){
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	static void printArray(int arr[]){
	     int n = arr.length;
	     for (int i=0; i<n; ++i)
	         System.out.print(arr[i]+" ");
	     System.out.println();
	 }
	
}
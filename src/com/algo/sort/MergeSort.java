package com.algo.sort;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {7, 2, 3, 4, 6, 8, 8, 9};
		
		int a[] = {3,4,5};
		int b[] = {1,2,6,7};
		
		/*int a[] = {1,2};
		int b[] = {3};*/
		
		printArray(merge(a, b));
		
		System.out.println(1/2);
	}
	
	static int[] mergeSort(int[] arr, int start, int end){
		
		/*if(arr.length <= 0){
			return new int[0];
		}*/
		
		if(arr.length == 1){
			return arr;
		}
		
		int mid = arr.length/2;
		
		// sort left
		int[] sortedLeft = mergeSort(arr, start, mid-1);
				
		// sort right
		int[] sortedRight = mergeSort(arr, mid, end);
		
		//merge
		return merge(sortedRight, sortedLeft);
		
		//return
	}
	
	static int[] merge(int[] a , int[] b){
		
		int l = a.length + b.length;
		int[] merged = new int[l];
		
		int  k =0; int i =0; int j=0;
		while(i< a.length && j < b.length){
			if( a[i] < b[j]){
				merged[k] = a[i];
				i++;
			}else{
				merged[k] = b[j];
				j++;
			}
			k++;
		}
		
		while(i<a.length){
			merged[k] = a[i];
			k++; i++;
		}
		
		while(j<b.length){
			merged[k] = b[j];
			k++; j++;
		}
		
		
		return merged;
	}
	
	static void printArray(int arr[]){
	     int n = arr.length;
	     for (int i=0; i<n; ++i)
	         System.out.print(arr[i]+" ");
	     System.out.println();
	 }
}

/*if(a.length >= b.length){
	int i=0;
}else if(a.length >= b.length){
	
}*/
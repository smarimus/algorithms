package com.algo.sort;

public class MergeSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,4,5};
		int b[] = {1,2,6,7};
		
		int[] a1a = {5, 4, 7 , 2, 6, 1, 3};
		int[] a1 = {5, 4, 7 , 2, 6};
		
		sort(a1, 0, a1.length-1);
		printArray(a1);
		System.out.println(2/2);
		System.out.println(0/2);
		System.out.println(1/2);
		
	}
	
	static void sort(int a[], int start, int end){
		
		if(start < end){
			
			int mid = (start+end)/2;
			
			sort(a, start, mid);
			sort(a, mid+1, end);
			
			merge(a, start, mid, end); 
		}
	}
	
	// Find the length of first and second array
	// Copy first and second array to new array
	// Create a new array
	// Merge first and second array
		
	static int[] merge(int[] a, int start, int mid, int end){
		
		int firstLen =  mid - start + 1 ;
		int secondLen = end - mid;
		
		int[] first = new int[firstLen];
		for (int i = 0; i < firstLen; ++i) {
			first[i] = a[start+i];
		}
		
		int[] second = new int[secondLen];
		for (int i = 0; i < secondLen; ++i) {
			second[i] = a[mid+1+i];
		}
		int i,j,k;
		i=j=0;
		k=start;
		
		int[] merged = new int[firstLen+secondLen];
		while(i< firstLen && j < secondLen){
			
			if(first[i] < second[j]){
				//merged[k] = first[i];
				a[k] = first[i];
				i++;
			}else{
				//merged[k] = second[j];
				a[k] = second[j];
				j++;
			}
			k++;
		}
		
		while(i < firstLen){
			//merged[k] = first[i];
			a[k] = first[i];
			i++; k++;
		}
		
		while(j < secondLen){
			//merged[k] = second[j];
			a[k] = second[j];
			j++; k++;
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

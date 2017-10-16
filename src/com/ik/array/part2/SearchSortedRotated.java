package com.ik.array.part2;

public class SearchSortedRotated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] a = {6, 7, 1, 2, 3, 4, 5};
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		//searchInRotatedArray(a, 0, a.length);
		//System.out.println(search(a, 0, a.length-1, 2));
		
		int[] b = {4, 5, 1, 2, 3};
		System.out.println(findMinimum(b));;
		
		
	}
	
	/*public static int searchInRotatedArray(int[] a, int start, int end){
		
		int mid = (start + end)/2;
		
		if (mid  < prev && mid > next)
			return mid;
			
		if (mid < prev && mid < next)
			return next;
		
		searchInRotatedArray(a, mid)
	}*/
	public static int search(int[] a, int start, int end, int k){
		
		int result = 0;
		
		if(start > end){
			return -1;
		}
		
		int mid = (start + end)/2;
		if(a[mid] == k){
			result = a[mid];
		}else if(a[mid] > k ){
			result = search(a, start, mid-1, k);
		}else{
			result = search(a, mid+1, end, k);
		}
		
		return result;
	}
	
	static int findMinimum(int[] arr) {
		
		return findMin(arr, 0, arr.length-1);
    }
	
	static int findMin(int[] a, int low, int high) {
    	
    	int mid = low+high;
    	
    	if (low < mid && mid < high && a[mid-1] > a[mid] ){
    		return a[mid];
    	}
    	
    	if((mid == low && low < high) && a[mid+1] < a[mid]){
    		return a[mid+1];
    	}
    	
    	if(a[low] > a[mid] && a[mid] < a[high]){
    		return findMin(a, low, mid);
    	}
    	return findMin(a, mid, high);
    }
}
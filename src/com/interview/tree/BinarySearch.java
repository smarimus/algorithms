package com.interview.tree;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,2,3,4,5,6};
		int k=3;
		System.out.println(search(a, 0, a.length-1, k));

	}
	
	static int search(int a[], int left, int right, int k){
		int results = -1;
		
		if(left > right) 
			return -1;
		
		int mid = (left+right)/2;
		
		if(a[mid] == k){
			return mid;
		}
		
		if(a[mid] > k)
			results = search(a, left, a[mid]-1, k);
		if(a[mid] < k)
			results = search(a, a[mid]+1, right, k);
		
		return results;
	}
}
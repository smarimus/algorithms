package com.interview;

public class SearchRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {5,10,15,20,25,30};
		
		//int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
		
		int[] arr1 = {15,20,25,30,5};
		
		//int[] arr1 = {10,15,20,5,10};
		
		//int[] arr2 = {40,5,20,25,25,30};
		//int[] arr3 = {5,10,15,20,25,30};
		
		System.out.println(search(arr1,0,arr1.length-1,20));
	}
	
	public static int search(int a[], int left, int right, int x){
		int mid = (left+right)/2;
		
		if(a[mid] == x)
			return mid;
		
		if(left > right)
			return -1;
		
		if (a[left] < a[mid]) { // Left is normally ordered.
			if (x >= a[left] && x < a[mid]) { 
				return search(a, left, mid - 1, x);
			} else {
				return search(a, mid + 1, right, x);
			}
		} else if (a[mid] < a[left]) { // Right is normally ordered.
			if (x > a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x);
			} else {
				return search(a, left, mid - 1, x);
			}
		}
		return -1;
	}
	
	public static int search1(int a[], int left, int right, int x) {
		int mid = (left + right) / 2;
		if (x == a[mid]) { // Found element
			return mid;
		}
		if (right < left) {
			return -1;
		}
		
		/* While there may be an inflection point due to the rotation, either the left or 
		 * right half must be normally ordered.  We can look at the normally ordered half
		 * to make a determination as to which half we should search. 
		 */
		if (a[left] < a[mid]) { // Left is normally ordered.
			if (x >= a[left] && x < a[mid]) { 
				return search(a, left, mid - 1, x);
			} else {
				return search(a, mid + 1, right, x);
			}
		} else if (a[mid] < a[left]) { // Right is normally ordered.
			if (x > a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x);
			} else {
				return search(a, left, mid - 1, x);
			}				
		}
		return -1;
	}
}


/*
if(a[left] < a[mid]){
	if(k >= a[left] && k < a[mid])
		return search(a, a[left], a[mid]-1, k);
	else
		return search(a, a[mid]+1, a[right], k);
	
}else if (a[mid] < a[left]){
	
	if(k > a[mid] && k <= a[right])
		return search(a, a[mid+1], a[right], k);
	else
		return search(a, a[left], a[mid]-1, k);
}
*/

/*
first partition the list
if k within the range of left
	search in the left
	else
	search in the right

if k within the range of right
	search in the right
	else
	search in the left
*/
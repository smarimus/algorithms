package com.ik.array.session;

public class MinDistanceBetween2Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		int arr1[] = {1, 2};
		int arr2[] = {3, 4, 5};
		int arr3[] = {2, 5, 3, 5, 4, 4, 2, 3};
		
		int arr4[] = {2, 3, 4, 5, 6};
		
		System.out.println(minDistanceBF(arr, 3, 6));
		System.out.println(minDistanceBF(arr1, 1, 2));
		System.out.println(minDistanceBF(arr2, 3, 5));
		System.out.println(minDistanceBF(arr3, 3, 2));
		
		System.out.println(minDistanceBF(arr4, 2, 6));
		
	}
	
	
	static int minDistanceBF(int arr[], int x, int y){
		/*
		 * 
		 * x found
		 * 	distance++;
		 * y found - update the minDistance = distance
		 * 
		 * x found && distance > 0
		 * 		distance++
		 * 
		 */
		
		int minDistance=0;
		for (int i = 0; i < arr.length; i++) {
			int first = arr[i];
			
			if(first != x)
				continue;
			
			boolean matchFound = false;
			int distance=0;
			
			for (int j = i+1; j < arr.length; j++) {
				++distance;
				int second = arr[j];
				if(second == y){
					matchFound=true;
					minDistance = distance; break;
				}
			}
			
			if(matchFound && distance < minDistance){
				minDistance = distance;
			}
		}
		return minDistance;
	}
}

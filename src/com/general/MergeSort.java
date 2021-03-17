package com.general;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void mergeSort(int dest[], int left, int right ){
		
		if(left < right){
			return;
		}
		
		int mid = (left+right)/2;
		mergeSort(dest, left, mid);
		mergeSort(dest, mid+1, right);
		
		merge(dest, left, mid, right);
	}
	
	
	public static void merge(int destination[], int left, int mid, int right){
		
	}

}

package com.interview.sort;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] a = {3,2,6,8,1,4};
		int low =0; int high = a.length;
		
		quickSort(a, 0, a.length-1);
		
		printArray(a);
		
	}
	
	static void quickSort(int[] a, int low, int high){
		
		if(low<high){
			int range = partition(a, low, high);
			
			// sort left
			quickSort(a, low, range-1);
			
			// sort right
			quickSort(a, range+1, high);
		}
	}
	
	public static int partition(int[] a, int low, int high){
		
		int pivot =low;
		low++;
		
		while(low <= high){
			if(a[pivot] > a[low] ){
				low++;
				continue;
			}
			if(a[pivot] <= a[high] ){
				high--;
				continue;
			}
			swap(a, low, high);
		}
		
		if(a[high] < a[pivot]){
			swap(a, pivot, high);
		}
		
		return high;
	}
	
	private int quickSelect(int arr[],int low,int high){
        int pivot = low;
        low++;
        while(low <= high){
            if(arr[pivot] > arr[low]){
                low++;
                continue;
            }
            if(arr[pivot] <= arr[high]){
                high--;
                continue;
            }
            swap(arr,low,high);
        }
        if(arr[high] < arr[pivot]){
            swap(arr,pivot,high);
        }
        return high;
    }
	

	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void printArray(int num[]){
        for(int i=0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
    }
	

}

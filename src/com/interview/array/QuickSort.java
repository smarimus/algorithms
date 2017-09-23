package com.interview.array;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] a = {5,3,21,12,8,9,1};
		
		int[] a = {5,3,21,12,8,9,8,1};
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		
		System.out.println("    ");
		
		quickSort(a,0,a.length-1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}
	
	//get a pivot, compare and move all the small to right
	//move all the large to right.
	
	private static void quickSort(int[] a, int p, int q){
		if(p<q){
			int sortedPoint = partitionFor(a, p, q);
			quickSort(a, p, sortedPoint-1);
			quickSort(a, sortedPoint+1, q);
		}
	}
	
	private static int partitionFor(int[] a, int p, int q){
		int pivot = a[q];
		int i=p-1;	
		
		for(int j=p; j<q; j++){
			
			if(a[j] <= pivot){
				i=i+1;
				
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int temp = a[i+1];
		a[i+1] = a[q];
		a[q] = temp;
		
		return i+1;
	}
	
	/*private static int partition(int[] a, int p, int q){
		int pivot = a[a.length-1];
		int i=p-1;
		int j=p;
		while(j < a.length-1){
			
			if(a[j] < pivot){
				
				i=i+1;
				
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				
			}else{
				j++;
			}
			
		}
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return i;
	}*/
}
	
	//static swap(int[] ){	}

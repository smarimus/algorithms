package com.interview.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[][] = { {1, 1, 3, 5, 7},
		            {2, 4, 6, 8},
		            {0, 9, 10, 11}} ;
		
		int arr1[][] = { {-1,-3,-5}} ;
		
		int[] result = mergearrays(arr1);
		
		printArray(result);
		
	}
	
	 static int[] mergearrays(int[][] iarray) {
		 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer> () {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	        	int val = 0;
	        	if(o1.intValue() < o2.intValue()){
	        		val = -1;
	        	}else if(o1.intValue() > o2.intValue()){
	        		val = 1;
	        	}else{
	        		val =0;
	        	}
	        	return val;
	        }
		});
		boolean reverseOrder = false;
		
		
		
		int index =0;
		for (int i = 0; i < iarray.length; i++) {
			int[] k = iarray[i];
			 for (int j = 0; j < k.length; j++) {
				 pq.add(iarray[i][j]);
				 index++;
				 
				 if(iarray[i][j] < 0){
					 reverseOrder = true;
				 }
			}
		}
		
		if(reverseOrder){
			System.out.println(true);
			pq.comparator().reversed();
		}
		 
		int[] sortedArray = new int[index];
		int i=0;
		while(pq.peek() != null){
			sortedArray[i] = pq.poll();
			i++;
		}
		
		return sortedArray;
	 }
	 
	 /*static merge(int[] a, int[] b){
		 
	 }*/
	 
	 static void printArray(int num[]){
        for(int i=0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
	 }
}
package com.ik.array.part2;

public class AlternatePositiveNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {2, 3, -4, -9, -1, -7, 1, -5, -6, 4, 8, -9, -10};
		alternatePositiveNegative(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}

	}
	//int[] a = {2, 3, -4, -9, -1, -7, 1, -5, -6};
	public static void alternatePositiveNegative(int[] a){
		
		for (int i = 0; i < a.length-1; i++) {
			
			int index = 0;
			boolean positive = false;
			
			int val = a[i];
			positive = (val > 0) ? true : false;
			
			boolean found=false;
			index = i;
			while(!found && index < a.length-1){
				int nextVal = a[++index];
				if(positive){
					found = (nextVal < 0) ? true : false;
				}else{
					found = (nextVal > 0) ? true : false;
				}
				if(found) break;
			}
			moveRight(a, i+1, index);
			i++;
		}
	}
	
	public static void moveRight(int a[], int start, int end){
		if(start >= end) return;
		int val = a[end];
		int temp=0;
		for (; start <= end; start++) {
			temp = a[start];
			a[start] = val;
			val = temp;
		}
	}
	
	public static void alternatePositiveNegative1(int[] a){
		
		
		for (int i = 0; i < a.length; i++) {
			int current = a[i];
			
			for (int j = i+1; j < a.length; j++) {
				int next =  a[j];
				
				// if cur positive, look for negative in the next place, then skip
				if(current> 0 && next > 0){
					
				}	
			
				// negative
				if(current < 0 && next > 0){
					
				}
				
			}
		}
	}
}
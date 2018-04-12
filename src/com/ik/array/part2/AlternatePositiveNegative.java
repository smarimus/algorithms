package com.ik.array.part2;

public class AlternatePositiveNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a2 = {2, 3, -4, -9, -1, -7, 1, -5, -6, 4, 8, -9, -10};
		int[] a = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
		int[] a1 = {2, 3, -4, -9};
		alternatePositiveNegative1(a);
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
		
		int cur = 0;
		while(cur < a.length-1){
			if(a[cur] < 0){
				if(a[cur+1] > 0){
					cur++; continue;
				}else{
					int ind = findSuccessor(a, true, cur+1);
					swap(a, cur+1, ind);
					cur++;
				}
			}
			
			if(a[cur] > 0){
				if(a[cur+1] < 0){
					cur++; continue;
				}else{
					int ind = findSuccessor(a, false, cur+1);
					swap(a, cur+1, ind);
					cur++;
				}
			}	
		}
	}
	
	public static int findSuccessor(int[] a, boolean isPositive, int startInd){
		
		for (int i = startInd; i < a.length; i++) {
			if(isPositive){
				if(a[i] > 0)
					return i;
			}else{
				if(a[i] < 0)
					return i;
			}
		}
		return startInd;
	}
	
	public static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
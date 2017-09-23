package com.interview.sort;

public class GroupEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {3,2,6,8,1,4, 10, 12, 7, 9}; // 2,4,6,8 - 1,3
		System.out.println(102 % 2);
		
		partition(a, 0, a.length-1);
		printArray(a);
	}
	
	static int[] groupNumbers(int[] intArr) {
		return partition(intArr, 0, intArr.length-1);
    }
	
	static int[] partition(int[] a, int low, int high){
		
		while(low <= high){
			if(a[low]%2 == 0 ){
				low++;
				continue;
			}
			if(a[high] % 2 == 1){
				high--;
				continue;
			}
			swap(a, low, high);
		}
		
		return a;
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

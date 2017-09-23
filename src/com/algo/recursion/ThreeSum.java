package com.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[] = {0, -1, 2, -3, 1};
		 //int arr[] = {1, -2, 1, 0, 5};
		 //int arr[] = {5, -2, -1, 0, 1, 2}; // -2,0,2 -1,0,1
		 int arr[] = {6, 10, 3, -4, 1, -6, 9};
		 
		 Arrays.sort(arr);
		 
		printArray(printTriplets(arr));
		
	}
	

    static String[] printTriplets(int[] intArr) {
    	ArrayList<String> ls = new ArrayList<String>();
    	
    	int len = intArr.length-1;
    	for (int i = 0; i <= len - 2; i++) {
    		int j = i+1;
    		
			int k =len;
			while(k > j){
				if(intArr[i] + intArr[j] + intArr[k] == 0){
					String s = intArr[i] + "," + intArr[j]+ "," + intArr[k];
					ls.add(s);
					k--; j++;
				}else if(intArr[i] + intArr[j] + intArr[k] < 0){
					j++;
				}else{
					k--;
				}
			}
		}

    	String[] stockArr = new String[ls.size()];
    	return ls.toArray(stockArr);
    }
    
    static int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    k--;
                } else {
                    count += k - j;
                    j++;
                }
            }
        }
        return count;
    }
    
    static void printArray(String arr[])
	 {
	     int n = arr.length;
	     for (int i=0; i<n; ++i)
	         System.out.println(arr[i]+" ");
	     System.out.println();
	 }
    
}

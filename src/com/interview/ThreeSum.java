package com.interview;

import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		
		//int[] num = {-1, 0, 1, 2, -1, -4 };
		int[] num = {-99,0,0,0,1,99};
		
		Arrays.sort(num);
	
		int len = num.length;
		for(int i=0; i< len-2; i++){
			
			if(i != 0 && num[i] == num[i-1]){
				continue;
			}
			
			int start =i+1;
			int end = len-1;
				
			while(start < end){
				
				if(num[i] +num[start] + num[end]== 0){
					print(num[i]); print(num[start]); print(num[end]);
					System.out.println(" ");
					start++; 
					end--;
				}else if(num[i] +num[start] + num[end] < 0){
					start++;
				}else{
					end--;
				}
			}
		}
	}
	static void print(int n){System.out.print(n + " ");}
}
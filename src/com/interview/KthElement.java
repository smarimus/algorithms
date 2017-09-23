package com.interview;

public class KthElement {
	
	public static void main(String[] s){
	
		int a[] = { 1 , 5 , 10, 50 }; int b[] = { 3, 4 , 15, 75 };
		
		int aSize = a.length-1;
		int bSize = b.length-1;

		//int[] cSize = new int[aSize];
		int i=0; int j=0;
		int k=2; int g=0;
		int current =0;
	
		while(g<(bSize+aSize)){
			
	        if(a[i] < b[j]){
	        	//cSize[g] =  a[i];
	        	current = a[i];
	        	i++;
	        }else{
	        	//cSize[g] =  b[j];
	        	current = b[j];
	        	j++;
	        }
	        if(g == k-1){
	        	//System.out.println(cSize[g]);
	        	System.out.println(current);
	        	break;
	        }
	        g++;
		}
	}
}
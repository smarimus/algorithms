package com.ik.array.part1;

public class ArrayProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1, 2, 3, 4, 5};
		printArray(productArray(a));
	}
	
	//Input : [1, 2, 3, 4, 5]	 Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
	// 120, 60, 40, 30, 24
	static int[] productArray(int[] a){
		
		int[] products_below = new int[a.length];
		int p=1;
		int N = a.length;
		for(int i=0;i<N;++i) {
		  products_below[i]=p;
		  p*=a[i];
		}
		
		//System.out.println(p);
		//printArray(products_below);

		int[] products_above = new int[a.length];
		p=1;
		for(int i=N-1;i>=0;--i) {
		  products_above[i]=p;
		  p*=a[i];
		}
		
		//System.out.println(p);
		//printArray(products_above);

		// This is the result
		int[] products = new int[a.length];
		for(int i=0;i<N;++i) {
		  products[i]=products_below[i]*products_above[i];
		}
		return products;
	}
	
	static void printArray(int arr[]){
	     int n = arr.length;
	     for (int i=0; i<n; ++i)
	         System.out.print(arr[i]+" ");
	     System.out.println();
	 }
	

}

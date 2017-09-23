package com.interview;

public class RotateArrayInPlace {
	
	public static int[] solution(int[] A, int K) {
		
		int len = A.length-1;
		
		//int k =2;
		for(int i=0; i<K; i++){
			
			int lastItem = A[len];
			
			for(int j=len-1; j>-1; j--){
				A[j+1] = A[j]; 
			}
			A[0]=lastItem;
		}
		return A;
	}
	
	/*for(int j=len-1; j>-1; j--){
		System.out.println(j);
	}*/
	
	// store 5
	// 1,2,3,4,5 - 5,1,2,3,4
	
	public static void main(String[] args) {
	      testSolution();
	   }

	   public static void testSolution() {
	      int[] A = new int[] { 1,2,3,4,5,6,7 };
	      printArray(A);

	      int[] B = solution(A, 3);
	      printArray(B);
	   }

	   public static void printArray(int[] A) {
	      StringBuilder sb = new StringBuilder().append("[");
	      for (int i = 0; i < A.length; i++)
	         sb.append(A[i]).append(",");

	      sb.append("]");
	      System.out.println(sb.toString());
	   }
}
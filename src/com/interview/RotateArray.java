package com.interview;

public class RotateArray {

	public static int[] solution(int[] A, int K) {
	     
		
	     int len = A.length;
	     int[] b = new int[A.length];
	     
	     int j=0;
	     for(int i=len-K; i<len; i++){
	       b[j] = A[i];
	       j++;
	     }
	     
	     for(int i=0; i<len-K; i++){
	        b[j] = A[i];
	        j++;
	     }
	      return b;
	   }

	   public static void main(String[] args) {
	      testSolution();
	   }

	   public static void testSolution() {
	      int[] A = new int[] { -1 };
	      printArray(A);

	      int[] B = solution(A, 4);
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

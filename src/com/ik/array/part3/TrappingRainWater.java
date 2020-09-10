package com.ik.array.part3;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] h = {0, 1, 0, 4, 2, 0, 5};
		//int[] h = {0, 4, 3, 3,};
		
		int[] h = {1, 0, 0, 5};
		System.out.println(trap(h));
	}
	
	public static int trap(int[] h) {
		int start=0;
		int rightRes=0;
		int leftRes=0;
		
		/*for (int i = 0; i < h.length; i++) {
			if(h[i] > 0) {
				start =i;break;
			}
		}
		for (int i = start; i < h.length; i++) {
			int curr = h[i];
			
			int count=0;
			for(; i < h.length-1 && curr > h[i+1] ; i++,count++){
				rightRes += curr - h[i+1];
			}
			
			if(count == (h.length-1) - start)rightRes=0;
		}*/
		
		
		for (int i = h.length-1; i > 0; i--) {
			if(h[i] > 0) {
				start =i;break;
			}
		}
		
		for (int i = start; i > 0; i--) {
			int curr = h[i];
			
			int count=0;
			for(; i >= 1 && curr >= h[i-1] ;--i,count++){
				leftRes += curr - h[i-1];
			}
			if(count == start)leftRes=0;
		}
		
		return rightRes + leftRes;
    }
}
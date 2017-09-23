package com.interview.playground;

public class Solutions {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int K=3;
		
		int[] b = rotate(a, K);
		for (int i = 0; i < b.length; i++) {
			//System.out.println(b[i]);
		}
		
	}
    public static int[] rotate(int[] nums, int K) {
        
        int len = nums.length;
        int rotate_length = K%len;
        System.out.println(rotate_length);
        
        int[] b = new int[nums.length];
        for (int i=0;i<len;i++) {
          int new_loc = (i+rotate_length)%len;
          System.out.println(new_loc);
          b[new_loc] = nums[i];
        }
        nums = b;
        return nums;
    }
}

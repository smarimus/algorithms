package com.ik.array.tt;

public class RotationOfPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(check_if_rotated("malayalam"));
		System.out.println(check_if_rotated("aab"));
	}
	
    /*
     * Complete the function below.
     */
    static int check_if_rotated(String s) {
    	char[] c = s.toCharArray();
    	return countRotations(s, c.length-1);
    }
    
    static int countRotations(String s, int len){
    	
    	char[] c = s.toCharArray();
    	
    	int rotationIndex=-1;
    	for (int i = 0; i < len-1; i++) {
			char fir = c[i];
			char sec = c[i+1];
			if(fir == sec){
				rotationIndex =i;
			}
		}
    	if(rotationIndex != -1){
    		s =  s.substring(rotationIndex+1, c.length) + s.substring(0, rotationIndex+1);
    	}
    	
    	return isPalindrome(s) ? 1 : 0;
    }
    
    static boolean isPalindrome(String s){

		if(s.length() <=1)
			return true;

		return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
	}
}
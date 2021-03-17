package com.interview.guidewire;

import java.util.Random;

public class SmallestStringLexicographically {
	
	/*# Example:
		# Given "bcabc"
		# Return "abc"
		#
		# Given "cbacdcbc"
		# Return "acdb"
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(findSmallestStringLexicographically("abdc"));
		//System.out.println(findSmallestStringLexicographically("family"));
		
		System.out.println((int)'z');
		int i=0;
		while(i<26){
			System.out.print(getRandomChar() + ",");
			i++;
		}
	}
	
	public static char getRandomChar(){
	    Random rnd = new Random();
	    return  (char) ('a' + rnd.nextInt(26));
	}
	
	public static String findSmallestStringLexicographically(String S){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<S.length(); i++){
			if(i+1 < S.length()){
				if(S.charAt(i) < S.charAt(i+1)){
					sb.append(S.charAt(i));
					continue;
				}else{
					sb.append(S.substring(i+1, S.length()));
					break;
				}
			}
		}
		return sb.toString();
	}

}

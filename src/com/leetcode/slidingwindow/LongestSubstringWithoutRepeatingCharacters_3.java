package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	
	public static void main(String[] args) {
		//String str = "ABDEFGABEF";
		//String str = "pwwkew";
		String str = "abcabcbb";
		//String str = "dvdf";
		//String str = "asjrgapa";
		//String str = "jbpnbwwd";
		
        System.out.println("The input string is "+str);
        int len = lengthOfLongestSubstring(str);
        System.out.println("The length of "
                + "the longest non repeating character is "+len);
	}
	
	public static int lengthOfLongestSubstring(String s) {
		
		Map<Character, Character> chMap = new HashMap<Character, Character>();
        
		int previousLen = 0;
		int currentLen =0;
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				char ch = s.charAt(j);
				
				if(chMap.get(ch) == null){
					chMap.put(ch, ch);	
					currentLen++;
					continue;
				}
				if(currentLen > previousLen){
					previousLen = currentLen;	
				}
				currentLen = 0;
				chMap = new HashMap<Character, Character>();
				break;
			}
		}
		return previousLen;
    }

}

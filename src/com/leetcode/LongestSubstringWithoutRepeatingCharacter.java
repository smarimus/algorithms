package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		String str = "ABDEFGABEF";
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
			char ch = s.charAt(i);
			
			if(chMap.get(ch) == null){
				chMap.put(ch, ch);
				currentLen++;
			}else{
				chMap = new HashMap<Character, Character>();
				chMap.put(ch, ch);
				if(currentLen > previousLen){
					previousLen = currentLen; 
					currentLen = 0;
				}
			}
		}
		if(currentLen > previousLen)
			previousLen = currentLen;
		
		return previousLen;
    }

}

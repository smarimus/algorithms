package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MinimumWindowSubstring_76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "";
		String t = "ABC";
		
		//String s = "a";
		//String t = "a";
		
		//System.out.println(s.substring(0, s.length()));
		//System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		//System.out.println(minWindow("a", "a"));
		//System.out.println(minWindow("aa", "aa"));
		System.out.println(minWindow1("bbaa", "aba"));
	}
	
	static class Result {
		int start;
		int end;
		int len;
		Result(){}
		Result(int start, int end, int len){
			this.start = start;
			this.end = end;
			this.len =len;
		}
	}
	
	public static String minWindow(String s, String t) {
		
		if(s == null || t == null || t.length() == 0) return "";
		if(t.length() > s.length()) return "";
		if(s.equals(t)) return t;
		
		Set<Character> set =  new TreeSet<Character>();
		
		char[] chArr = t.toCharArray();
		for(Character c: chArr){
			set.add(c);
		}
		
		int right=0;
		for(int j=0; j<s.length(); j++){
			if(set.contains(s.charAt(j))){
				right=j;
				break;
			}
		}
		
		Map<Character, Integer> subSet = new HashMap<Character, Integer>();
		
		Result result = null;
		int missing = set.size();
		int left=right;
		
		for (right = left+1; right < s.length(); right++) {
			char k = s.charAt(right);
			
			if(!set.contains(k)){
				continue;
			}
			
			Integer count = subSet.get(k);
			if(count == 0){
				missing--;
			}
			subSet.put(k, ++count);
			if(missing >0){
				continue;
			}
			
			if(result == null || right - left < result.end - result.start){
				result = new Result(left, right, right-left);
			}
			
			for (; left < right; left++) {
				char leftChar = s.charAt(left);
				if(!set.contains(leftChar)){
					continue;
				}
				
				//calculate length right - left
				if(result == null || right - left < result.end - result.start){
					result = new Result(left, right, right-left);
				}
				count = subSet.get(leftChar);
				subSet.put(leftChar, --count);
				
				if(count == 0){
					missing++;
					left++;
					break;
				}
			}
		}
		return (result !=  null && s.substring(result.start, result.end+1) != null) ?s.substring(result.start, result.end+1) : "" ;
	}
	
	public static String minWindow1(String s, String t) {

	      if (s.length() == 0 || t.length() == 0) {
	          return "";
	      }

	      // Dictionary which keeps a count of all the unique characters in t.
	      Map<Character, Integer> dictT = new HashMap<Character, Integer>();
	      for (int i = 0; i < t.length(); i++) {
	          int count = dictT.getOrDefault(t.charAt(i), 0);
	          dictT.put(t.charAt(i), count + 1);
	      }

	      // Number of unique characters in t, which need to be present in the desired window.
	      int required = dictT.size();

	      // Left and Right pointer
	      int l = 0, r = 0;

	      // formed is used to keep track of how many unique characters in t
	      // are present in the current window in its desired frequency.
	      // e.g. if t is "AABC" then the window must have two A's, one B and one C.
	      // Thus formed would be = 3 when all these conditions are met.
	      int formed = 0;

	      // Dictionary which keeps a count of all the unique characters in the current window.
	      Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

	      // ans list of the form (window length, left, right)
	      int[] ans = {-1, 0, 0};

	      while (r < s.length()) {
	          // Add one character from the right to the window
	          char c = s.charAt(r);
	          int count = windowCounts.getOrDefault(c, 0);
	          windowCounts.put(c, count + 1);

	          // If the frequency of the current character added equals to the
	          // desired count in t then increment the formed count by 1.
	          if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
	              formed++;
	          }

	          // Try and contract the window till the point where it ceases to be 'desirable'.
	          while (l <= r && formed == required) {
	              c = s.charAt(l);
	              // Save the smallest window until now.
	              if (ans[0] == -1 || r - l + 1 < ans[0]) {
	                  ans[0] = r - l + 1;
	                  ans[1] = l;
	                  ans[2] = r;
	              }

	              // The character at the position pointed by the
	              // `Left` pointer is no longer a part of the window.
	              windowCounts.put(c, windowCounts.get(c) - 1);
	              if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
	                  formed--;
	              }

	              // Move the left pointer ahead, this would help to look for a new window.
	              l++;
	          }

	          // Keep expanding the window once we are done contracting.
	          r++;   
	      }

	      return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	  }
}
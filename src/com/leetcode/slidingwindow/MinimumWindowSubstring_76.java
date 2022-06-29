package com.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MinimumWindowSubstring_76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "";
		String t = "ABC";

		// String s = "a";
		// String t = "a";

		// System.out.println(s.substring(0, s.length()));
		// System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(findMinWindow("a", "a"));
		System.out.println(findMinWindow("aa", "aa"));
		System.out.println(findMinWindow("bbaa", "aba"));
		System.out.println(findMinWindow("ZABAACBAB", "ABC"));
		System.out.println(findMinWindow("ADOBECODEBANC", "ABC"));
		
		System.out.println("==========");
		
		System.out.println(minWindow("a", "a"));
		System.out.println(minWindow("aa", "aa"));
		System.out.println(minWindow("bbaa", "aba"));
		System.out.println(minWindow("ZABAACBAB", "ABC"));
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	static class Pair {
		int left;
		int right;
		int len;

		Pair(int l, int r) {
			left = l;
			right = r;
		}
	}

	public static String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		// Dictionary which keeps a count of all the unique characters in t.
		Map<Character, Integer> dictT = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			int count = dictT.getOrDefault(t.charAt(i), 0);
			dictT.put(t.charAt(i), count + 1);
		}

		// Number of unique characters in t, which need to be present in the desired
		// window.
		int required = dictT.size();

		// Left and Right pointer
		int l = 0, r = 0;

		// formed is used to keep track of how many unique characters in t
		// are present in the current window in its desired frequency.
		// e.g. if t is "AABC" then the window must have two A's, one B and one C.
		// Thus formed would be = 3 when all these conditions are met.
		int formed = 0;

		// Dictionary which keeps a count of all the unique characters in the current
		// window.
		Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

		// ans list of the form (window length, left, right)
		int[] ans = { -1, 0, 0 };

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

	public static String findMinWindow(String s, String t) {

		Set<Character> set = new TreeSet();
		char[] chArr = t.toCharArray();
		for (Character c : chArr) {
			set.add(c);
		}

		return shortestContainingSubArray(s, s.toCharArray(), set);
	}

	public static String shortestContainingSubArray(String s, char[] array, Set<Character> set) {
		int left;
		for (left = 0; left < array.length; ++left) {
			if (set.contains(array[left]))
				break;
		}
		if (left == array.length) {
			return "";
		}
		if (set.size() == 1) {
			// return new Pair(left, left);
			return s.substring(left);
		}

		Map<Character, Integer> map = new HashMap();
		map.put(array[left], 1);
		int missing = set.size() - 1;
		Pair result = null;

		for (int right = left + 1; right < array.length; ++right) {
			char c = array[right];
			if (!set.contains(c))
				continue;

			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);

			if (count == 0)
				missing--;

			if (missing > 0)
				continue;

			for (;; ++left) {
				c = array[left];
				if (!set.contains(c))
					continue;

				if (result == null || right - left < result.right - result.left)
					result = new Pair(left, right);

				count = map.get(c);
				map.put(c, --count);
				if (count == 0) {
					++left;
					missing = 1;
					break;
				}
			}
		}
		return s.substring(result.left, result.right + 1);
	}



	public static String findMinWindow1(String s, String t) {

		Set<Character> set = new TreeSet<Character>();
		char[] chArr = t.toCharArray();
		for (Character c : chArr) {
			set.add(c);
		}

		return shortestContainingSubArray1(s, t, set);
	}

	//ADOBECODEBANC
	//ABC
	public static String shortestContainingSubArray1(String s, String t, Set<Character> set) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		char[] sArr = s.toCharArray();
		int right=0;
		for(int z=0; z<sArr.length; z++){
			if (set.contains(sArr[z])){
				right = z;
			}
		}
		map.put(sArr[right], 1);
		int missing = t.length()-1;
		Pair result = null;

		int left = right;

		for(; right< sArr.length; right++){
			char c = sArr[right];
			if(!set.contains(c)){
				continue;
			}
			int count = map.getOrDefault(c, 0);
			map.put(c, count+1);

			if(count == 0 ){
				missing--;
			}
			if(missing>0){
				continue;
			}

			for(; ; left++){
				c = sArr[left];
				if(!set.contains(c)){
					continue;
				}
				if(result == null || left - right  < result.right - result.left){
					result = new Pair(left, right);
				}
				
				count = map.getOrDefault(c, 0);
				if(count == 1){
					map.put(c, count--);
					left++;
					missing=1;
					break;
				}
			}
		}
		return s.substring(left, right+1);
	}
}
package com.ik.string.session;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String s = "hello world";
		String s = "bbaa";
		String t = "aba";
		Arrays.asList(t.toCharArray());

		Set<Character> controlSet = new HashSet<Character>();
		for (char c : t.toCharArray()) {
			controlSet.add(c);
		}

		// shortestString(s.toCharArray());
		Result r = shortestContainingSubArray(s.toCharArray(), controlSet);
		System.out.println("Output: " + r.left + " " + r.right);
		System.out.println("Output: " + s.substring(r.left, r.right + 1));

		// r = shortestString(s.toCharArray(), controlSet);
		// System.out.println("Output: " + (r.right - r.left) );
	}

	static Result shortestString(char[] c, Set<Character> controlSet) {

		int left;
		for (left = 0; left < c.length; left++) {
			if (controlSet.contains(c[left])) {
				break;
			}
		}

		int missing = controlSet.size() - 1;
		Map<Character, Integer> map = new HashMap<>();
		map.put(c[left], 1);
		Result result = null;

		for (int right = left + 1; right < c.length; right++) {
			char current = c[right];

			if (!controlSet.contains(current)) {
				continue;
			}
			int count = map.getOrDefault(c[right], 0);
			map.put(current, count + 1);

			if (count == 0) {
				missing--;
			}
			if (missing > 0) {
				continue;
			}
			// We have the result here.
			for (;; left++) {
				char lChar = c[left];
				if (!controlSet.contains(lChar)) {
					continue;
				}

				if (result == null || right - left < result.right - result.left)
					result = new Result(left, right);

				int cnt = map.get(current);
				map.put(lChar, --cnt);

				if (cnt == 0) {
					left++;
					missing = 1;
					break;
				}
			}
		}

		return result;
	}

	public static int shortestSubArray(String s, char[] charSet) {

		// helloworld
		char[] c = s.toCharArray();

		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < charSet.length; i++) {
			set.add(charSet[i]);
		}

		int i = 0;
		for (; i < c.length; i++) {
			if (!set.contains(c[i])) {
				continue;
			}
			break;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int missing = set.size() - 1;

		Pair pair = null;
		for (int left = i; left < c.length; left++) {

			if (!set.contains(c[left])) {
				continue;
			}

			int count = map.getOrDefault(c[left], 0);
			map.put(c[left], count++);

			if (count == 0) {
				missing--;
			}

			if (missing > 0) {
				continue;
			}

			for (int right = left; right < c.length; right++) {
				if (!set.contains(c[left])) {
					continue;
				}

				if (pair == null || (right - left < pair.right - pair.left)) {
					pair = new Pair(left, right);
				}

				count = map.get(c[left]);

				if (count != 0) {
					map.put(c[left], --count);
					continue;
				}
				missing++;
				break;
			}
		}
		int result = 0;
		if (pair != null)
			result = pair.right - pair.left;

		return result;
	}

	static class Pair {
		public int left;
		public int right;

		Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	public static Result shortestContainingSubArray(char[] array, Set<Character> set) {
		int left;
		for (left = 0; left < array.length; ++left) {
			if (set.contains(array[left]))
				break;
		}

		if (left == array.length)
			return null;

		if (set.size() == 1)
			return new Result(left, left);

		Map<Character, Integer> map = new HashMap<>();
		map.put(array[left], 1);
		int missing = set.size() - 1;
		Result result = null;

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

				if (result == null || right - left < result.right - result.left) {
					System.out.println(left + " " + right + ": " + (right - left));
					result = new Result(left, right);
				}

				count = map.get(c);
				map.put(c, --count);

				if (count == 0) {
					++left;
					missing = 1;
					break;
				}
			}
		}

		return result;
	}

	public static class Result {
		int left;
		int right;

		Result(int start, int end) {
			this.left = start;
			this.right = end;
		}
	}

	public String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		// Dictionary which keeps a count of all the unique characters in t.
		Map<Character, Integer> dictT = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			int count = dictT.getOrDefault(t.charAt(i), 0);
			dictT.put(t.charAt(i), count + 1);
		}

		// Number of unique characters in t, which need to be present in the
		// desired window.
		int required = dictT.size();

		// Left and Right pointer
		int l = 0, r = 0;

		// formed is used to keep track of how many unique characters in t
		// are present in the current window in its desired frequency.
		// e.g. if t is "AABC" then the window must have two A's, one B and one
		// C.
		// Thus formed would be = 3 when all these conditions are met.
		int formed = 0;

		// Dictionary which keeps a count of all the unique characters in the
		// current window.
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

			// Try and contract the window till the point where it ceases to be
			// 'desirable'.
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

				// Move the left pointer ahead, this would help to look for a
				// new window.
				l++;
			}

			// Keep expanding the window once we are done contracting.
			r++;
		}

		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}

}

/*
 * 
 * if(controlSet.contains(d)){ Integer count = controlSetMap.get(d);
 * if(controlSetMap.get(d) == null){ controlSetMap.put(d, 1); }else{
 * 
 * }
 * 
 */
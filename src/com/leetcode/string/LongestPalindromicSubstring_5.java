package com.leetcode.string;

public class LongestPalindromicSubstring_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(longestPalindrome2("baa"));
		System.out.println(longestPalindrome2("babad"));
		System.out.println(longestPalindrome2("cbbd"));
		System.out.println(longestPalindrome2("aasvbbbb"));
		
		// System.out.println("babad".substring(0,3));

	}

	public static String longestPalindrome(String s) {

		if (s == null || s.length() == 0)
			return "";

		int len = s.length();
		Result rs = new Result(0, 0, 0);

		boolean odd = (len % 2 == 0) ? false : true;
		int i = (len % 2 == 0) ? 0 : 1;
		for (; i < s.length(); i++) {

			int left = (odd == true) ? i - 1 : i;
			int end = i + 1;
			int count = 0;
			while (left >= 0 && end < len) {

				int leftChar = s.charAt(left);
				int right = s.charAt(end);
				if (leftChar == right) {
					count++;
				}
				if (count > rs.count) {
					rs.count = count;
					rs.start = left;
					rs.end = end;
				}
				left--;
				end++;
			}
		}
		return s.substring(rs.start, rs.end + 1);
	}

	public static String longestPalindrome1(String s) {

		if (s == null || s.length() == 0)
			return "";

		int len = s.length();
		Result rs = new Result(0, 0, 0);

		boolean odd = (len % 2 == 0) ? false : true;
		int i = (len % 2 == 0) ? 0 : 1;
		
		for (; i < s.length(); i++) {
			int left = (odd == true) ? i - 1 : i;
			int end = i + 1;
			int count = 0;
			while (left >= 0 && end < len) {

				int leftChar = s.charAt(left);
				int right = s.charAt(end);
				if (leftChar == right) {
					count++;
				}
				if (count > rs.count) {
					rs.count = count;
					rs.start = left;
					rs.end = end;
				}
				left--;	end++;
			}
		}
		return s.substring(rs.start, rs.end + 1);
	}
	
	public static String longestPalindrome2(String s) {
		
		if(s == null ||  s.length() ==0) return "";
		Result rs = new Result(0, 0, 0);
		int len = s.length();
		
		for (int i = 0; i < s.length(); i++) {
			
			int begin = i-1;
			int end = i+1;
			
			while((begin >= 0 && end < len) && s.charAt(begin) == s.charAt(end)){
				begin--; end++;
			}
			begin++;
			end--;
			
			if(rs.count < (end - begin)){
				rs.count = end-begin; rs.start=begin; rs.end=end;
			}
			
			begin = i;
			end = i+1;
			
			while((begin >= 0 && end < len) && s.charAt(begin) == s.charAt(end)){
				begin--; end++;
			}
			begin++;
			end--;
			
			if(rs.count < (end - begin)){
				rs.count = end-begin; rs.start=begin; rs.end=end;
			}
		}
		return s.substring(rs.start, rs.end+1);
	}

	static class Result {
		int start;
		int end;
		int count;

		Result(int start, int end, int count) {
			this.count = count;
			this.start = start;
			this.end = end;
		}
	}
}

package com.ik.string.session;

public class StringRegMatch {

	public static void main(String[] args) {
		System.out.println(RegMatch("abccdaa", "ab*d*"));
		System.out.println(RegMatch("abdds", "ab.d."));
	}
	static boolean RegMatch(String string, String pattern){
		return regMatch(string.toCharArray(), 0, pattern.toCharArray(), 0);
	}
	
	static boolean regMatch(char[] string, int i,  char[] pattern, int j){
		
		if(i == string.length){
			System.out.println("i: " + i + " j: " + j);
			return j == pattern.length;
		}else if(j >= pattern.length)
			return false;
		
		if(j < pattern.length && (string[i] == pattern[j] || pattern[j] == '.')){
			return regMatch(string, i+1, pattern, j+1);
		}else if(pattern[j] == '*'){
			System.out.println("* Block - i: " + i + " j: " + j);
			return regMatch(string, i, pattern, j+1) || regMatch(string, i+1, pattern, j);
		}
		
		return false;
	}
	
	static boolean regMatch1(char[] string, int i,  char[] pattern, int j){
        if(i == string.length && j == pattern.length){
            return true;
        }else if(j >= pattern.length)
            return false;
        
        else if(j < pattern.length && i < string.length && (string[i] == pattern[j] || pattern[j] == '.')){
            return regMatch(string, i+1, pattern, j+1);
        }else if(j < pattern.length && pattern[j] == '*'){
            return regMatch(string, i, pattern, j+1) || regMatch(string, i+1, pattern, j);
        }
        return false;
    }
	// 88836 96178
}

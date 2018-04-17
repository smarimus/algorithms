package com.ik.string.session;

import java.util.HashMap;
import java.util.Map;

public class LongestPallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcdefedcba";
        System.out.println( findLongestPalindromeFaster(s) );
        
        Trie trie = new Trie();
        Map<Character, Trie> map = new HashMap<Character, Trie>();
        map.put('a', new Trie());
        trie.childrens = map;
        
    }
	
    public static Pair findLongestPalindromeFaster(String s) {
        if (s.length() == 0)
            return null;

        Pair max = new Pair(0, 0);
        for (int c = 0; c < s.length() - 1; ++c) {
            int b = c - 1;
            int e = c + 1;
            while (b >= 0 && e < s.length() && s.charAt(b) == s.charAt(e)) {
                --b;
                ++e;
            }
            ++b;
            --e;
            if (e - b + 1 > max.e - max.b + 1)
                max = new Pair(b, e);

            b = c;
            e = c + 1;
            while (b >= 0 && e < s.length() && s.charAt(b) == s.charAt(e)) {
                --b;
                ++e;
            }
            ++b;
            --e;
            if (e - b + 1 > max.e - max.b + 1)
                max = new Pair(b, e);
        }
        return max;
    }
    
    
    public static Pair longestPalindrome(String s){
    	// bbac - even
    	// bbaca - odd
    	
    	char[] c = s.toCharArray();
    	int len = s.length();
    	Pair pair = new Pair(0,0);;
    	
    	for (int i = 0; i < c.length; i++) {
    		
    		int backward = i-1;
    		int forward = i+1;
    		
    		//even
    		while(backward > 0 && forward < len && c[backward] == c[forward]){
    			backward--;
    			forward++;
    		}
    		backward++;
			forward--;
    		
    		if(pair == null || forward - backward +1 > pair.e - pair.e +1){
    			pair = new Pair(backward, forward);
    		}
    		
    		backward = i;
    		forward=i+1;
    		//odd
    		while(backward > 0 && forward < len && c[backward] == c[forward]){
    			backward--;
    			forward++;
    		}
    		
    		if(pair == null || forward - backward +1 > pair.e - pair.e +1){
    			pair = new Pair(backward, forward);
    		}
		}
    	
    	return pair;
    }
    
    public static class Pair {
        public Pair(int b, int e) {
            this.b = b;
            this.e = e;
        }

        public int b, e;

        public String toString() {
            return "<" + b + "," + e + ">";
        }
    }
    
    public static class Trie{
    	public Map<Character, Trie> childrens;
    }

}

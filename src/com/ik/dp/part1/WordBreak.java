package com.ik.dp.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("catsanddog".substring(0, 1));
		//System.out.println(wordBreak(new StringBuffer("catsanddog")));
		
		System.out.println(wordBreak(new StringBuffer("abcde")));
		
		
		Set<String> wordDict = new TreeSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("dog");
		List<String> res = wordBreakDp("catsanddog", wordDict);
		
		for(String s : res){
			System.out.println(s);
		}
	}
	
	public static boolean dictionary(String word ){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("cat", "cat");
		map.put("cats", "cats");
		map.put("dog", "dog");
		map.put("sand", "sand");
		map.put("and", "and");
		
		map.put("e", "e");
		map.put("d", "d");
		map.put("c", "c");
		map.put("b", "b");
		map.put("a", "a");
		
		boolean result = (map.get(word) != null);
		System.out.println(word + " " + result);
		
		return result;
	}
	
	public static boolean wordBreak(StringBuffer word){
		
		if(word == null || "".equals(word) || word.length() ==0) return true;
		
		for(int i=0; i< word.length(); i++){
			if( (dictionary(word.substring(0, i+1))) && 
					wordBreak(new StringBuffer(word.substring(i+1, word.length()))) ){
				return true;
			}
		}
		System.out.println("never reached here");
		return false;
	}
	
	public static List<String> wordBreakDp(String s, Set<String> wordDict) {
	    ArrayList<String> [] pos = new ArrayList[s.length()+1];
	    pos[0]=new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=null){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i,j);
	                if(wordDict.contains(sub)){
	                    if(pos[j]==null){
	                        ArrayList<String> list = new ArrayList<String>();
	                        list.add(sub);
	                        pos[j]=list;
	                    }else{
	                        pos[j].add(sub);
	                    }
	                }
	            }
	        }
	    }
	 
	    if(pos[s.length()]==null){
	        return new ArrayList<String>();
	    }else{
	        ArrayList<String> result = new ArrayList<String>();
	        dfs(pos, result, "", s.length());
	        return result;
	    }
	}
	
	public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	 
	    for(String s: pos[i]){
	        String combined = s + " "+ curr;
	        dfs(pos, result, combined, i-s.length());
	    }
	}

}
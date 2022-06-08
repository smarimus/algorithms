package com.interview.wholefoods;

import java.util.HashMap;
import java.util.Map;

public class WordSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"dog", "dog", "cats", "cats"};
		Map<String, Integer> map = new HashMap<>();
		//map.put("cats", 1);
		map.put("dog", 2);
		map.put("cats", 2);
		
		String s = "dogcatscatsdog";
		System.out.println(s.substring(0, 0));
		System.out.println(wordSplit(s, map));
	}
	
	public static boolean wordSplit(String s, Map<String, Integer> map){
		return helper(s, map);
	}
	
	public static boolean helper(String s, Map<String, Integer> map){
		
		if("".equals(s) || s == null || s.length() <=0){
			return true;
		}
		for (int i = 0; i <= s.length(); i++) {
			String subStr =  s.substring(0, i);
			
			if(map.containsKey(subStr) && map.get(subStr) != 0 ){
				int count = map.get(subStr);
				map.put(subStr, --count);
				if(helper(s.substring(i, s.length()), map)){
					return true;
				}else{
					map.put(subStr, count);
				}
			}
		}
		return false;
	}
	
}

package com.ik.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeVariations {

	public static void main(String[] args) {
		//String s = "100808810";
		//String s = "321121311231";
		//String s = "122212313113787987879876755644";
		String s = "12624";
		System.out.println(decodeVariations(s));
		
		long startTime = System.nanoTime();
		System.out.println(decodeVariationsDP(s));
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;
		System.out.println(duration);
		
		startTime = System.nanoTime();
		System.out.println(decodeVariationsDPCache(s));
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println(duration);
		
	}

	static int decodeVariations(String S) {
		Map<String, Integer> cache = new HashMap<String, Integer>();
		return decodeVariations1(S, 0, 0, cache);
	}

	static int decodeVariations1(String s, int start, int count, Map<String, Integer> cache) {
		if (start == s.length()) {
			count++;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String subStr = s.substring(start, i);

			if (subStr.length() > 2)
				continue;

			int intVal = Integer.parseInt(subStr);
			if (intVal <= 26 && intVal >= 1) {
				count = decodeVariations1(s, i, count, cache);
			}
		}
		return count;
	}
	
	
	static int decodeVariationsDP(String S) {
		Map<String, Integer> cache = new HashMap<String, Integer>();
		return decodeVariations2(S, 0, 0);
	}

	static int decodeVariations2(String s, int index, int flag) {
		
		if(index > s.length()) return 0;
		
		if(flag == 2){
			String subStr = s.substring(index-2, index);
			int intVal = Integer.parseInt(subStr);
			if( intVal > 26 || intVal < 1 ){
				return 0;
			}
		}
		
		if (index == s.length()) {
			return 1;
		}
		
		int oneCount = decodeVariations2(s, index+1, 1) ;
		int twoCount = decodeVariations2(s, index+2, 2) ;
		
		return oneCount + twoCount;
	}
	
	static int decodeVariationsDPCache(String S) {
		Map<String, Integer> cache = new HashMap<String, Integer>();
		return decodeVariations3(S, 0, 0, cache);
	}

	static int decodeVariations3(String s, int index, int flag, Map<String, Integer> cache) {
		
		if(index > s.length()) return 0;
		
		if(flag == 2){
			String subStr = s.substring(index-2, index);
			int intVal = Integer.parseInt(subStr);
			if( intVal > 26 || intVal < 1 ){
				return 0;
			}
		}
		
		if (index == s.length()) {
			return 1;
		}
		
		String firstStr= ""; String secondStr = "";
		if(index+1 <= s.length())
			 firstStr = s.substring(index, index+1);
			
		if(index+2 <= s.length())
			secondStr = s.substring(index, index+2);
		
		
		if(cache.get(firstStr) != null && cache.get(secondStr) != null){
			return cache.get(firstStr) + cache.get(secondStr);
		}
		
		int oneCount = decodeVariations3(s, index+1, 1, cache) ;
		int twoCount = decodeVariations3(s, index+2, 2, cache) ;
		
		cache.put(firstStr+(index+1), oneCount);
		cache.put(secondStr+(index+1), twoCount);
		
		return oneCount + twoCount;
	}
}

/*
 Input:
 
"122231131122"
Expected:
 
120
Actual:
 
120

Input:
 
"122212313113"
Expected:
 
126
Actual:
 
126
 */

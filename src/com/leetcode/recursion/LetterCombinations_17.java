package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letterCombinations("");
		
		/*char ch = '1';
		char ch2 = '2';
		int num = ch;
		int num2 = ch2;
		System.out.println("ASCII value of char "+ch+ " is: "+Character.getNumericValue(num));
		System.out.println("ASCII value of char "+ch2+ " is: "+Character.getNumericValue(num2));*/
		
		boolean isNumber = true;
		try{
			System.out.println(Integer.parseInt("100a"));;
		}catch(NumberFormatException nf){
			isNumber = false;
		}
	}
	
	public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        Map<Integer, char[]> mp = new HashMap<>();
        mp.put(2, new char[]{'a','b', 'c'});
        mp.put(3, new char[]{'d','e', 'f'});
        mp.put(4, new char[]{'g','h', 'i'});
        mp.put(5, new char[]{'j','k', 'l'});
        mp.put(6, new char[]{'m','n', 'o'});
        mp.put(7, new char[]{'p','q', 'r', 's'});
        mp.put(8, new char[]{'t','u', 'v'});
        mp.put(9, new char[]{'w','x', 'y', 'z'});
        
        helper(list, sb, digits, mp, 0);
        
        for(String in: list){
			System.out.println(in);
		}
        
        return list;
    }
	
	public static void helper(List<String> list, StringBuilder sb, String digits, Map<Integer, char[]> mp,
			int index){
		
		if(digits.length() == index){
			list.add(sb.toString());
			return;
		}
		
		char[] arr = mp.get(Character.getNumericValue(digits.charAt(index)));
		for(int i=0; i<arr.length; i++){
			sb.append(arr[i]);
			helper(list, sb, digits, mp, index+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		letterCasePermutation("a1b2");
		letterCasePermutation("3z4");
		//letterCasePermutation("12345");
		//letterCasePermutation("0");
	}
	
	public static List<String> letterCasePermutation(String S) {
        List<String> s = new ArrayList<String>();
        char[] chArr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        permutaion(chArr, s, 0, sb);
        
		for(String in: s){
			System.out.println(in);
		}
		
        return s;
    }
	    
	public static void permutaion(char[] chArr, List<String> s, int index, StringBuilder sb){
        if(index == chArr.length){
            s.add(sb.toString());
            return;
        }
        char ch = chArr[index];
        
        String str = String.valueOf(ch);
        if(!Character.isDigit(ch)){
        	
            sb.append(str.toLowerCase());
            permutaion(chArr, s, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
            
            sb.append(str.toUpperCase());
            permutaion(chArr, s, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }else{
        	sb.append(str);
        	permutaion(chArr, s, index+1, sb);
        	sb.deleteCharAt(sb.length()-1);
        }
    }

}

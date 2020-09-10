package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(4);
		/*generateParenthesis(5);
		generateParenthesis(6);
		generateParenthesis(7);
		generateParenthesis(8);
		generateParenthesis(9);
		generateParenthesis(10);
		generateParenthesis(11);
		generateParenthesis(12);*/
	}
	
	public static List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		//sb.append("(");
		
		List<String> list = new ArrayList<>();
		helper(list, n, n, sb);
		//System.out.println(list.size());

		for(String in: list){
			//System.out.println(in);
		}
		//System.out.println("");
		System.out.println(list.size());
		
		return list;
    }
	
	public static void helper(List<String> list, int n, int i, StringBuilder sb) {
		
		
		if(")".equals(sb.substring(0)))return;
		
		if(i == n && sb.length() == n*2){
			list.add(sb.toString());
			//System.out.println(sb.toString());
			return;
		}else if(sb.length() == n*2 ){
			return;
		}
		if(i <= 0 && sb.length() == n*2 ){
			return;
		}
		if(i<0 || i>n){ 
			return;
		}
		
		sb.append("(");
		helper(list, n, i-1, sb);
		sb.deleteCharAt(sb.length()-1);
		
		sb.append(")");
		helper(list, n, i+1, sb);
		sb.deleteCharAt(sb.length()-1);
	}

}

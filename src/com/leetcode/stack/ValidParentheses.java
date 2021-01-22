package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("()[]{]"));
		System.out.println(isValid("){"));
		System.out.println(isValid(")(){}"));
		System.out.println(isValid("))"));
		
		int[] arr = {3,1,5,0,9};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		Comparator intCompare = new Comparator<Integer>() {
			public int compare(Integer a, Integer b){
				return b.compareTo(a);
			}
		};
		
		Arrays.sort(arr);
		int[] arr1 = Arrays.stream(arr).
				boxed().
				sorted((a, b) -> b.compareTo(a)).
				mapToInt(i -> i).
				toArray();
		
		Arrays.stream(arr).
	    boxed().
	    sorted((a, b) -> b.compareTo(a)). // sort descending
	    mapToInt(i -> i).
	    toArray();
		
		Arrays.toString(arr1);

		
		List<Integer> list = Arrays.asList(3,1,5,0,9);
		list.stream().sorted().collect(Collectors.toList());
		
		System.out.println(list.toString());
		//https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
		//https://stackoverflow.com/questions/21970719/java-arrays-sort-with-lambda-expression
		
	}

	public static boolean isValid(String s) {

		Deque<String> stack = new ArrayDeque<String>();

		for (int i = 0; i < s.length(); i++) {
			String curr = String.valueOf(s.charAt(i));
			
			if (curr.equals(")") || curr.equals("}") || curr.equals("]")) {
				if(stack.isEmpty()){
					stack.push(curr);
					continue;
				}
				String outVal = stack.pop();
				
				if(outVal.equals(curr))
					return false;
                
                if( (outVal.equals("(") && !curr.equals(")")) ){
                    return false;
                }
                if( (outVal.equals("[") && !curr.equals("]")) ){
                	return false;
                }
                if( (outVal.equals("{") && !curr.equals("}")) ){
                	return false;
                }
			} else {
				stack.push(curr);
			}
		}

		return stack.isEmpty();
	}

}
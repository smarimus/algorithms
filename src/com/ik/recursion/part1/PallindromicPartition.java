package com.ik.recursion.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PallindromicPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> result = PallindromicPartitio("abba");
		
		Set<String> s = new TreeSet<String>();
 		
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			List<String> list = (List<String>) iterator.next();
			for (int i = 0; i < list.size(); i++) {
				//s.add(list.get(i));
				System.out.print(list.get(i) + ", ");
			}
			System.out.println(" ");
		}
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
	}
	
	static List<List<String>> PallindromicPartitio(String s){
		List<List<String>> result = new ArrayList<>();
		int offSet = 0;
		PallindromicPartitio(s, offSet, new ArrayList<String>(), result);
		return result;
	}
	
	static void PallindromicPartitio( String s, int offSet, List<String> partialPartition, List<List<String>> result){
		if(offSet == s.length()){
			result.add(new ArrayList<>(partialPartition));
			return;
		}
		for (int i = offSet + 1; i <= s.length(); ++i) {
			String prefix = s.substring(offSet, i);
			if(isPalindrome(prefix)){
				partialPartition.add(prefix);
				PallindromicPartitio(s, i, partialPartition, result);
				partialPartition.remove(partialPartition.size()-1);
			}
		}
	}
	
	static boolean isPalindrome(String s){
		if(s.length() <=1)
			return true;
		return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
	}
}

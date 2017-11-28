package com.ik.recursion.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PalPart {
	
	public static void main(String[] args) {
		List<List<String>>  result = partition("0204451881");
		
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

    public static List<List<String>> partition(String s) {
    	List<List<String>>  resultLst = new ArrayList<List<String>>();
    	ArrayList<String> currLst = new ArrayList<String>();
        backTrack(s,0, resultLst, currLst);
        return resultLst;
    }
    public static void backTrack(String s, int l, List<List<String>> resultLst, ArrayList<String> currLst){
        if(currLst.size()>0 //the initial str could be palindrome
            && l>=s.length()){
                List<String> r = (ArrayList<String>) currLst.clone();
                resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s, i+1, resultLst, currLst);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}

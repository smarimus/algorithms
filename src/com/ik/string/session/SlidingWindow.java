package com.ik.string.session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s = "hello world";
		String s = "qqqqwAArrAAlAAwArAlAAAwrl";
		Set<Character> controlSet = new HashSet<Character>(); 
		controlSet.add('l');
		controlSet.add('r');
		controlSet.add('w');
		
		//shortestString(s.toCharArray());
		Result r = shortestContainingSubArray(s.toCharArray(), controlSet);
		System.out.println(r.left + " " + r.right);
		
		int a = 5 ;
		a = a++;
		System.out.println(a);
		
		for (int i = 0; i <= 1; ++i) {
			System.out.println("a: " + i);
		}
	}
	
	static Result shortestString(char[] c, Set<Character> controlSet){
		
		int left;
		for (left = 0; left < c.length; left++) {
			if(controlSet.contains(c[left])){
				break;
			}
		}
		
		int missing = controlSet.size()-1;
		Map<Character, Integer> map = new HashMap<>();
		map.put(c[left], 1);
		Result result = null;
		
		for (int right = left + 1; right < c.length; right++) {
			char current = c[right];
			
			if(!controlSet.contains(current)){
				continue;
			}
			
			int count = map.getOrDefault(c[right], 0);
			map.put(current, count +1);
			
			if(count == 0){
				missing--;
			}
			
			if(missing > 0){
				continue;
			}
			// We have the result here.
			for (; ; left++) {
				char lChar = c[left];
				if(!controlSet.contains(lChar)){
					continue;
				}
				
				if(result == null || right - left < result.right - result.left)
					result = new Result(left, right);
				
				int cnt = map.get(current);
				map.put(lChar, --cnt);
				
				if(cnt == 0){
					left++;
					missing = 1;
					break;
				}
			}
		}
		
		return result;
	}
	
	public static Result shortestContainingSubArray(char[] array, Set<Character> set) {
        int left;
        for (left = 0; left < array.length; ++left) {
            if (set.contains(array[left]))
                break;
        }

        if (left == array.length)
            return null;

        if (set.size() == 1)
            return new Result(left, left);

        Map<Character, Integer> map = new HashMap<>();
        map.put(array[left], 1);
        int missing = set.size() - 1;
        Result result = null;

        for (int right = left + 1; right < array.length; ++right) {
            char c = array[right];
            if (!set.contains(c))
                continue;

            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);

            if (count == 0)
                missing--;

            if (missing > 0)
                continue;

            for (; ; ++left) {
                c = array[left];
                if (!set.contains(c))
                    continue;

                if (result == null || right - left < result.right - result.left)
                	System.out.println(left + " "+ right + ": "+ (right - left));
                    result = new Result(left, right);

                count = map.get(c);
                map.put(c, --count);

                if (count == 0) {
                    ++left;
                    missing = 1;
                    break;
                }
            }
        }

        return result;
    }
	
	public static class Result{
		int left;
		int right;
		
		Result(int start, int end){
			this.left = start;
			this.right = end;
		}
	}
	
}


/*

if(controlSet.contains(d)){
	Integer count = controlSetMap.get(d);
	if(controlSetMap.get(d) == null){
		controlSetMap.put(d, 1);
	}else{
		
	}
	
*/
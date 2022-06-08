package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeleteAndEarn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int deleteAndEarn(int[] nums) {
        
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Arrays.stream(nums).forEach(
				item -> {
					List<Integer> list = map.getOrDefault(item, new ArrayList<Integer>());
					list.add(item);
				});
		
		
		Integer[]  uniqueArr = map.keySet().toArray(new Integer[map.keySet().size()]);
		
		
		for(int x=0; x<uniqueArr.length; x++) {
			for(int y=x; y<uniqueArr.length; y++) {
				
			}
		}
		
		int result=0;
		Iterator<Integer> mapIter = map.keySet().iterator();
		while(mapIter.hasNext()) {
			Integer key = mapIter.next();
			
			List<Integer> list = map.get(key);
			
			for(int i=0; i<list.size(); i++) {
				Integer item = list.get(i);
				
				int pre = item-1;
				int next = item+1;
				
				map.putIfAbsent(pre, new ArrayList<Integer>());
				map.putIfAbsent(next, new ArrayList<Integer>());
				
				result = result + item;
			}
			
		}
		return result;
		
		
    }

}

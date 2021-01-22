package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		partitionLabels("ababcbacadefegdehijhklijz");
		
		System.out.println("abcdef".substring(1, 6) + "abcdef".length());

	}

	public static List<Integer> partitionLabels(String S) {

		Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
		for (int i = 0; i < S.length(); i++) {
			int ch = S.charAt(i);
			if (map.containsKey(ch)) {
				map.get(ch).add(i);
			} else {
				ArrayList<Integer> ls = new ArrayList<Integer>();
				ls.add(i);
				map.put(ch, ls);
			}
		}
		Collection<ArrayList<Integer>> values = map.values();
		int[][] intervals = new int[values.size()][2];

		values.stream().forEach(ele -> ele.size());
		Iterator<ArrayList<Integer>> it = values.iterator();

		int index = 0;
		while (it.hasNext()) {
			ArrayList<Integer> ls = it.next();
			if (ls.size() >= 2) {
				intervals[index][0] = ls.get(0);
				intervals[index][1] = ls.get(ls.size() - 1);
			} else {
				intervals[index][0] = ls.get(0);
				intervals[index][1] = ls.get(0);
			}
			index++;
		}
		
		List<Integer> result = new ArrayList<Integer>();

		int[][] res = MergeIntervals_56.merge(intervals);
		if (res != null) {
			for (int[] i : res) {
				if (res != null) {
					System.out.println(i[0] + "," + i[1]);
					result.add(S.substring(i[0], i[1]+1).length());
				}
			}
		}
		return result;
	}

}

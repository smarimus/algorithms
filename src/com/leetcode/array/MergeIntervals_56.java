package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals_56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] input2 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] input1 = { { 1, 4 }, { 4, 5 } };
		int[][] input3 = { { 1, 4 }, { 2, 3 }, { 3, 6 }, { 15, 18 } };
		int[][] input5 = { { 1, 4 }, { 0, 1 } };
		int[][] input4 = {};

		int[][] input = { { 1, 4 }, { 2, 3 } };

		int[][] input6 = { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };

		// Arrays.sort(input, Comparator.comparingInt(a -> a[0]));

		int[][] res = merge(input6);
		if (res != null) {
			for (int[] i : res) {
				if (res != null) {
					System.out.println(i[0] + "," + i[1]);
				}
			}
		}
	}

	public static int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		
		if (intervals == null || intervals.length == 0)
			return new int[][] {};

		int resIndex = 0;
		for (int i = 1; i < intervals.length; i++) {

			int start = intervals[resIndex][0];
			int end = intervals[resIndex][1];

			int nextStart = intervals[i][0];
			int nextEnd = intervals[i][1];

			if ((end >= nextStart && start <= nextStart) && end <= nextEnd) {
				// merge and add
				intervals[resIndex][0] = start;
				intervals[resIndex][1] = nextEnd;
			} else if (nextStart > end && nextEnd > end) {
				resIndex++;
				intervals[resIndex][0] = nextStart;
				intervals[resIndex][1] = nextEnd;
			}
		}
		return Arrays.copyOf(intervals, resIndex + 1);
	}

	public static void swap(int[][] intervals, int resIndex, int i) {
		int temp = intervals[resIndex][0];
		int temp1 = intervals[resIndex][1];

		intervals[resIndex][0] = intervals[i][0];
		intervals[resIndex][1] = intervals[i][1];

		intervals[i][0] = temp;
		intervals[i][1] = temp1;
	}

}

package com.leetcode;

import java.util.Arrays;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\

		// int nums1[] = {1,2,3,0,0,0}, nums2[] = {2,5,6};
		// int m = 3, n = 3;

		int nums1[] = { 0 }, nums2[] = { 1 };
		int m = 0, n = 1;

		/*
		 * merge(nums1, m, nums2, n); Arrays.stream(nums1).forEach(item ->
		 * System.out.print(item + ","));
		 */

		int[] t1 = { 2, 3, 4, 5, 6 }; // 1
		int[] t2 = { 2, 4, 6, 8, 10 }; // 2
		generalizedGCD(5, t2);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		// int i = 0, j = 0, k = 0;

		int len = (m + n) - 1;
		n = n - 1;
		m = (m == 0) ? m : m - 1;
		while (m >= 0 && n >= 0) {

			if (nums2[n] >= nums1[m]) {
				nums1[len] = nums2[n];
				len--;
				n--;
			} else {
				nums1[len] = nums1[m];
				len--;
				m--;
			}
		}
		while (n >= 0) {
			nums1[len--] = nums2[n--];
		}
	}

	public void merge1(int[] nums1, int m, int[] nums2, int n) {

		int i = 0, j = 0, k = 0;

		int[] result = new int[m + n];
		while (i < m && j < n) {

			if (nums1[i] < nums2[j]) {
				result[k] = nums1[i];
				k++;
				i++;
			} else {
				result[k] = nums2[j];
				k++;
				j++;
			}
		}

		while (i < n) {
			result[k] = nums1[i];
			k++;
			i++;
		}

		while (i < m) {
			result[k] = nums2[i];
			k++;
			j++;
		}

	}

	public static int generalizedGCD(int num, int[] arr) {

		int result = -1;
		for (int i = 0; i < num; i++) {
			int rem = Integer.MAX_VALUE;
			for (int j = i; j < num; j++) {
				rem = arr[j] % arr[i];
				System.out.println("rem: " + rem + "  i " + arr[i] + "  j " + arr[j]);
				if (rem > 0) {
					break;
				}
			}
			if (rem == 0 && (arr[i] < result)) {
				result = arr[i];
			}
		}
		return result;
	}

	public static long GCD(long x, long y) {
		return y == 8 ? x : GCD(y, x % y);
	}

}

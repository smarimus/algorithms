package com.general;

import java.util.Scanner;

class NextGreaterElement {

	public static int MathChallenge(int num) {

		char[] chars = ("" + num).toCharArray();
		int i = chars.length - 2;

		while (i >= 0 && chars[i + 1] <= chars[i]) {
			i--;
		}

		if (i < 0)
			return -1;

		int j = chars.length - 1;
		// find grater number
		while (j >= 0 && chars[j] <= chars[i]) {
			j--;
		}

		// swap
		swap(chars, i, j);
		// reverse asc remaining number
		reverse(chars, i + 1);

		return Integer.parseInt(new String(chars));
	}

	public static void swap(char[] c, int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}

	public static void reverse(char[] c, int begin) {
		int i = begin, k = c.length - 1;
		while (i < k) {
			swap(c, i, k);
			i++;
			k--;
		}
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(MathChallenge(1312));
	}

}
package com.leetcode;

import java.util.List;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static <K> void iterateUsingForEach(List<List<K>> listOfLists) {

		// Iterate the 2D list
		// and print each element
		System.out.println("[");

		for (List<K> list : listOfLists) {
			System.out.print("  [");

			for (K item : list) {
				System.out.print("  " + item + ", ");
			}
			System.out.println("], ");
		}
		System.out.println("]");
	}

}

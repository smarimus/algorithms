package com.interview.karat;

/*
We have some clickstream data that we gathered on our client's website. 
Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. 
The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence
 of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user2, user1) => ["a"] 
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history

*/

import java.io.*;
import java.util.*;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
	
public class FindContiguousHistory {
	public static void main(String[] argv) {

		String[] user0 = { "/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two" };
		String[] user1 = { "/start", "/pink", "/register", "/orange", "/red", "a" };
		String[] user2 = { "a", "/one", "/two" };
		String[] user3 = { "/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink",
				"/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen" };
		String[] user4 = { "/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red",
				"/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow" };
		String[] user5 = { "a" };
		String[] user6 = { "/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber" };

		System.out.println(findContiguousHistory(user0, user1).toString());
		System.out.println(findContiguousHistory(user3, user4).toString());
		System.out.println(findContiguousHistory(user0, user2)); // => []
																	// (empty)
		System.out.println(findContiguousHistory(user2, user1)); // => ["a"]
		System.out.println(findContiguousHistory(user5, user2)); // => ["a"]
		System.out.println(findContiguousHistory(user3, user4)); // => ["/plum",
																	// "/blue",
																	// "/tan",
																	// "/red"]
		System.out.println(findContiguousHistory(user4, user3)); // => ["/plum",
																	// "/blue",
																	// "/tan",
																	// "/red"]
		System.out.println(findContiguousHistory(user3, user6)); // => ["/tan",
																	// "/red",
																	// "/amber"]

	}
	
	public static List<String> findContiguousHistory(String[] user1, String[] user2) {
		int result = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for (int i = 0; i < user1.length; i++) {
			int k = i;
			int count = 0;
			for (int j = 0; j < user2.length; j++) {
				String val = user2[j];
				String outerVal = "";
				if (k < user1.length ) {
					outerVal = user1[k];
				}
				if (outerVal.equalsIgnoreCase(val)) {
					count++;
					k++;
					if (count > result) {
						start = i;
						end = k;
						result = count;
					}
				}else{
					count=0;
				}
			}
		}
		List<String> lists = new ArrayList<String>();
		while (start < end) {
			lists.add(user1[start]);
			start++;
		}
		return lists;
	}
}

package com.ik.recursion.session;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubSetString {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		long startTime = System.currentTimeMillis();
		//subSet("", "abcdefghijklmnopqrstuvwx", list);
		subSet("", "dep", list);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(" ");

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) + " seconds");
	}
	
	static void subSet(String soFar, String rest, List<String> list){
		
		if(rest.length() <= 0){
			//System.out.println(soFar);
			list.add(soFar);
		}else{
			subSet(soFar, rest.substring(1), list);
			subSet(soFar + rest.charAt(0), rest.substring(1), list);
		}
	}
}

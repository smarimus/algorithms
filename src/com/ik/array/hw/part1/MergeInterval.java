package com.ik.array.hw.part1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] pairs = {"1,3", "5,7"};
		
		Arrays.sort(pairs);
		Stack<String> st = mergeIntervals(pairs);
		
		System.out.println(st);
		for(String s: st){
			System.out.println(s);
		}
		
	}
	
	static Stack<String> mergeIntervals(String[] a){
		
		Stack<String> ls = new Stack<String>();
		ls.push(a[0]);
		
		int index=1;
		while(index < a.length){
			
			int[] firstPair = getPairs(ls.peek());
			int start=firstPair[0];
			int end=firstPair[1];
			
			int[] secondPair = getPairs(a[index]);
			int start1=secondPair[0];
			int end1=secondPair[1];

			if( (start1 > start && start1 < end) && end1 > end){
				ls.pop();
				ls.push(start+","+end1); index++; continue;
			}
			
			if (start1 > start && start1 > end){
				ls.push(start1+","+end1); index++; continue;
			}
			index++;
		}
		return ls;
	}
	
	static int[] getPairs(String pair){
		String[] pairs =pair.split(",");
		int newStart = Integer.parseInt(pairs[0]);
		int newEnd = Integer.parseInt(pairs[1]);
		int[] pair1 = new int[2];
		pair1[0]=newStart; pair1[1] = newEnd;
		return pair1;
	}

	/*List<String> al = new ArrayList<String>();
	String pair = a[0]; String[] pairs =pair.split(",");
	start = Integer.parseInt(pairs[0]);
	end = Integer.parseInt(pairs[1]);
	al.add(pair);*/
	
	//{{1,3}, {2,4}, {5,7}, {6,8} }
	// 1,3 - 6,8
	
	//{1,3},{2,4} - take the end 
	//{1,3}, {1, 2} - skip
	//{1,4},{5,7}  - add and keep new pointer
	/*
	if (newStart >= start &&  newEnd < end 
		skip

	if (newStart >= start && newEnd > end)
		start
		newEnd
		add into the array, continue
	if (newStart > end)
		start = newStart
		end = newEnd
		add into the array, continue
	newStart > end
		add (start and end) into array
		keep the newStart and newEnd as start and end*/
	
	// "1,3", "2,4", "5,7", "6,8"
}

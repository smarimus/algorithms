package com.ik.array.part1;

import java.util.Arrays;
import java.util.Stack;

public class MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] pairs = {"1,9", "2,4", "4,7", "6,8"};
		
		Arrays.sort(pairs);
		Stack<String> st = mergeIntervals(pairs);
		System.out.println(st);
		for(String s: st){
			System.out.println(s);
		}
		

		Interval[] intervals = new Interval[4];
		//intervals[0] = new Interval(1, 9);
		intervals[0] = new Interval(2, 4);
		intervals[1] = new Interval(4, 7);
		intervals[2] = new Interval(6, 8);
		
		mergeIntervals(intervals);
	}
	
	static void mergeIntervals(Interval[] arr){
		
	    int index = 0; // Stores index of last element
	    // in output array (modified arr[])
	 
	    // Traverse all input Intervals
	    for (int i=0; i<arr.length; i++)
	    {
	        // If this is not first Interval and overlaps
	        // with the previous one
	        if (index != 0 && arr[index-1].s <= arr[i].e){
	            while (index != 0 && arr[index-1].s <= arr[i].e){
	                // Merge previous and current Intervals
	                arr[index-1].e = Math.max(arr[index-1].e, arr[i].e);
	                arr[index-1].s = Math.min(arr[index-1].s, arr[i].s);
	                index--;
	            }
	        }
	        else // Doesn't overlap with previous, add to
	            // solution
	            arr[index] = arr[i];
	 
	        index++;
	    }
	    
	    for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].s + " , " + arr[i].e);
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
	
	static Stack<String> mergeIntervalsBF(String[] a){
		
		for (int i = 0; i < a.length; i++) {
			int[] firstPair = getPairs(a[i]);
			
			int firstStart = firstPair[0];
			int firstEnd = firstPair[1];
			
			for (int j = 0; j < a.length; j++) {
				int[] secondPair = getPairs(a[i]);
				
				int secondStart = firstPair[0];
				int secondEnd = firstPair[1];
				
				if(firstEnd < secondStart){
					continue;
				}	
				
				if(firstEnd < secondEnd){
					
				}
			}
		}
		return null;
	}
	
	static int[] getPairs(String pair){
		String[] pairs =pair.split(",");
		int newStart = Integer.parseInt(pairs[0]);
		int newEnd = Integer.parseInt(pairs[1]);
		int[] pair1 = new int[2];
		pair1[0]=newStart; pair1[1] = newEnd;
		return pair1;
	}
	
	static class Interval{
		int s;
		int e;
		Interval(int s, int e){
			this.s = s;
			this.e = e;
		}
	}
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


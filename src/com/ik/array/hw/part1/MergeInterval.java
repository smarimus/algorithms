package com.ik.array.hw.part1;

public class MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int[] mergeIntervals(int[] a){
		
		int[] results = new int[a.length];
		for (int i = 0; i < results.length; i++) {
			
			
		}
		
		return results;
	}
	
	//{{1,3}, {1, 2}, {2,4}, {5,7}, {6,8} }
	
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
		
	
	
		
		

}

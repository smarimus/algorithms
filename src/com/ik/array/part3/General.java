package com.ik.array.part3;

import java.util.ArrayList;
import java.util.List;

public class General {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[10];
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		//int[] z = new int[list.size()];
		Integer[] z = new Integer[list.size()];
		z = list.toArray(z);
		
		for(int a : z){
			System.out.println(a);
		}
	}
	
}
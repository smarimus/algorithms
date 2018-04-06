package com.ik.array.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pascalTriangle(8);
		printList(generate(10));
		System.out.println();
		printList(generate1(10));
		
	}
	
	static void pascalTriangle(int n){
		
		int[] a = new int[n];
		for (int i = 1; i < n+1; i++) {
			int[] b = new int[i];
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < i; j++) {
				
				//first and last index will have value 1.
				if(j == 0 || j+1 == i){
					b[j] = 1;
					sb.append(b[j] + " ");
				}else{
					// the value of current element is sum of 2 previous element
					b[j] = a[j] + a[j-1];
					sb.append(b[j] + " ");
				}
			}
			System.out.println(sb.toString());
			a = b;
		}
	}
	
	
	static void pascalTriangle1(int n){
		
		int[] prev = new int[n];
		for (int i = 0; i < n; i++) {
			
			if(i == 0 ){
				System.out.println(1);continue;
			}
			if(i == 1 ){
				System.out.println("1" + " " + "1");
				prev[0] = 1; prev[1] = 1;
				continue;
			}
		
			StringBuilder sb = new StringBuilder();
			sb.append(1); sb.append(" ");
			
			int[] temp = new int[i+1];
			temp[0] = 1;
			for (int j = 1; j < i; j++) {
				
				int sum = prev[j-1] + prev[j];
				sb.append(sum); sb.append(" ");
				temp[j] = sum;
			}
			temp[i] = 1;
			prev = Arrays.copyOf(temp, n);
			
			sb.append(1); sb.append(" ");
			System.out.println(sb.toString());
		}
	}
	
	static void printList(List<List<Integer>> lists){
		for (int i = 0; i < lists.size(); i++) {
			List<Integer> list = lists.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
		
	}
	
	public static List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		int[] result = new int[numRows];
		for (int i = 0; i < numRows; i++) {
			
			List<Integer> list = new ArrayList<Integer>();
			if(i == 0 ){
				list.add(1);lists.add(list);continue;
			}
			if(i == 1 ){
				list.add(1);list.add(1);
				lists.add(list);
				result[0] = 1; result[1] = 1;
				continue;
			}
			
			list.add(1);
			int[] temp = new int[i+1];
			temp[0] = 1;
			for (int j = 1; j < i; j++) {
				
				int sum = result[j-1] + result[j];
				temp[j] = sum;
				list.add(sum);
			}
			temp[i] = 1;
			result = Arrays.copyOf(temp, numRows);
			list.add(1);
			
			lists.add(list);
		}
	return lists;	
	}
	
	public static List<List<Integer>> generate1(int numRows) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < numRows; i++) {
			
			List<Integer> list = new ArrayList<Integer>();
			if(i == 0 ){
				list.add(1);lists.add(list);continue;
			}
			
			list.add(1);
			List<Integer> prev = lists.get(i-1);
			for (int j = 1; j < prev.size(); j++) {
				int sum = prev.get(j-1) + prev.get(j);
				list.add(sum);
			}
			list.add(1);
			lists.add(list);
		}
	return lists;	
	}
}

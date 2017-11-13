package com.ik.recursion.session;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubSetString {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		long startTime = System.currentTimeMillis();
		//subSet("", "abcdefghijklmnopqrstuvwx", list);
		subSet("", "abc", list);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(" ");

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) + " seconds");
		
		char[] ch1 = {'a','b','c'};
		char[] ch2 = {'d','e','p'};
		char[] ch = {'1','2','3'};
		printSubsetsMain(ch2);
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
	
	static void printSubsetsMain(char[] inp){
		char[] out = new char[inp.length];
		printSubsets(inp, 0, out, 0);
	}
	static void printSubsets(char[] array, int i, char[]output, int k) {
		if (i == array.length){
            print(output, k);return;
         }
		printSubsets(array, i+1, output, k);
		output[k] = array[i]; 
		printSubsets(array, i+1, output, k+1);
	}
	static void printSubsets1(char[] array, int i, char[]output, int k) {
		if (i == array.length){
            print(output, k);return;
         }
		
		System.out.println("i-A : "+ i + " k : "+ k );
		printSubsets(array, i+1, output, k);
		System.out.println("i-B : "+ i + " k : "+ k );
		output[k] = array[i]; 
		printSubsets(array, i+1, output, k+1);
		System.out.println("i-C : "+ i + " k : "+ k );
	}
	static void print(char[] output, int k){
		//Print output[0...k-1]
		for (int z = 0; z < k; z++) {
			System.out.print("" + output[z] + " ");
		}
		System.out.println("");
	}
}

/*
 *  void printSubsetsMain(char[] inp) // This is the original problem
output  = char array of size inp.length   
return  printSubsets(inp, 0, out, 0)

// This is the recursive version of the problem
void printSubsets(char[] array, int i, char[]output, int k) 
   if (i == array.length) 
            Print output[0...k-1] and return
   printSubsets(inp, i+1, output, k)
   output[k] = inp[i] 
   printSubsets(inp, i+1, output, k+1)

 */
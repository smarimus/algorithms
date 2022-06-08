package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoList_349 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int[] a ={2,3,4,5,5,8,8,9,11,13};
		  int[] b = {1,3,4,6,8,8,10};
		  
		  //int[] a = {4,9,5};
		  //int[] b = {9,4,9,8,4};
		  //Arrays.sort(a);
		  //Arrays.sort(b);

		  int [] res = findDuplicates(a, b);
		  System.out.println(Arrays.toString(res));

	}
	
	public static int[] findDuplicates(int[] a, int[] b){
	    Set<Integer> result = new HashSet<Integer>();
	    if(a == null || b == null || a.length == 0 || b.length == 0) 
	      return new int[0];
	      
	    int i=0;
	    int j=0;
	    while(i<a.length && j< b.length){
	      if(a[i] == b[j]){
	        result.add(a[i]);
	        i++; j++;
	      }else if(a[i] > b[j]){
	        j++;
	      }else{
	        i++;
	      }
	    }
	    
	    int[] res = new int[result.size()]; int x=0;
	    for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Integer value = (Integer) iterator.next();
			res[x] = value; x++;
		}
	    
	    return res;
	}
}
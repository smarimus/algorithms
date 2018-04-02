package com.ik.tree.part2;

import com.ik.tree.session.Node;

public class LargestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] size = new int[1];
		findSizeOfLargestBST(size);
	}
	
	/*
	 * traverse left  
	 * 	between min and root value
	 * traverse right  
	 * 	between root value and max
	 *
	 */
	
	public static MinMax findLargestBST(Node<Integer> node){
		
		// base case
		if(node == null){
			return new MinMax();
		}
		
		MinMax left = findLargestBST(node.left);
		MinMax right= findLargestBST(node.right);
		
		MinMax minMax  = new MinMax();
		if(left.isBst && right.isBst && (node.getValue() > left.min && node.getValue() < right.max)){
			minMax.count = left.count + right.count +1;
			minMax.min = left.min;
			minMax.max = left.max;
			minMax.isBst = true;
			return minMax ;
		}
		
		minMax.count = Math.max(left.count, right.count);
		minMax.min = 0;
		minMax .max = 0;
		minMax .isBst = false;
		return minMax ;
	}
	
	public static int findSizeOfLargestBST(int[] size){
		//findLargestBST(node, min, max, size);
		return 0;
	}
}

class MinMax{
	int min;
	int max;
	boolean isBst;
	int count;
	
	MinMax(){
		this.max = Integer.MIN_VALUE;
		this.min = Integer.MAX_VALUE;
		this.isBst = true;
		this.count = 0;
	}
}

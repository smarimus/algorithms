package com.ik.tree.part1;

import com.ik.tree.session.Node;

public class IsBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		isBST(null, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}
	
	public static boolean isBST(Node<Integer> node, int min, int max){
		
		if(node == null) return true;
		
		int val = node.getValue();
		
		if(val > max || val < min){
			return false;
		}
		
		boolean left = isBST(node, min, val);
		boolean right = isBST(node, val, max);
		
		return left && right;
		
	}

}

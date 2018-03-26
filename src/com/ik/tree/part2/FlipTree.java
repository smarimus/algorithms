package com.ik.tree.part2;

import com.ik.tree.session.Node;

public class FlipTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node<Integer> flipTree(Node<Integer> root){
		
		if(root == null){return null;}
		
		Node<Integer> left = root.getLeft();
		Node<Integer> right = root.getRight();
		root.setLeft(right);
		root.setRight(left);
		
		flipTree(root.getLeft());
		flipTree(root.getRight());
		
		return root;
	}

}

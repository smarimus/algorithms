package com.ik.tree.part2;

import com.ik.tree.session.Node;

public class CloneBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node<Integer> clone(Node<Integer> root){
		
		if(root == null) return null;
		
		Node<Integer> newNode = new Node<Integer>(root.getValue());
		
		newNode.setLeft(clone(root.getLeft()));
		newNode.setRight(clone(root.getRight()));
		
		return newNode;
	}
	
}

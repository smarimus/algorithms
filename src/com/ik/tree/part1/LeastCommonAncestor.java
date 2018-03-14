package com.ik.tree.part1;

import com.ik.tree.session.Node;

public class LeastCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node<Integer> LCA(Node<Integer> root, int n1, int n2){
		
		if(root == null) return null;
		
		if(root.getValue() == n1 || root.getValue() == n2) return root;
		
		Node<Integer> right = LCA(root.getRight(), n1, n2);
		Node<Integer> left = LCA(root.getLeft(), n1, n2);
		
		if(right != null && left !=  null) return root;
		
		return (left != null) ? left : right;
	}

}

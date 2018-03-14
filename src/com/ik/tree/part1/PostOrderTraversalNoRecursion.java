package com.ik.tree.part1;

import java.util.Stack;

import com.ik.tree.session.BST;
import com.ik.tree.session.Node;

public class PostOrderTraversalNoRecursion {

	public static void main(String[] args) {
		
		BST bst = new BST();
		Node<Integer> root = new Node<Integer>(25);
		
		bst.add(root, 18);
		bst.add(root, 20);
		bst.add(root, 19);
		bst.add(root, 24);
		bst.add(root, 10);
		bst.add(root, 40);
		bst.add(root, 36);
		bst.add(root, 38);
		bst.add(root, 37);
		bst.add(root, 30);
		bst.add(root, 55);
		bst.add(root, 42);
		postOrderTraversal(root);
		
		postOrderTraverse(root);
	}
	
	public static void postOrderTraversal(Node<Integer> node){
		
		Stack<Node<Integer>> s1 = new Stack<Node<Integer>>();
		Stack<Node<Integer>> s2 = new Stack<Node<Integer>>();
		s1.add(node);
		
		while(!s1.isEmpty()){
			Node<Integer> n = s1.pop();
			s2.push(n);
			if(n.getLeft() != null){
				s1.push(n.getLeft());
			}
			if(n.getRight() != null){
				s1.push(n.getRight());
			}
		}
		
		while(!s2.isEmpty()){
			System.out.print(s2.pop().getValue() + ", ");
		}
		System.out.println();
	}
	
	public static void postOrderTraverse(Node<Integer> n){
		if(n==null) return;
		postOrderTraverse(n.getLeft());
		postOrderTraverse(n.getRight());
		System.out.print(n.getValue() + " ,");
	}

}

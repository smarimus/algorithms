package com.ik.tree.part2;

import java.util.Stack;

import com.ik.tree.session.BST;
import com.ik.tree.session.Node;

public class TreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		TreeIterator ti = new TreeIterator(root);
		
		while(ti.hasNext()){
			System.out.println(ti.next().getValue());
		}

	}
	
	private Stack<Node<Integer>> s = new Stack<Node<Integer>>();
	
	TreeIterator(Node<Integer> root){
		if(root == null) return;
		
		s.push(root);
		Node<Integer> left = root.getLeft();
		while(left != null){
			s.push(left);
			left = left.getLeft();
		}
	}
	
	public Node<Integer> next(){
		Node<Integer> result = null;
		if(!s.isEmpty()){
			
			Node<Integer> node = s.pop();
			Node<Integer> innerNode = node.getRight();
			
			while(innerNode != null){
				s.push(innerNode);
				
				if(innerNode.getLeft() != null){
					//s.push(innerNode.getLeft());
					innerNode = innerNode.getLeft();
				}else{
					innerNode = innerNode.getRight();
				}
			}
			result = node;
		}
		
		return result;
	}
	
	public boolean hasNext(){
		return !s.isEmpty();
	}
}


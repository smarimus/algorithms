package com.ik.tree.session;

import java.util.Stack;

public class TreeIterator {
	
	Stack<Node<Integer>> s = new Stack<Node<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	TreeIterator(Node<Integer> node){
		pushAll(node);
	}
	
	public Node<Integer> next(){
		Node<Integer> node = s.pop();
		pushAll(node.right);
		return node;
	}
	
	public boolean hasNext(){
		return s.isEmpty();
	}
	
	void pushAll(Node<Integer> node){
		Node<Integer> temp = node.left;
		while(temp != null){
			s.push(temp);
			temp = temp.left;
		}
	}
}



package com.ik.tree.part2;

import java.util.Stack;

import com.ik.tree.session.Node;

public class TreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Stack<Node<Integer>> s = new Stack<Node<Integer>>();
	
	TreeIterator(Node<Integer> root){
		if(root == null) return;
		
		if(root.getLeft() != null){
			s.push(root.getLeft());
			root = root.getLeft();
		}
	}
	
	public Node<Integer> next(){
		if(!s.isEmpty()){
			
			Node<Integer> node = s.pop();
			if(node.getRight() != null){
				Node<Integer> right = node.getRight();
				while(right != null){
					
				}
			}
		}
		return null;
	}
	
	public boolean hasNext(){
		if(!s.isEmpty()){
			return true;
		}
		
		return false;
	}
}


package com.ik.tree.part2;

import java.util.Stack;

import com.ik.tree.session.BST;
import com.ik.tree.session.Node;

public class TreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST bst = new BST();
		Node<Integer> root = new Node<Integer>(1);
		
		bst.add(root, 0);
		bst.add(root, 1);
		bst.add(root, 2);
		bst.add(root, 3);
		bst.add(root, 8);
		bst.add(root, 5);
		bst.add(root, 4);
		bst.add(root, 6);
		bst.add(root, 7);
		bst.add(root, 12);
		bst.add(root, 10);
		bst.add(root, 14);
		
		TreeIterator ti = new TreeIterator(root);
		while(ti.hasNext()){
			System.out.print(ti.next().getValue() + ", ");
		}
		//BSTIterator ti = new BSTIterator(root);
	}
	
	private Stack<Node<Integer>> s = new Stack<Node<Integer>>();
	
	TreeIterator(Node<Integer> root){
		if(root == null) return;
		s.push(root);
		pushToStack(root.getLeft());
	}
	
	public Node<Integer> next(){
		Node<Integer> node = null;
		if(!s.isEmpty()){
			node = s.pop();
			pushToStack(node.getRight());
		}
		return node;
	}
	
	private void pushToStack(Node<Integer> node){
		while(node != null){
			s.add(node);
			node = node.getLeft();
		}
	}
	
	public boolean hasNext(){
		return !s.isEmpty();
	}
	
	/*
	  public int next() {
	   
	   TreeNode result = null;
		if(!s.isEmpty()){
			
			TreeNode treeNode = s.pop();
			TreeNode innerNode = treeNode.right;
			
			while(innerNode != null){
				s.push(innerNode);
                
                if(innerNode.left == null)
					return treeNode.val;
				
				if(innerNode.left != null){
					innerNode = innerNode.left;
				}else{
					innerNode = innerNode.right;
				}
			}
			result = treeNode;
		}
		return result.val;
   } 
	 */
}


package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeProb {
	
	static void levelOrderIterative(Node node){
		
		Queue<Node> s = new LinkedList<>();
		s.add(node);
		
		while(!s.isEmpty()){
			Node n = s.poll();
			System.out.print(n.value + " ");
			
			if(n.left != null){
				s.add(n.left);
			}
			if(n.right != null){
				s.add(n.right);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeProb tb = new TreeProb();
		
		Node root = new Node(15);
		
		root.left = new Node(10);
		root.left.right = new Node(13);
		root.left.left = new Node(3);
		
		root.right = new Node(25);
		root.right.left = new Node(20);
		root.right.right = new Node(30);
		
		preOrder(root);
		System.out.println(" ");
		postOrder(root);
		System.out.println(" ");
		inOrder(root);
		System.out.println(" ");
		preOrderIterative(root);
		System.out.println(" ");
		levelOrderIterative(root);
	}
	
	static void preOrderIterative(Node node){
		
		Stack<Node> s = new Stack<Node>();
		s.push(node);
		
		while(!s.isEmpty()){
			Node n = s.pop();
			System.out.print(n.value + " ");
			
			if(n.right != null){
				s.push(n.right);
			}
			if(n.left != null){
				s.push(n.left);
			}
		}
	}
	
	static void preOrder(Node node){
		if(node == null) return;
		
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void postOrder(Node node){
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	static void inOrder(Node node){
		if(node == null) return;
		
		inOrder(node.left);
		System.out.print(node.value+ " ");
		inOrder(node.right);
	}
	
	public static class Node{
		int value;
		Node left;
		Node right;
		Node(int val){
			this.value = val;
		}
		Node(Node left, Node right, int value){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

}

package com.interview.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeProb2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeProb2 tb = new TreeProb2();
		
		Node root = new Node(15);
		
		root.left = new Node(10);
		root.left.right = new Node(13);
		root.left.left = new Node(3);
		
		root.right = new Node(25);
		root.right.left = new Node(20);
		root.right.right = new Node(30);
		
		int[] ls = new int[1000];
		int count =0;
		//preOrder(root, ls, count);
		postorderTraversal(root);
	}
	
	
	static void preOrder(Node node,  int[] list, int count){
		if(node == null) return;
		
		list[count] = node.value;
		count++;
		Node left = node.left;
		Node right = node.right;
		if(left == null && right == null){
			printNode(list, count);  System.out.println( " ");
		}
		
		preOrder(node.left, list, count );
		preOrder(node.right, list, count);
	}
	
	static void printNode(int[] ls, int len){
		for (int i = 0; i < len; i++) {
			System.out.print(ls[i] + " ");
		}
	}
	
	static void postorderTraversal(Node root) {
		
		Stack<Node> one = new Stack<Node>();
		Stack<Node> two = new Stack<Node>();
		
		one.push(root);
		
		while(!one.isEmpty()){
			Node node = (Node) one.pop();
			two.push(node);
			
			Node left = node.left;
			Node right = node.right;
			if(left != null){
				one.push(left);
			}
			if(right != null){
				one.push(right);
			}
		}
		
		while(!two.isEmpty()){
			System.out.print(((Node)two.pop()).value + " ");
		}
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

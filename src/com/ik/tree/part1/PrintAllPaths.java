package com.ik.tree.part1;

import java.util.ArrayList;
import java.util.List;

import com.ik.tree.session.BST;
import com.ik.tree.session.Node;

public class PrintAllPaths {

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
		
		printAllPath(root);
	}
	
	public static void  printAllPath(Node<Integer> root){
		int[] arr = new int[10];
		List<Node<Integer>> list = new ArrayList<Node<Integer>>();
		//printPath(root, list, 0);
		printPath1(root, arr, 0);
	}
	
	public static void printPath(Node<Integer> node, List<Node<Integer>> list, int index){
		
		if(node == null){
			print(list);
			System.out.println();
			return;
		}
		list.add(index, node);
		++index;
		printPath(node.getLeft(), list, index);
		printPath(node.getRight(), list, index);
	}
	
	public static void print(List<Node<Integer>> list){
		for(Node<Integer> node: list){
			System.out.print(node.getValue() + ", ");
		}
	}
	
	public static void printPath1(Node<Integer> node, int arr[], int index){
		if(node == null){
			print1(arr, index);
			System.out.println();
			return;
		}
		arr[index] = node.getValue();
		++index;
		
		printPath1(node.getLeft(), arr, index);
		if(node.getRight()!= null){
			printPath1(node.getRight(), arr, index);
		}
		
	}
	
	public static void print1(int arr[], int end){
		for (int i = 0; i < end; i++) {
			if(arr[i]!= 0)
				System.out.print(arr[i] + ", ");
		}
	}
	
}
package com.ik.tree.mockinterview;

import java.util.ArrayList;
import java.util.List;

import com.ik.tree.session.BST;
import com.ik.tree.session.Node;

public class PrintAllMatchingKPath {

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
		bst.add(root, 60);
		bst.add(root, 65);
		
		printAllMatchingKPath(root, 131, 131, new ArrayList<Node<Integer>>(), 0);

	}
	
	/* Recursive approch*/
	public static void printAllMatchingKPath(Node<Integer> root, int k, int sum, List<Node<Integer>> list, int index){
		if(root == null) return;
		
		sum = sum - root.getValue();
		list.add(index, root);
		++index;
		
		if(root.getLeft() == null && root.getRight() == null){
			if( sum == 0){
				print(list, index);
			}
		}else{
			printAllMatchingKPath(root.getLeft(), k, ( sum ), list, index);
			printAllMatchingKPath(root.getRight(), k, ( sum ), list, index);
		}
	}
	
	public static void print(List<Node<Integer>> list, int index){
		for (int i = 0; i < index; i++) {
			System.out.print(list.get(i).getValue() + ", ");
		}
		System.out.println("");
	}
}

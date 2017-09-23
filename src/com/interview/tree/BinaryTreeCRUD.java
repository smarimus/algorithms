package com.interview.tree;

public class BinaryTreeCRUD {
	public static void main(String[] args) {
	
		Integer[] tree = {1,2,3,4,5,6};
		Node<Integer> node = createBinarySearchTree(tree, 0, tree.length-1);
		
		inOrder(node);

	}
	
	static Node<Integer> createBinarySearchTree(Integer[] a, int low, int high){
		if(low > high){
			return null;
		}
		
		int mid = (low+high)/2;
		Node<Integer> n = new Node<Integer>(a[mid]);
		
		n.left = createBinarySearchTree(a, low, mid-1);
		n.right = createBinarySearchTree(a, mid+1, high);
		return n;
	}
	
	static void inOrder(Node<Integer> n){
		if(n==null)
			return;
		
		System.out.println(n.value);
		inOrder(n.left);
		inOrder(n.right);
	}
	
	//static search(Node<Integer> node){
		
	//}
}
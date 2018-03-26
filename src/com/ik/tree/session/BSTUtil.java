package com.ik.tree.session;

public class BSTUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
/*			1											25
													/		  \	
												  /			     \
			2							18						40	
									/		\  				   /	\
			3					10				20			36			55
							 /	  \			   /	\		/  \		/ \
			4				n		n		19		 24 |30		38	 42		n
															  /	   \
			5												37		n
*/	
	public static Node<Integer> getBST(){
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
		
		return root;
	}
	
	public static void inOrderTraverse(Node<Integer> n){
		if(n==null) return;
		inOrderTraverse(n.left);
		System.out.print(n.value + " ,");
		inOrderTraverse(n.right);
	}
	
	public static void preOrderTravers(Node<Integer> n){
		if(n==null) return;
		System.out.print(n.value + " ,");
		preOrderTravers(n.left);
		preOrderTravers(n.right);
	}
	
	public static void postOrderTravers(Node<Integer> n){
		if(n==null) return;
		postOrderTravers(n.left);
		postOrderTravers(n.right);
		System.out.print(n.value + " ,");
	}
}

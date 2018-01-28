package com.ik.tree.session;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node r2 = new Node(65);
		Node r1 = new Node(25);
		Node root = new Node(45, r1, r2);
		
		findLCA(root, new Node(30), new Node(80));

	}
	
	static Node findLCA(Node n, Node a, Node b){
		
		Node curr = n;
		if(curr.val == a.val) return a;
		if(curr.val == b.val) return b;
		
		Node left = findLCA(n, a, b);
		Node right = findLCA(n, a, b);
		
		if(left != null && right != null){
			return curr;
		}
		
		if(left == null && right != null){
			return right;
		}
		
		if(right == null && left != null){
			return left;
		}
		
		return curr;
	}
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		Node(int val){
			this.val = val;
		}
		
		Node(int val, Node left, Node right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
package com.leetcode.tree;

public class DeleteNodeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		
    }
	
	boolean found = false;
	TreeNode result;
	public TreeNode helper(TreeNode root, int key, TreeNode parent){
		
		if(root == null)
			return null;
		
		if(found){
			return result;
		}
		if(root.val == key){
			if(root.left != null & root.right != null){
				if(parent.left.val == root.val){
					TreeNode right = parent.right;
					parent = root;
					root.right = right;
				}
			}
		}
		
		TreeNode right = root.right;
		TreeNode left = root.right;
		if(right != null){
			if(right.left != null){
				root = getLeft(right);
				root.right = right;
				root.left = left;
			}
		}else if(left != null){
			if(left.right != null){
				root = getRight(right);
				root.right = right;
				root.left = left;
			}
		}
		
	
		
		if(found){
			return result;
		}
		
		helper(root.right, key, parent);
		helper(root.left, key, parent);
		
		return result;
	}
	
	//public TreeNode delete(){	}
	
	// Delete the leaf nodes from it's parent
	public TreeNode getRight(TreeNode root){
		
		TreeNode node = root;
		while(root.right != null){
			node = node.right;
		}
		return node;
	}
	
	// Delete the leaf nodes from it's parent
	public TreeNode getLeft(TreeNode root){
		
		TreeNode node = root;
		while(root.left != null){
			node = node.left;
		}
		return node;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}

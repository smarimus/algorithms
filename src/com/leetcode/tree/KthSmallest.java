package com.leetcode.tree;

public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

		Integer count = 0;
		Integer res;

	public int kthSmallest(TreeNode root, int k) {
		help(root, k);
		return res;
	}

	public void help(TreeNode root, int k) {

		if (root == null) {
			return;
		}

		kthSmallest(root.left, k);
		count++;
		
		if (count.intValue() == k){
			res = root.val;
			return;
		}

		kthSmallest(root.right, k);
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

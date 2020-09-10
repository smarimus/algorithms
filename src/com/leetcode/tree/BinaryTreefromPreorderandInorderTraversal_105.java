package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreefromPreorderandInorderTraversal_105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] preorder = {25,20,15,27,50,30,55};
		//int[] inorder = {15,20,27,25,30,50,55};
		
		int[] preorder = {-1};
		int[] inorder = {-1};
		
		TreeNode node = BinaryTreefromPreorderandInorderTraversal_105.buildTree(preorder, inorder);
		
		preOrder(node);

	}
	
	// next 
	// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	
	public static void preOrder(TreeNode node){
		if(node == null) return;
		
		System.out.print(node.val + ",");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, map);
    }
	
	private static int index1=0;
    
    public static TreeNode helper(int[] preorder, int start, int end,  Map<Integer, Integer> map){
    	
    	if(start > end || end < start) return null;
    	
    	int nodeIndex = map.get(preorder[index1]); 
    	TreeNode node = new TreeNode(preorder[index1]);
    	++index1;
    	node.left = helper(preorder, start, nodeIndex-1, map);
    	node.right = helper(preorder, nodeIndex+1, end, map);
        
    	return node;
    }
	
	 public static class TreeNode {
 		int val;
 		TreeNode left;
 		TreeNode right;
 		TreeNode() {}
 		TreeNode(int val) { this.val = val; }
 		TreeNode(int val, TreeNode left, TreeNode right) {
 			this.val = val;
 			this.left = left;
 			this.right = right;
 		}
	    }

}

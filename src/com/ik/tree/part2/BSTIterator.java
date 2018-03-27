package com.ik.tree.part2;

import java.util.Stack;

public class BSTIterator {
   
   private Stack<TreeNode> s = new Stack<TreeNode>();

   public BSTIterator(TreeNode root) {
       
       if(root == null) return;
		s.push(root);
		pushToStack(root.left);
       
   }

   /** @return whether we have a next smallest number */
   public boolean hasNext() {
	   return !s.isEmpty();
   }

   /** @return the next smallest number */
   public int next() {
	   
	   TreeNode treeNode = null;
		if(!s.isEmpty()){
			treeNode = s.pop();
			pushToStack(treeNode);
		}
		return treeNode.val;
       
   }
   
   private void pushToStack(TreeNode node){
		while(node != null){
			s.add(node);
			node = node.left;
		}
	}
   
   public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
}

/**
* Your BSTIterator will be called like this:
* BSTIterator i = new BSTIterator(root);
* while (i.hasNext()) v[f()] = i.next();
*/
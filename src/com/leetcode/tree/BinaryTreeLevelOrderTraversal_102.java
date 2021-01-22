package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode l1_1 = new TreeNode(9);
		TreeNode l1_2 = new TreeNode(20);
		
		root.left = l1_1;
		root.right = l1_2;
		
		TreeNode l2_1 = new TreeNode(15);
		TreeNode l2_2 = new TreeNode(7);
		
		TreeNode l2_3 = new TreeNode(4);
		TreeNode l2_4 = new TreeNode(8);
		
		l1_2.left = l2_1;
		l1_2.right = l2_2;
		
		l1_1.left = l2_3;
		l1_1.right = l2_4;
		
		breathFirstSearch(root);
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
      return null;  
    }
    
    public static void breathFirstSearch(TreeNode root){
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(new TreeNode(-1));
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        boolean sep = false;
        
        
        while(!q.isEmpty()){
            TreeNode val = q.poll();
            subList.add(val.val);
            
            if(q.peek() != null && q.peek().val == -1){
            	q.poll();  sep = true;
            	list.add(subList);
            	subList = new ArrayList<>();
            }
            //System.out.println(val.val);
            if(val.left!= null){
                q.add(val.left);
            }
            if(val.right!= null){
                q.add(val.right);
            }
            if(sep){
            	sep=false;
            	q.add(new TreeNode(-1));
            }
            
        }
        
        for(List<Integer> subt: list){
        	subt.stream().forEach(System.out::print);
        }
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

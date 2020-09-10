package com.leetcode.tree;

public class ValidBST_98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
		public boolean isValidBST(TreeNode root) {
	       return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	    
	    private boolean helper(TreeNode root, Integer min, Integer max){
	        if(root == null )
	            return true;
	        
	        if(root.left != null && root.val >= root.val)
	            return false;
	        if(root.right != null && root.val <= root.val)
	            return false;
	        
	        isValidBST(root.left);
	        isValidBST(root.right);
	        
	        return true;
	    }
	    
	    public class TreeNode {
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

package com.interview.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
			return"";
		
		StringBuffer val = new StringBuffer();
		
		val.append(serialize(root.left));
		val.append(root.val).append(",");
		val.append(serialize(root.right));
		
		return val.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> ls = new ArrayList<TreeNode>();
		
		StringTokenizer st = new StringTokenizer(data, ",");
		while(st.hasMoreTokens()){
			ls.add(new TreeNode(Integer.valueOf(st.nextToken())));
		}
		TreeNode node = null;
		if(ls.size() > 0){
			node = buildTree(ls, 0, ls.size()-1);
		}
		return node;
    }

	private TreeNode buildTree(List<TreeNode> ls, int start, int end){
		
		if(end < start){
			return new TreeNode(0);
		}
		int mid = (start+end) / 2;
		
		TreeNode n = ls.get(mid);
		n.left = buildTree(ls, start, mid-1);
		n.right = buildTree(ls, mid+1, end);
		
		return n;
	}
	
	public static void main(String[] args) {
		
		/*TreeNode root = new TreeNode(20);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(30);
		TreeNode n6 = new TreeNode(25);
		TreeNode n7 = new TreeNode(35);
		
		root.right = n5;
		root.left = n2;
		root.left.left = n4;
		root.left.right = n3;
		root.right.left = n6;
		root.right.right = n7;*/
		
		TreeNode root = null;
		
		Codec codec = new Codec();
		TreeNode node = codec.deserialize(codec.serialize(root));
		
		System.out.println(node);
	}
	
	private static class TreeNode{
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
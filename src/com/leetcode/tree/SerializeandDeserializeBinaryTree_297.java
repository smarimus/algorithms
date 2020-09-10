package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SerializeandDeserializeBinaryTree_297 {

	public static void main(String[] s) {

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

		SerializeandDeserializeBinaryTree_297 codec = new SerializeandDeserializeBinaryTree_297();
		TreeNode n = codec.deserialize(codec.serialize(root));
		System.out.println("");
		codec.serialize(n);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		System.out.print(sb.toString());
		return sb.toString();
	}

	public void serialize(TreeNode root, StringBuilder s) {
		if(root == null){
			s.append("#");
			s.append(",");
			return;
		}
		s.append(root.val);
		s.append(",");
		serialize(root.left, s);
		serialize(root.right, s);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> q = new ArrayDeque<>();
		Arrays.stream(data.split(",")).forEach(e -> q.add(e));
		return deserialize(q);
	}
	
	public TreeNode deserialize(Deque<String> q) {
		String val = q.poll();
		
		if("#".equals(val)){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialize(q);
		root.right = deserialize(q); 
		
		return root;
	}

	public static class TreeNode {
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

/*
 * 
 * import java.util.ArrayList; import java.util.List; import
 * java.util.StringTokenizer;
 * 
 * // Definition for a binary tree node. class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * public class Codec {
 * 
 * // Encodes a tree to a single string. public String serialize(TreeNode root)
 * { if(root==null) return"";
 * 
 * StringBuffer val = new StringBuffer();
 * 
 * val.append(serialize(root.left)); val.append(root.val).append(",");
 * val.append(serialize(root.right));
 * 
 * return val.toString(); }
 * 
 * // Decodes your encoded data to tree. public TreeNode deserialize(String
 * data) { List<TreeNode> ls = new ArrayList<TreeNode>();
 * 
 * StringTokenizer st = new StringTokenizer(data, ",");
 * while(st.hasMoreTokens()){ ls.add(new
 * TreeNode(Integer.valueOf(st.nextToken()))); } TreeNode node = null;
 * if(ls.size() > 0){ node = buildTree(ls, 0, ls.size()-1); } return node; }
 * 
 * private TreeNode buildTree(List<TreeNode> ls, int start, int end){
 * 
 * if(end < start){ return new TreeNode(0); } int mid = (start+end) / 2;
 * 
 * TreeNode n = ls.get(mid); n.left = buildTree(ls, start, mid-1); n.right =
 * buildTree(ls, mid+1, end);
 * 
 * return n; } }
 * 
 * // Your Codec object will be instantiated and called as such: // Codec codec
 * = new Codec(); // codec.deserialize(codec.serialize(root));
 */

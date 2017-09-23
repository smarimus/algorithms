package com.interview.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode n1 = new TreeNode("20");
		TreeNode n2 = new TreeNode("10");
		TreeNode n3 = new TreeNode("15");
		TreeNode n4 = new TreeNode("5");
		TreeNode n5 = new TreeNode("30");
		TreeNode n6 = new TreeNode("25");
		TreeNode n7 = new TreeNode("35");
		
		n1.right = n5;
		n1.left = n2;
		n1.left.left = n4;
		n1.left.right = n3;
		n1.right.left = n6;
		n1.right.right = n7;
		
		//inOrder(n1);
		StringBuffer sb = new StringBuffer();
		//System.out.println(inOrderSerialize(n1, sb));
		
		//inOrderSerialize(n1, sb);
		//System.out.println(sb.toString());
		System.out.println(serialize(n1));
		
		String data = serialize(n1);
		
		TreeNode n = deserialize(data);
		
		System.out.println(n);
	}
	
	static void inOrder(TreeNode n){
		if(n==null)
			return;
		
		inOrder(n.left);
		System.out.println(n.value);
		inOrder(n.right);
	}
	
	void preOrder(TreeNode n){
		if(n==null)
			return;
		
		System.out.println(n.value);
		inOrder(n.left);
		inOrder(n.right);
	}
	
	void postOrder(TreeNode n){
		if(n==null)
			return;
		inOrder(n.left);
		inOrder(n.right);
		System.out.println(n.value);
	}
	
	private static class TreeNode{
		TreeNode left;
		TreeNode right;
		String value;
		TreeNode(String s){
			this.value = s;
		}
	}
	
	
	/*static String inOrderSerialize(TreeNode n){
		
		if(n==null)
			return "";
		
		
		String leftVal = inOrderSerialize(n.left);
		
		String val = n.value;
		if(leftVal != ""){
			val += ",";
			val += leftVal;
		}
		
		leftVal + n.value
		System.out.println(n.value);
		
		String rightVal = inOrderSerialize(n.right);
		if(rightVal != ""){
			val += ",";
			val += rightVal;
		}
		
		
		return val;
	}*/
	
	//public String serialize(TreeNode root) {
	public static String serialize(TreeNode root) {
		
		if(root==null)
			return"";
		
		StringBuffer val = new StringBuffer();
		
		val.append(serialize(root.left));
		val.append(root.value).append(",");
		val.append(serialize(root.right));
		
		return val.toString();
	}
	
	//static TreeNode deSerialize(String s){
	public static TreeNode deserialize(String data) {
		List<TreeNode> ls = new ArrayList<TreeNode>();
		
		StringTokenizer st = new StringTokenizer(data, ",");
		while(st.hasMoreTokens()){
			ls.add(new TreeNode(st.nextToken()));
		}
		return buildTree(ls, 0, ls.size()-1);
	}
	
	static TreeNode buildTree(List<TreeNode> ls, int start, int end){
		
		if(end < start){
			return new TreeNode("");
		}
		int mid = (start+end) / 2;
		
		TreeNode n = ls.get(mid);
		n.left = buildTree(ls, start, mid-1);
		n.right = buildTree(ls, mid+1, end);
		
		return n;
	}

}
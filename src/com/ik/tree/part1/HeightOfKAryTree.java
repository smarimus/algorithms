package com.ik.tree.part1;

public class HeightOfKAryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(10);
		
		Node[] l1 = new Node[4];
		Node first = new Node(1);
		l1[0] = first; 
		l1[1] = new Node(2);
		l1[2] = new Node(3);
		l1[3] = new Node(4);
		
		root.children = l1;
		
		Node[] l2 = new Node[4];
		l2[0] = new Node(8);
		l2[1] = new Node(6);
		l2[2] = new Node(7);
		l2[3] = new Node(8);
		
		Node[] l3 = new Node[4];
		l3[0] = new Node(5);
		l3[1] = new Node(6);
		l3[2] = new Node(7);
		l3[3] = new Node(8);
		
		first.children = l2;
		
		System.out.println(findHeight(root));
	}
	
	public static int findHeight(Node node){
		
		if(node == null){
			return 0;
		}
		
		int height = 0;
		Node[] nodes = node.children;
		if(nodes != null){
			for (int i = 0; i < nodes.length; i++) {
				height = Math.max(height, findHeight(nodes[i]));
			}
		}
		return height + 1;
	}
	
	static class Node{
		Node(int value){
			this.value = value;
		}
		Node(int value, Node[] childern){
			this.value = value;
			this.children = childern;
		}
		int value;
		Node[] children;
	}
}

/*
 
Height Of K-Ary Tree

 
Problem Statement:
 
Given a k-ary tree containing N nodes. You have to find height of the tree. (Length of the longest path from root to any node.)
 
Input Format:
 
There are two arguments. First one denotes integer k, second one denotes root of the k-ary tree. 
 
Output Format:
 
Return an integer denoting height of the k-ary tree.
 
Constraints:
 
1 <= N <= 10^5
0 <= k <= N - 1
 
Sample Test Case:
 
Sample Input:
 
k = 3
k-ary tree:
1 is the root of the tree.
2's parent is 1.
3's parent is 1.
5's parent is 1.
4's parent is 5.
 
Sample Output:
 
2
 
Explanation:
 
Given a 3-ary tree with 5 nodes. Node 1 has 3 children 2, 3 and 5, and node 5 has one child 4.
Longest path from root is 1 -> 5 -> 4 and it's length is 2.
 
Notes:
 
Maximum time allowed in interview: 20 Minutes.
*/
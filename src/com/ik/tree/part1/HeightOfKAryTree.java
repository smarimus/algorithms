package com.ik.tree.part1;

public class HeightOfKAryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
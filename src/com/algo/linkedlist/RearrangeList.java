package com.algo.linkedlist;

public class RearrangeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void rearrangeList(Node node, int k){
		Node second = new Node();
		Node first = new Node();
		Node mid = new Node();
		
		while(node.next != null){
			
			Node current = node.next;
				
			if (current.value < k){
				first.next = current;
			}else if( current.value > k){
				second.next = current;	
			}else{
				mid = current;
			}
		}
		
		Node n = new Node(k);
		
		first.next = n;
		n.next = second;
	}
	
	private static class Node{
		int value;
		Node next;
		Node(int value){}
		Node(){}
	}
}
package com.ik.linkedlist.session;

public class Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	static Node findCycle(Node n){
		Node first = n;
		Node second = n;
		
		while(first != null && second.next != null && second.next.next != null){
			
			first = first.next;
			second = first.next.next;
			if(first == second){
				break;
			}
		}
		return first;
	}
	
	class Node{
		private Node next;
		private int val;
	}
}



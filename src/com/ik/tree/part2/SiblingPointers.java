package com.ik.tree.part2;

/*
Given a binary tree, populate nextRight pointers in each node. 
 
Constraint: Use only constant extra space.
 
e.g. Given this:
         a
       /  \
      b    c
     / \    \
    d   e    f
 
Turn it into this:
         a -> nil
       /  \
      b -> c -> nil
     / \    \
    d -> e -> f -> nil
    
 */
public class SiblingPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	static void populateSiblingPointer(Node rootNode){
		
		Node parent = rootNode;
		Node childHead = null;
		Node child = null;
		
		while(parent != null){
			while(parent != null){
				if(parent.left != null){
					if(childHead != null){
						child.next = parent.left;
					}else{
						childHead = parent.left;
					}
					child = parent.left;
				}
				
				if(parent.right != null){
					if(childHead != null){
						child.next = parent.right;
					}else{
						childHead = parent.right;
					}
					child = parent.right;
				}
				parent = childHead;
				child = null;
				childHead = null;
			}
		}
	}
	
	public class Node {
		int value;
		Node left;
		Node right;
		Node next;
		Node(int value, Node right, Node left, Node next){
			this.value = value;
			this.left = left;
			this.right = right;
			this.next = next;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
}
package com.ik.tree.session;

public class Node {
	int value;
	Node left;
	Node right;
	Node(int value, Node right, Node left){
		this.value = value;
		this.left = left;
		this.right = right;
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
}
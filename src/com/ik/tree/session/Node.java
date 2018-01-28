package com.ik.tree.session;

public class Node<T> {
	int value;
	Node<T> left;
	Node<T> right;
	Node(int value, Node<T> right, Node<T> left){
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
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
}
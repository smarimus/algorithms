package com.ik.tree.session;

public class Node<T> {
	int value;
	public Node<T> left;
	public  Node<T> right;
	public  Node<T> next;
	public Node(int value){
		this.value = value;
	}
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
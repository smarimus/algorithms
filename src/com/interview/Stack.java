package com.interview;

public class Stack<T> {
	
	private Node<T> top;
	
	public T peek(){
		return top.data;
	}
	
	public T pop(){
		T t = null;
		if(top != null){
			t = top.data;
			top = top.next;
		}
		return t;
	}
	
	public void push(T item){
		Node<T> newNode = new Node<T>(item);
		top.next = newNode;
		top = newNode;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	@SuppressWarnings("hiding")
	private class Node<T>{
		private Node<T> next;
		private T data;
		public Node(T item){
			data = item;
		}
	}
}
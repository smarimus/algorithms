package com.ik.linkedlist.session;

public class Stack<T> {
	Node<T> top;
	
	public void push(T value){
		
		if(top == null){
			top = new Node<T>(value);
		}else{
			Node<T> cur = new Node<T>(value);
			cur.next = top;
			top = cur;
		}
	}
	
	public Node<T> pop(){
		Node<T> result = null;
		
		if(top != null){
			result = top;
			top = top.next;
		}
		return result;
	}
	
	public T peek(){
		return top.getValue();
	}
	
	public boolean isEmpty(){
		return top == null;
	}

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(String.valueOf(stack.pop().getValue()));
		System.out.println(String.valueOf(stack.pop().getValue()));
		System.out.println(String.valueOf(stack.pop().getValue()));
		System.out.println(String.valueOf(stack.pop().getValue()));
		
		Stack<String> s = new Stack<String>();
		
		s.push("Sudhakar");
		s.push("Shopana");
		s.push("Nilan");
		
		System.out.println(s.pop().getValue());
		System.out.println(s.peek());
		System.out.println(s.pop().getValue());
		System.out.println(s.pop().getValue());
		s.push("Sudhakar");
		System.out.println(s.pop().getValue());
	}
}

class Node<T>{
	private T value;
	Node<T> next;
	Node(T value){
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
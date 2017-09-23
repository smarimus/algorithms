package com.interview.tree;

class Node<T>{
	Node<T> left;
	Node<T> right;
	T value;
	Node(T s){
		this.value = s;
	}
}
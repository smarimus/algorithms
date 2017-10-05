package com.algo.ik.linkedlist.tt;

import java.util.Stack;

public class QueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue q = new Queue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		
		System.out.println(q.pop());
		q.push(5);
		q.push(6);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());	
	}
}

 class Queue{
	Stack<Integer> pushStack = new Stack<Integer>();
	Stack<Integer> popStack = new Stack<Integer>();
	
	Integer pop(){
		Integer n = null;
		if(popStack.isEmpty()){
			while(!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
			n =  popStack.pop();
		}else{
			n =  popStack.pop();
		}
		return n;
	}
	
	void push(Integer n){
		
		pushStack.push(n);
		/*if(pushStack.isEmpty()){
			pushStack.push(n);
		}else{
			while(!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
			pushStack.push(n);
		}*/
	}
}
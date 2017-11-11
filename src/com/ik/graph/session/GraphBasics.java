package com.ik.graph.session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


class Node{
	HashSet<Node> childrens;
	Integer value;
	
	Node(int val){
		this.value = val;
	}
}

public class GraphBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	static void printGraph(Node node){
		HashSet visitedBuf = new HashSet();
		printGraph(node);
	}
	
	static void BFS(Node node){
		
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		
		Stack<Node> st = new Stack<Node>();
		st.add(node);
		
		while(!st.isEmpty()){
			Node n = st.pop();
			
			if(visited.get(n.value)){
				return;
			}else{
				visited.put(n.value, true);
			}
			
			HashSet<Node> childs = n.childrens;
			while(childs.iterator().hasNext()){
				Node ch = childs.iterator().next();
				st.push(ch);
			}
		}
	}
	
	HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
	
	static void BFS1(Node n, HashMap<Integer, Boolean> visited){
		
		if(visited.get(n.value)){
			return;
		}else{
			visited.put(n.value, true);
		}
		
		while(n.childrens.iterator().hasNext()){
			Node ch = n.childrens.iterator().next();
			BFS1(ch, visited);
		}
	}
	
	/*static void BFS(Node node){
		
		Queue a = new Queue<Node>();
		a.add(node);
		
		while(!a.isEmpty()){
			Node n = (Node) a.poll();
			
			while(n.childrens.iterator()){
				a.add(e)
			}
		}
	}*/

}

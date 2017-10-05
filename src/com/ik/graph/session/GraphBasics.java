package com.ik.graph.session;

import java.util.HashSet;
import java.util.Queue;

public class GraphBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	static void printGraph(Node node){
		
		HashSet visitedBuf = new HashSet();
		printGraph(node);
		
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
	
	
	class Node{
		HashSet<Node> childrens;
		Integer value;
		
		Node(int val){
			this.value = val;
		}
		
	}

}

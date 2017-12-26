package com.ik.graph.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import sun.misc.Queue;


class Node<T>{
	Set<Node<T>> childrens = new HashSet<Node<T>>();
	T value;
	
	Node(T val){
		this.value = val;
	}
	
	public Set<Node<T>> getAdjacentVertexes(){
		return this.childrens;
	}
	public T getValue(){
		return this.value;
	}
}

class Pair<T>{
	
	T pair1;
	T pair2;
	Pair(T pair1, T pair2){
		this.pair1 = pair1;
		this.pair2 = pair2;
	}
	T getPair1(){
		return pair1;
	}
	T getPair2(){
		return pair2;
	}
}

public class GraphBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<String> root = buildGraph();
		System.out.println("BFS");BFS(root);
		System.out.println("");
		
		try {
			System.out.println("DFS");	DFS(root);
		
			System.out.println("");
			
			HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
			System.out.println("BFSRecur");
			BFSRecur(root, visited);
			
			System.out.println("");
			System.out.println("ShortestPath");
			
			System.out.println(shortestPath(root, "b", "h"));
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void BFS(Node<String> node){
		
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		
		Stack<Node<String>> st = new Stack<Node<String>>();
		st.add(node);
		
		while(!st.isEmpty()){
			Node<String> n = st.pop();
			System.out.print(n.value + ",");
			
			if(visited.get(n.value) != null){
				continue;
			}else{
				visited.put(n.value, true);
			}
			
			Set<Node<String>> childs = n.getAdjacentVertexes();
			if(childs != null){
				Iterator<Node<String>> it = childs.iterator();
				while(it.hasNext()){
					Node<String> ch = it.next();
					st.push(ch);
				}
			}
		}
	}
	
	static void DFS(Node<String> node) throws InterruptedException{
		
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		
		Queue<Node<String>> st = new Queue<Node<String>>();
		st.enqueue(node);
		
		while(!st.isEmpty()){
			Node<String> n = st.dequeue();
			System.out.print(n.value + ",");
			
			if(visited.get(n.value) != null){
				continue;
			}else{
				visited.put(n.value, true);
			}
			
			Set<Node<String>> childs = n.childrens;
			if(childs != null){
				Iterator<Node<String>> it = childs.iterator();
				while(it.hasNext()){
					Node<String> ch = it.next();
					st.enqueue(ch);
				}
			}
		}
	}
	
	static void BFSRecur(Node<String> n, HashMap<String, Boolean> visited){
		
		if(visited.get(n.value) != null){
			return;
		}else{
			visited.put(n.value, true);
		}
		
		System.out.print(n.value + ",");
		
		Set<Node<String>> childs = n.childrens;
		if(childs != null){
			Iterator<Node<String>> it =childs.iterator(); 
			while(it.hasNext()){
				Node<String> ch = it.next();
				BFSRecur(ch, visited);
			}
		}
	}
	
	// g -> h
	static List<String> shortestPath(Node<String> node, String s, String e) throws InterruptedException{
		Map<String, String> backRef = new HashMap<String, String>();
		
		Queue<Node<String>> st = new Queue<Node<String>>();
		st.enqueue(node);
		
		//backRef.put(s, null);
		
		while(!st.isEmpty()){
			Node<String> n = st.dequeue();
			//System.out.print(n.value + ",");
			
			if(n.value.equals(e))break;
			
			if(s.equals(n.value))
				backRef.put(s, null);
			
			Set<Node<String>> childs = n.childrens;
			if(childs != null){
				Iterator<Node<String>> it = childs.iterator();
				while(it.hasNext()){
					Node<String> ch = it.next();
					
					if(backRef.containsKey(ch.value))
						continue;
					
					backRef.put(ch.value, n.value);
					st.enqueue(ch);
				}
			}
		}
		
		List<String> path = new ArrayList<String>(); 
		String ref = backRef.get(e);
		path.add(e);
		while(ref != null){
			path.add(ref);
			ref = backRef.get(ref);
		}
		Collections.reverse(path);
		
		return path;
	}
	
	static Node<String> buildGraph(){
		
		Node<String> a = new Node<String>("a");
		Node<String> b = new Node<String>("b");
		Node<String> c = new Node<String>("c");
		Node<String> d = new Node<String>("d");
		Node<String> e = new Node<String>("e");
		Node<String> f = new Node<String>("f");
		Node<String> g = new Node<String>("g");
		Node<String> h = new Node<String>("h");
		
		a.childrens = getChilds(b,c);
		b.childrens = getChilds(d);
		//cycle
		//d.childrens = getChilds(e, c);
		d.childrens = getChilds(e);
		e.childrens = getChilds(h);
		c.childrens = getChilds(f,g);
		
		return a;
	}
	
	@SafeVarargs
	static HashSet<Node<String>> getChilds(Node<String>... n){
		HashSet<Node<String>> set = new HashSet<Node<String>>();
		for (Node<String> node : n) {
			set.add(node);	
		}
		return set;
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
	}
	
	static void printGraph(Node node){
		HashSet visitedBuf = new HashSet();
		printGraph(node);
	}
	
	*/

}

package com.ik.graph.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ParentChild {
	
	public static void main(String[] args) {
		buildGraph();
	}
	
	static Node<Integer> buildGraph(){
		
		Node<Integer> a1 = new Node<Integer>(1);
		Node<Integer> b2 = new Node<Integer>(2);
		Node<Integer> c3 = new Node<Integer>(3);
		Node<Integer> d4 = new Node<Integer>(4);
		Node<Integer> e5 = new Node<Integer>(5);
		Node<Integer> f6 = new Node<Integer>(6);
		Node<Integer> g7 = new Node<Integer>(7);
		Node<Integer> h8 = new Node<Integer>(8);
		Node<Integer> h9 = new Node<Integer>(9);
		
		a1.childrens = getChilds(c3);
		b2.childrens = getChilds(c3);
		c3.childrens = getChilds(f6);
		e5.childrens = getChilds(f6);
		e5.childrens = getChilds(f6, g7);
		d4.childrens = getChilds(e5, h8);
		h8.childrens = getChilds(h9);
		
		
		List<Node<Integer>> vertices = new ArrayList<>();
		vertices.add(a1);
		vertices.add(b2);
		vertices.add(d4);
		
		Set<Node<Integer>> visited = new HashSet<>();
		HashMap<Node<Integer>, Set<Node<Integer>>> parentMap = new HashMap<>();
		
		// Question1
		for (Node<Integer> node : vertices) {
			parentMap.put(node, new HashSet<Node<Integer>>());
			traverseGraph(node, visited, parentMap);
		}
		
		Set<Node<Integer>> keys = parentMap.keySet();
		for (Node<Integer> node : keys) {
			//System.out.println(node.getValue()); 
			Set<Node<Integer>> relation = parentMap.get(node);
			if(relation.size() == 1){
				for (Node<Integer> node2 : relation) {
					System.out.print("Parent: (" + node.getValue() + ") :" + node2.getValue() + " ");
				}
			}
			if(relation.size() == 0){
				System.out.print("Parent: (" + node.getValue() );
			}
			System.out.println(" ");
		}
		
		// Question 2
		Set<Integer> pairSet = new HashSet<Integer>();
		pairSet.add(5); pairSet.add(8);
		visited.clear();
		boolean result =false;
		for (Node<Integer> node : vertices) {
			if(parentChildPairs(node, visited, pairSet, 0)){
				result=true;
			}
		}
		if(result){System.out.println(true);}else{System.out.println(false);}
		
		//Question 3
		//Set<Node<Integer>> keys = parentMap.keySet();
		Set<Node<Integer>> childNodeSet = parentMap.get(f6);
		while(childNodeSet != null && childNodeSet.size() > 0) {
			Iterator<Node<Integer>> iter = childNodeSet.iterator();
		
			Node<Integer> n=null;
			while(iter.hasNext()){
				 n = iter.next();
				if(parentMap.get(n).size() == 0){
					System.out.println("fartherest parent: " + n.getValue()); 
				}else{
					childNodeSet = parentMap.get(n);
				}
			}
			if(!iter.hasNext())
				childNodeSet = parentMap.get(n);
		}
		
		return a1;
	}
	
	@SafeVarargs
	static HashSet<Node<Integer>> getChilds(Node<Integer>... n){
		HashSet<Node<Integer>> set = new HashSet<Node<Integer>>();
		for (Node<Integer> node : n) {
			set.add(node);	
		}
		return set;
	}
	
	static void traverseGraph(Node<Integer> v, Set<Node<Integer>> visited, HashMap<Node<Integer>, Set<Node<Integer>>> parentMap){
		
		visited.add(v);
		//System.out.print (v.getValue()+ " ");
		Set<Node<Integer>> vertices = v.getAdjacentVertexes();
		for(Node<Integer> vertex: vertices){
			
			if(!visited.contains(vertex)){
				Set<Node<Integer>> set = new HashSet<Node<Integer>>();set.add(v);
				parentMap.put(vertex, set);
			}else{
				Set<Node<Integer>> set = parentMap.get(vertex);
				
				if(!set.contains(v)){set.add(v); parentMap.put(vertex, set);}
				else{ continue;}
			}
			traverseGraph(vertex, visited, parentMap);
		}
	}
	
	static boolean parentChildPairs(Node<Integer> v, Set<Node<Integer>> visited, 
			Set<Integer> pairSet, int count){
		boolean found = false;
		
		visited.add(v);
		Set<Node<Integer>> vertices = v.getAdjacentVertexes();
		for(Node<Integer> vertex: vertices){
			
			if(pairSet.contains(vertex.getValue().intValue())){
				count++;
			}
			if(count == 2) return true;
			if(visited.contains(vertex)) continue;
			
			found = parentChildPairs(vertex, visited, pairSet, count);
		}
		return found; 
	}
	
	
}
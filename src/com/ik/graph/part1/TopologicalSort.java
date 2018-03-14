package com.ik.graph.part1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> graph = new Graph<Integer>(false);
		graph.addVertex(new Vertex<Integer>(1));
		graph.addVertex(new Vertex<Integer>(2));
		graph.addVertex(new Vertex<Integer>(4));
		graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        topoSort(graph);
	}
	static void topoSort(Graph<Integer> graph){
		Set<Vertex<Integer>> set = new HashSet<Vertex<Integer>>();
		Deque<Vertex<Integer>> stack = new ArrayDeque<>();
		Collection<Edge<Integer>> allEdge  = graph.getAllEdges();
		Iterator<Edge<Integer>>  edge = allEdge.iterator();
		
		
		Collection<Vertex<Integer>> allVertex = graph.getAllVertex();
		for(Vertex<Integer> ver : allVertex){
			dfs(ver, stack, set);
		}
		System.out.println(Arrays.toString(stack.toArray()));
	}
	
	static void dfs(Vertex<Integer> vertex, Deque<Vertex<Integer>> stack, Set<Vertex<Integer>> visited){
		List<Vertex<Integer>> vertexes = vertex.getAdjacentVertexes();
		visited.add(vertex);
		for(Vertex<Integer> vert: vertexes){
			if(visited.contains(vertex)) continue;
			dfs(vert, stack, visited);
		}
		stack.offerLast(vertex);
	}
	
}
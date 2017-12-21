package com.ik.graph.session;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 6);
        graph.addEdge(1, 7);
        graph.addEdge(1, 8);
        graph.addEdge(2, 9);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2,4);
        graph.addEdge(3,7);
        topoSort(graph);
	}
	
	static void topoSort(Graph<Integer> graph){
		Set<Vertex<Integer>> set = new HashSet<Vertex<Integer>>();
		Deque<Vertex<Integer>> stack = new ArrayDeque<>();
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
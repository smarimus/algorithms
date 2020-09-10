package com.ik.graph.session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Clone {
	
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void BFS(UndirectedGraphNode curNode, HashSet<UndirectedGraphNode> visited){
		if(visited.contains(curNode))
			return;
		
		visited.add(curNode);
		UndirectedGraphNode newNode = new UndirectedGraphNode(curNode.label);
		
		for(UndirectedGraphNode childNode :curNode.neighbors){
			BFS(childNode, visited);
			newNode.neighbors.add(childNode);
		}
	}
}
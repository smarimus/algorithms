package com.ik.graph.part1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KnightTour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 8*8 chess board
		Map<Node, Node> backRef = new HashMap<Node, Node>();
		Node src = new Node(0,7,0); Node dest = new Node(7,0,0);
		System.out.println(shortestPath(src, dest, 7, backRef).count);
		printPath(backRef, src, dest);
		
		System.out.println("");
		
		backRef = new HashMap<Node, Node>();
		src = new Node(0,0,0); dest = new Node(3,3,0);
		System.out.println(shortestPath(src, dest, 4, backRef).count);
		System.out.println("sd" + backRef.get(dest));
		printPath(backRef, src, dest);
		
		int k =-2;
		System.out.println(k+1);
	}
	
	static Node shortestPath(Node src, Node dest, int n, Map<Node, Node> backRef){
		
		backRef.put(src, null);
		
		int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
		int col[] = { -1, 1, 1, -1, 2, -2, 2, -2 };
		Set<Node> visited = new HashSet<Node>();

		Deque<Node> queue = new ArrayDeque<Node>();
		queue.addLast(src);
		
		while(!queue.isEmpty()){
			Node node = queue.removeFirst();
			if(node.x == dest.x && node.y == dest.y){ 
				backRef.put(dest, node);
				return node;
			}
			
			if(visited.contains(node)) continue;
					
			visited.add(node);
			for (int i = 0; i < 8; i++) {
				int newX = ((node.x)+(row[i]));
				int newY = ((node.y)+(col[i]));
				
				if(isValid(newX, newY, n)){
					Node n1 = new Node(newX, newY, node.count+1);
					queue.addLast(n1);
					backRef.put(n1, node);
				}
			}
		}
		
		return new KnightTour.Node(-1,-1,0);
	}
	
	static boolean isValid(int x, int y, int n){
		
		if( (x >= 0 && x <= n) && (y >=0 && y<=n)){
			return true;
		}
		
		return false;
	}
	
	static void printPath(Map<Node, Node> backRef, Node src, Node dest){
		List<Node> path = new ArrayList<Node>(); 
		Node ref = backRef.get(dest);
		path.add(src);
		while(ref != null){
			path.add(ref);
			ref = backRef.get(ref);
		}
		Collections.reverse(path);
		
		for (Node node : path) {
			System.out.println(node.x + "," + node.y);
		}		
	}
	
	public static class Node{
		int x;
		int y;
		int count;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		public Node(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
		public void setCount(int count){
			this.count = count;
		}
		public int getCount(int count){
			return this.count;
		}
	}
}
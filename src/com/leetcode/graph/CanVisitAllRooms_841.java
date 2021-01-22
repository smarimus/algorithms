package com.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class CanVisitAllRooms_841 {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		List<Integer> visited = new ArrayList<>();
		dfs(0, rooms, visited);
		return visited.size() == rooms.size();
	}

	public void dfs(int node, List<List<Integer>> rooms, List<Integer> visited) {
		visited.add(node);
		for (int child : rooms.get(node)) {
			if (!visited.contains(child)) {
				dfs(child, rooms, visited);
			}
		}
	}
	
	public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); 
        dfs.add(0);
        
        HashSet<Integer> seen = new HashSet<Integer>(); 
        seen.add(0);
        
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }

}

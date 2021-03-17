package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Detect Cycle in Graph
//https://medium.com/@trykv/algorithms-on-graphs-directed-graphs-and-cycle-detection-3982dfbd11f5

//https://medium.com/@trykv/algorithms-on-graphs-simplifying-dags-with-topological-sort-ad1c3bca9c13

public class CourseScheduleII_210 {

	static Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
	static Map<Integer, Integer> color = new HashMap<>();
	static boolean isPossible = true;
	static Deque<Integer> stack = new ArrayDeque<Integer>();
    
	static int WHITE = 0;
	static int GREY = 1;
	static int BLACK = 2;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for(int j=0; j< prerequisites.length; j++){
        	ArrayList<Integer> list = adjList.getOrDefault(prerequisites[j][1], new ArrayList<Integer>());
        	list.add(prerequisites[j][0]);
        	adjList.put(prerequisites[j][1], list);
        }
        
        for(int i=0; i< numCourses; i++){
        	if(color.get(i) != BLACK){
        		dfs(i);
        	}
        }
        
        for(int k=0; k< numCourses; k++){
        	color.put(k, WHITE);
        }
        
        if(isPossible){
        	int[] res = new int[stack.size()];
        	int i=0;
        	while(!stack.isEmpty()){
        		res[i] = stack.pop();
        		i++;
        	}
        	return res;
        }
        
        return new int[0];
    }
    
    public static void dfs(Integer node){
    	
    	if(isPossible == false){
    		return;
    	}
    	color.put(node, GREY);
    	ArrayList<Integer> childs = adjList.get(node);
    	for(Integer child: childs){
    		if(color.get(child) == WHITE){
    			dfs(node);
    		}else if(color.get(child) == GREY){
    			isPossible = false;
    		}
    	}
    	
    	color.put(node, BLACK);	
    	stack.push(node);
    }
    
    public int[] findOrder1(int numCourses, int[][] prerequisites) {

        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
          int dest = prerequisites[i][0];
          int src = prerequisites[i][1];
          List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
          lst.add(dest);
          adjList.put(src, lst);

          // Record in-degree of each vertex
          indegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
          if (indegree[i] == 0) {
            q.add(i);
          }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
          int node = q.remove();
          topologicalOrder[i++] = node;

          // Reduce the in-degree of each neighbor by 1
          if (adjList.containsKey(node)) {
            for (Integer neighbor : adjList.get(node)) {
              indegree[neighbor]--;

              // If in-degree of a neighbor becomes 0, add it to the Q
              if (indegree[neighbor] == 0) {
                q.add(neighbor);
              }
            }
          }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
          return topologicalOrder;
        }

        return new int[0];
      }
    
	public static void main(String[] args) {
		
		int WHITE = BLACK = GREY = 0;
		
		// TODO Auto-generated method stub
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		System.out.print(adjList.getOrDefault(0, new ArrayList<Integer>()));
	}
	
}

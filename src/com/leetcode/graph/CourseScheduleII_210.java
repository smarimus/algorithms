package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
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
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

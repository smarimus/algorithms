package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static int WHITE = 0; static int GREY = 1; static int BLACK = 2;
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static Map<Integer, Integer> color = new HashMap<>();
    static boolean isPossible = true;
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public static void dfs(int node, Map<Integer, Integer> color){
        if(!isPossible){
            return;
        }
        color.put(node, GREY);//exploring

        List<Integer> childs = adjList.getOrDefault(node, new ArrayList<Integer>());
        for(int i=0; i< childs.size(); i++){
            Integer child = childs.get(i);
            if(color.get(child) == WHITE){
                dfs(child, color);
            }else if(color.get(child) == GREY){ // cycle exist(came back to same node)
                isPossible = false;
                return;
            }
        }
        color.put(node, BLACK); // explored
        stack.push(node);
    }
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
    	
        for(int i=0; i< prerequisites.length; i++){
        	List<Integer> list = adjList.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            list.add(prerequisites[i][0]);
            adjList.put(prerequisites[i][1], list);
        }
        for(int i=0; i< numCourses; i++){
            color.put(i, WHITE);
        }
        for(int i=0; i< numCourses; i++){
            if(color.get(i) == WHITE){
                dfs(i, color);
            }
        }
                
        int[] res = new int[numCourses];
        if(isPossible){
            int k=0;
            while(!stack.isEmpty()){
                res[k++] = stack.pop();
            }
        }
        return res;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses1 = 2; 
		//int[][] prerequisites1 = {{1,0}};
		
		int[][] prerequisites1 = {{0,1}};
		findOrder(numCourses1, prerequisites1 );
		
		int numCourses = 4; 
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		findOrder(numCourses, prerequisites );
		
	}
}

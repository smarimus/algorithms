package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidTree_261 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		
		int[][] edges2 = { { 2, 3 }, { 1, 2 }, { 1, 3 } };

		System.out.println(validTree(4, edges));
		
		Deque<Integer> que = new ArrayDeque<>();
		
		System.out.println("substring");
		System.out.println(("".substring("".length(), "".length())).length());
		
		String s ="sud";
		for(int i=0; i<= s.length(); i++){
			System.out.println("string: " + s.substring(i, s.length()));
		}
		
		List<String> wordDict = new ArrayList<>();
		wordDict.add("a");
		wordDict.add("aa");
		//wordDict.add("b");
		
		wordDict.remove(wordDict.size()-1);
		
		//System.out.println(wordBreak("aaab", wordDict));

	}

	public static boolean validTree(int n, int[][] edges) {
		if (edges.length != n - 1) return false;
        
		List<ArrayList<Integer>> nodes = new ArrayList<>(n-1);
		for (int i = 0; i < n; i++) {
			nodes.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			nodes.get(edges[i][0]).add(edges[i][1]);
			nodes.get(edges[i][1]).add(edges[i][0]);
		}

		Set<Integer> visited = new HashSet<>();
		return dfs1(visited, nodes, 0, -1) && visited.size() == n ;
	}
	
	public static boolean dfs1(Set<Integer> seen, List<ArrayList<Integer>> nodes, int node, int parent) {
        if (seen.contains(node)) return false;
        seen.add(node);
        for (int neighbour : nodes.get(node)) {
            if (parent != neighbour) {
                boolean result = dfs1(seen, nodes, neighbour, node);
                if (!result) {
                    System.out.println("hi" +result);
                    return false;
                }
            }
        }
        return true;
    }

	public static boolean dfs(Set<Integer> visited, List<ArrayList<Integer>> nodes, int node, int parent) {		
		visited.add(node);
		for (Integer child : nodes.get(node)) {
			if (!visited.contains(child)) {
				return dfs(visited, nodes, child, node);
			} else {
				if (child != parent)
					return false;
			}
		}
		return true;
	}
	
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> result = new ArrayList<String>();
        List<String> temp = new ArrayList<String>();
        wordBreak(s, new HashSet<>(wordDict), 0, result, temp);
        return result;
    }
    
    private void wordBreak(String s, Set<String> wordDict, int start, 
            List<String> results, List<String> temp) {
        if (start == s.length()) {
            String result = temp.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));
            results.add(result);
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) ) {
                temp.add(s.substring(start, end));
                wordBreak(s, wordDict, end, results, temp);
                temp.remove(temp.size()-1);
            }
        }
        //return memo[start] = false;
    }
}

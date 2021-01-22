package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		// course -> list of next courses
		HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

		// build the graph first
		for (int[] relation : prerequisites) {
			// relation[0] depends on relation[1]
			if (courseDict.containsKey(relation[1])) {
				courseDict.get(relation[1]).add(relation[0]);
			} else {
				List<Integer> nextCourses = new LinkedList<>();
				nextCourses.add(relation[0]);
				courseDict.put(relation[1], nextCourses);
			}
		}

		boolean[] checked = new boolean[numCourses];
		boolean[] path = new boolean[numCourses];

		for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
			if (this.isCyclic(currCourse, courseDict, checked, path))
				return false;
		}

		return true;
	}

	/*
	 * postorder DFS check that no cycle would be formed starting from
	 * currCourse
	 */
	protected boolean isCyclic(Integer currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] checked,
			boolean[] path) {

		// bottom cases
		if (checked[currCourse])
			// this node has been checked, no cycle would be formed with this
			// node.
			return false;
		if (path[currCourse])
			// come across a previously visited node, i.e. detect the cycle
			return true;

		// no following courses, no loop.
		if (!courseDict.containsKey(currCourse))
			return false;

		// before backtracking, mark the node in the path
		path[currCourse] = true;

		boolean ret = false;
		// postorder DFS, to visit all its children first.
		for (Integer child : courseDict.get(currCourse)) {
			ret = this.isCyclic(child, courseDict, checked, path);
			if (ret)
				break;
		}

		// after the visits of children, we come back to process the node itself
		// remove the node from the path
		path[currCourse] = false;

		// Now that we've visited the nodes in the downstream,
		// we complete the check of this node.
		checked[currCourse] = true;
		return ret;
	}
	
	class GNode {
		  public Integer inDegrees = 0;
		  public List<Integer> outNodes = new LinkedList<Integer>();
		}
	
	public boolean canFinish1(int numCourses, int[][] prerequisites) {

	    if (prerequisites.length == 0)
	      return true; // no cycle could be formed in empty graph.

	    // course -> list of next courses
	    HashMap<Integer, GNode> graph = new HashMap<>();

	    // build the graph first
	    for (int[] relation : prerequisites) {
	      // relation[1] -> relation[0]
	      GNode prevCourse = this.getCreateGNode(graph, relation[1]);
	      GNode nextCourse = this.getCreateGNode(graph, relation[0]);

	      prevCourse.outNodes.add(relation[0]);
	      nextCourse.inDegrees += 1;
	    }

	    // We start from courses that have no prerequisites.
	    int totalDeps = prerequisites.length;
	    LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
	    for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
	      GNode node = entry.getValue();
	      if (node.inDegrees == 0)
	        nodepCourses.add(entry.getKey());
	    }

	    int removedEdges = 0;
	    while (nodepCourses.size() > 0) {
	      Integer course = nodepCourses.pop();

	      for (Integer nextCourse : graph.get(course).outNodes) {
	        GNode childNode = graph.get(nextCourse);
	        childNode.inDegrees -= 1;
	        removedEdges += 1;
	        if (childNode.inDegrees == 0)
	          nodepCourses.add(nextCourse);
	      }
	    }

	    if (removedEdges != totalDeps)
	      // if there are still some edges left, then there exist some cycles
	      // Due to the dead-lock (dependencies), we cannot remove the cyclic edges
	      return false;
	    else
	      return true;
	  }

	  /**
	   * Retrieve the existing <key, value> from graph, otherwise create a new one.
	   */
	  protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
	    GNode node = null;
	    if (graph.containsKey(course)) {
	      node = graph.get(course);
	    } else {
	      node = new GNode();
	      graph.put(course, node);
	    }
	    return node;
	  }

}

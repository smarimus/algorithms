package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands_200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		char[][] grid1 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '1', '0', '0', '1', '1' } };
		char[][] grid2 = {};

		// System.out.println(grid[0][0]);
		System.out.println(numIslands(grid));
		;
		System.out.println(numIslands(grid1));
		System.out.println(numIslands(grid2));

	}

	public static int numIslands(char[][] grid) {
		if (grid == null)
			return 0;
		if (grid.length == 0 || grid[0] == null)
			return 0;

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == '1' && visited[i][j] == false) {
					count++;
					bfs(grid, visited, i, j);
					// DFS1(grid, visited, i, j);
					// dfsIterative(grid, visited, i, j);
				}
			}
		}
		return count;
	}

	public static void bfs(char[][] grid, boolean[][] visited, int i, int j) {

		Deque<Pair> deque = new ArrayDeque<>();
		deque.add(new Pair(i, j));
		visited[i][j] = true;

		while (!deque.isEmpty()) {
			Pair c = deque.poll();

			if (grid[c.i][c.j] == '0') {
				System.out.println(grid[c.i][c.j]);
				continue;
			}

			if (c.i + 1 < grid.length && grid[c.i + 1][c.j] == '1' && visited[c.i + 1][c.j] == false) {
				deque.add(new Pair(c.i + 1, c.j));
				visited[c.i + 1][c.j] = true;
				// System.out.println(c.i + 1 +", " + c.j);
			}
			if (c.j + 1 < grid[0].length && grid[c.i][c.j + 1] == '1' && visited[c.i][c.j + 1] == false) {
				deque.add(new Pair(c.i, c.j + 1));
				visited[c.i][c.j + 1] = true;
			}
			if (c.i - 1 >= 0 && grid[c.i - 1][c.j] == '1' && visited[c.i - 1][c.j] == false) {
				deque.add(new Pair(c.i - 1, c.j));
				visited[c.i - 1][c.j] = true;
			}
			if (c.j - 1 >= 0 && grid[c.i][c.j - 1] == '1' && visited[c.i][c.j - 1] == false) {
				deque.add(new Pair(c.i, c.j - 1));
				visited[c.i][c.j - 1] = true;
			}
		}
	}

	public static void dfsIterative(char[][] grid, boolean[][] visited, int i, int j) {

		Deque<Pair> deque = new ArrayDeque<>();
		deque.push(new Pair(i, j));
		visited[i][j] = true;

		while (!deque.isEmpty()) {
			Pair c = deque.pop();

			if (grid[c.i][c.j] == '0') {
				System.out.println(grid[c.i][c.j]);
				continue;
			}

			if (c.i + 1 < grid.length && grid[c.i + 1][c.j] == '1' && visited[c.i + 1][c.j] == false) {
				deque.push(new Pair(c.i + 1, c.j));
				visited[c.i + 1][c.j] = true;
				// System.out.println(c.i + 1 +", " + c.j);
			}
			if (c.j + 1 < grid[0].length && grid[c.i][c.j + 1] == '1' && visited[c.i][c.j + 1] == false) {
				deque.push(new Pair(c.i, c.j + 1));
				visited[c.i][c.j + 1] = true;
			}
			if (c.i - 1 >= 0 && grid[c.i - 1][c.j] == '1' && visited[c.i - 1][c.j] == false) {
				deque.push(new Pair(c.i - 1, c.j));
				visited[c.i - 1][c.j] = true;
			}
			if (c.j - 1 >= 0 && grid[c.i][c.j - 1] == '1' && visited[c.i][c.j - 1] == false) {
				deque.push(new Pair(c.i, c.j - 1));
				visited[c.i][c.j - 1] = true;
			}
		}
	}

	static class Pair {
		int i, j;

		Pair() {
		}

		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void DFS1(char[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true) {
			return;
		}

		visited[i][j] = true;
		if (grid[i][j] == '0') {
			return;
		}

		DFS1(grid, visited, i + 1, j);
		DFS1(grid, visited, i - 1, j);
		DFS1(grid, visited, i, j - 1);
		DFS1(grid, visited, i, j + 1);
	}

}
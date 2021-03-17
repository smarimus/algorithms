package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class OrangesRotting_994 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		int[][] grid1 = {{2,1,1},{0,1,1},{1,0,1}};
		int[][] grid2 = {{1}};
		int[][] grid3 = {{1}, {0}};
		int[][] grid4 = {{0,1}};
		int[][] grid5 = {{1}, {2}};
		int[][] grid6 = {{1,2,2}};
		int[][] grid7 = {{1},{2}, {2}};
	
		
		
		//System.out.println(orangesRotting(grid7));;
		System.out.println(orangesRotting1(grid1));;
		
	}

	public static int  orangesRotting(int[][] grid) {
		int res =0;
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		Result result = new Result();
		
		for (int i = 0; i < grid.length; i++) {//row
			for (int j = 0; j < grid[0].length; j++) { //col
				if(visited[i][j] != true && grid[i][j] == 1){
					
					if(grid.length == 1 && grid[0].length == 1)
						return -1;
					
					//check if it's surrounded by 0
					if(surroundBy0(grid, i, j)){
						return -1;
					}
				}
			}
		}
		
		Pair p = null;
		outerloop:
		for (int i = 0; i < grid.length; i++) {//row
			for (int j = 0; j < grid[0].length; j++) { //col
				if(visited[i][j] != true && grid[i][j] == 2){
					p=new Pair(i,j);
					break outerloop;
				}
			}
		}
		if(p != null){
			return bfs(grid, visited, p.row, p.col, result);
		}
		
		return res;
	}
	
	public static int bfs(int[][] grid, boolean[][] visited, int i, int j, Result result){
		
		Deque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(i,j));
		visited[i][j] = true;
		
		while(!q.isEmpty()){
			Pair cur = q.poll();
			
			if(grid[cur.row][cur.col] == 0)
				continue;
			
			int count=0;
			int nextRow = cur.row+1;
			int preRow = cur.row-1;
			int nextCol = cur.col+1;
			int preCol = cur.col-1;

			if(nextCol < grid[0].length && grid[cur.row][nextCol] != 2 && grid[cur.row][nextCol] != 0 && visited[cur.row][nextCol] != true){
				q.add(new Pair(cur.row, nextCol));
				visited[cur.row][nextCol] = true;
				System.out.println(cur.row + "," + nextCol);
				count++;
			}
			if(preCol >= 0 && grid[cur.row][preCol] != 2 && grid[cur.row][preCol] != 0 && visited[cur.row][preCol] != true){
				q.add(new Pair(cur.row, preCol));
				visited[cur.row][preCol] = true;
				System.out.println(cur.row + "," + preCol);
				count++;
			}
			
			if(nextRow < grid.length && grid[nextRow][cur.col] != 2 && grid[nextRow][cur.col] != 0 && visited[nextRow][cur.col] != true){
				q.add(new Pair(nextRow,cur.col));
				visited[nextRow][cur.col] = true;
				System.out.println(nextRow + "," + cur.col);
				count++;
			}
			if(preRow >= 0 && grid[preRow][cur.col] != 2 && grid[preRow][cur.col] != 0 && visited[preRow][cur.col] != true){
				q.add(new Pair(preRow, cur.col));
				visited[preRow][cur.col] = true;
				System.out.println(preRow + "," + cur.col);
				count++;
			}
			
			if(count >0){
				result.res++;
			}	
			count=0;
			System.out.println();
		}
		return result.res;
	}
	
	public static boolean surroundBy0(int grid[][], int row, int col){
		int count=0;
		int nextRow = row+1;
		int preRow = row-1;
		int nextCol = col+1;
		int preCol = col-1;
		if(nextRow < grid.length && grid[nextRow][col] == 0){
			count++;
		}
		if(preRow >= 0 && grid[preRow][col] == 0){
			count++;
		}
		if(nextCol < grid[0].length && grid[row][nextCol] == 0){
			count++;
		}
		if(preCol >= 0 && grid[row][preCol] == 0){
			count++;
		}
		
		if(count >=2)
			return true;
		
		if((grid[0].length == 1 ||  grid.length ==1) && count >=1)
			return true;
	
		return false;
	}
	
	static class Pair{
		int row;	
		int col;
		Pair(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	static class Result{
		int res=0;
	}
	
	
	public static int orangesRotting1(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if (grid[r][c] == 2)
                    queue.offer(new Pair(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.offer(new Pair(-1, -1));

        // Step 2). start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty())
                    queue.offer(new Pair(-1, -1));
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS && 
                        neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        return freshOranges == 0 ? minutesElapsed : -1;
    }
	
}
package com.ik.graph.part2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ik.graph.session.KnightTour.Node;

public class TwoDimShorestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] maze = {{".",".",".","B"},
				{".","b","#","."},
				{"@","#","+","."}};
		
		Cell start = new Cell(2,0);
		Cell end = new Cell(2,2);
		Map<Cell, Cell> backRef = new HashMap<>();
		find_shortest_path(maze, start, end, backRef);
		printPath(backRef, start, end);
	}
	
	static void find_shortest_path(String[][] grid, Cell start, Cell end, Map<Cell, Cell> backRef ) {
		
		int x1[] = {-1,0,1,0};
		int y1[] = {0,1,0,-1};
		
		Cell found;
		Set<Cell> set = new HashSet<Cell>();
		Deque<Cell> queue = new ArrayDeque<>();
		
		queue.addLast(start);
		
		while(!queue.isEmpty()){
			Cell cell = queue.removeFirst();
			
			if(!set.contains(cell))set.add(cell);
			else continue;
			
			if(cell.x == end.x && cell.y == end.y ) {found=cell;
			backRef.put(end, cell);
			break;}
			
			for(int i=0; i<4; i++){
				int x = (cell.x + x1[i]); int y = (cell.y + y1[i]);
				if(isValid(x, y, 2, 3)){
					String gridVal = grid[x][y];
					if(isValidMove(x, y, gridVal)){
						Cell newCell = new Cell(x,y);
						queue.addLast(newCell);
						backRef.put(newCell, cell);
					}
				}
			}
		}		
    }
	
	static void printPath(Map<Cell, Cell> backRef, Cell src, Cell dest){
		List<Cell> path = new ArrayList<Cell>(); 
		Cell ref = backRef.get(dest);
		//path.add(src);
		while(ref != null){
			path.add(ref);
			ref = backRef.get(ref);
		}
		Collections.reverse(path);
		
		for (Cell cell : path) {
			System.out.println(cell.x + "," + cell.y);
		}		
	}
	
	static boolean isValid(int x, int y, int n, int m){
		if( (x >= 0 && x <= n) && (y >=0 && y<=m)){
			return true;
		}
		return false;
	}
	
	static boolean isValidMove(int x, int y, String gridVal){
		String water ="#";
		if(water.equals(gridVal)){
			return false;
		}
		return true;
	}
	
	public final static class Cell{
		int x;
		int y;
		int count;
		
		public Cell(int x, int y){
			this.x = x;
			this.y = y;
		}
		public Cell(int x, int y, int count){
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
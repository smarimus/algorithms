package com.ik.recursion.part1;

import java.util.List;

public class NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> solveNQueens(int n) {
		
		return null;
	}
	
	public static boolean solve(int n, int rows, Position[] position){
		
		if(n == rows){
			return true;
		}
		
		boolean isSafe = false;
		for(int col=0; col<rows; col++){
			
			//check is valid placement
			
			if(isSafe){
				// record the position
				position[rows] = new Position(rows, col);
				boolean result = solve(n, rows+1, position);
				if(result){
					return true;
				}
			}
		}
		return false;
	}
	
	static class Position{
		int row;
		int col;
		Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
	}
}

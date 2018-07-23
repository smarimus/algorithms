package com.ik.dp.part1;

public class CountStairWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSteps(8, 4));
	}
	
	
	public static int countSteps(int n, int steps){
		if(n == 0)
			return 1;
		if(n <0 )
			return -1;
		
		int results = 0;
		for (int i = 1; i <= steps; i++) {
			int result = countSteps(n-i, steps);
			if(result > 0)
				results = results + result;
		}
		return results;
	}
}
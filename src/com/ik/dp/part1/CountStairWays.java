package com.ik.dp.part1;

public class CountStairWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSteps(5, 3));
		System.out.println(countStepsDP(5+1, 3));
	}
	
	public static int countSteps(int n, int steps){
		if(n == 0)
			return 1;
		if(n < 0 )
			return -1;
		
		int results = 0;
		for (int i = 1; i <= steps; i++) {
			int result = countSteps(n-i, steps);
			if(result > 0)
				results = results + result;
		}
		return results;
	}
	
	public static int countStepsDP(int n, int steps) {
		
		int res[] = new int[n];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n; i++) {
			res[i] = 0;
			System.out.println("i: " + i + " res: " + res[i]);
			for (int j = 1; j <= steps && j <= i; j++){
				res[i] += res[i - j];
				System.out.println("		j: " + j + " res: " + res[i - j] );
			}
		}
		return res[n - 1];
	}

}
package com.ik.dp.part1;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int coinChangeB(int[] a, int index, int k){
		//base case
		if(k == 0)
			return 1;
		if(k < 0)
			return 0;
		
		if(index > a.length) return 0 ;
		
		return Integer.min(coinChange(a, index, k-a[index]), coinChange(a, index+1, k-a[index]));
	}
	
	public static int coinChange(int[] a, int index, int k){
		//base case
		if(k == 0)
			return 1;
		if(k < 0)
			return 0;
		
		if(index > a.length) return 0;
		
		return Integer.min(coinChange(a, index, k-a[index]), coinChange(a, index+1, k-a[index]));
	}
	
	// D 12 C = {13} 
	
	public static int coinChage(int[] a, int k){
		return coinChange(a, 0, k);
	}

}

package com.ik.dp.part1;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] d = {2, 9, 13};
		System.out.println(coinChangeB(20, d));*/
		
		int[] d = {3, 3,  2};
		System.out.println(coinChangeB(6, d));
	}
	
	public static int coinChangeB(int k, int[] d){
		//base case
		if(k == 0)
			return 0;
		
		int result=Integer.MAX_VALUE;
		for(int i=0; i < d.length; i++){
			
			if(d[i] <= k){
				int subRes = coinChangeB((k - d[i]) , d);
				if(subRes != Integer.MAX_VALUE){
					result = Math.min(result, subRes) + 1;
				}
			}
		}
		return result ;
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

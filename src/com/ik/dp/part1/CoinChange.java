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
	
	public static int cointChangeDP(int sum, int[] coin){
		int[] cache = new int[sum+1];
		
		for (int i = 1; i < sum; i++) {
			cache[i] = Integer.MAX_VALUE;	
		}
		
		int result = Integer.MAX_VALUE;
		
		// Iterate the sum value
		for (int i = 1; i < sum; i++) {
			
			// Iterate the coins
			for (int j = 0; j < coin.length; j++) {
				if(coin[j] >= i){
					cache[i] = Math.min(cache[i], cache[i-coin[j]] +  1);	
				}
			}
		}
		return cache[sum];
	}
	
	public static int cointChangeDP1(int sum, int[] coin){
		int[] cache = new int[sum+1];
		
		int result = Integer.MAX_VALUE;
		
		// Iterate the sum value
		for (int i = 1; i < sum; i++) {
			
			// Iterate the coins
			for (int j = 0; j < coin.length; j++) {
				if(coin[j] >= i){
					result = Math.min(result , cache[i-coin[j]] +  1);	
				}
			}
			cache[i] = result;
		}
		
		return cache[sum];
	}
	
	// Bottom up dynamic programming solution. 
	// Iteratively compute number of coins for 
	// larger and larger amounts of change 
	
	public int makeChange(int c, int[] coins) {
		
		int[] cache = new int[c + 1];
		for (int i = 1; i <= c; i++) {
			int minCoins = Integer.MAX_VALUE;
			// Try removing each coin from the total
			// and see which requires the fewest
			// extra coins
			for (int coin : coins) {
				if (i - coin >= 0) {
					int currCoins = cache[i-coin] + 1;
					if (currCoins < minCoins) {
						minCoins = currCoins;
					}
				}
			}
			cache[i] = minCoins;
		}
		return cache[c];
	}
	
}
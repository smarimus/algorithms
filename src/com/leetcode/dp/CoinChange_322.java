package com.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange_322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] coins = {1,2,5};
		//int[] coins = {3,2};
		//int[] cache = new int[16];
		//System.out.println(coinChange(coins, 11));
		
		System.out.println(helperDP(coins, 11));

	}
	
	public static int coinChange(int[] coins, int amount ) {
		Map<String, Integer> cache = new HashMap<>();
		return helper(coins, amount, cache, 0);
    }
    
	public static int helper(int[] coins, int amount, Map<String, Integer> cache, int counter ){
    	String key = amount + "";
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(cache.containsKey(key)){
        	return cache.get(key);
        }

        int min=Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
    		int res = helper(coins, amount - coins[i], cache, counter+1);
    		if(res >=0){
    			min = Math.min(res+1, min);
    		}
        }
        int val = (min == Integer.MAX_VALUE) ? -1 : min;
        cache.put(key, val);
        return val;
    }
    
    public static int helperDP(int[] coins, int amount){
    	int dp[] = new int[amount+1];
    	Arrays.fill(dp, amount+1);
    	dp[0] = 0;
    	
    	for(int i=1; i<=amount; i++){
    		for(int j=0; j< coins.length; j++){
    			
    			if(coins[j] <= i){
    				dp[i] = Math.min(dp[i], dp[i- coins[j]]+1);
    			}
    		}
    	}
    	return (dp[amount] == amount) ? -1 : dp[amount];
    }

}
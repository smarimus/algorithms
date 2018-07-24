package com.ik.dp.session.part1;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item[] items = {
			new Item(10, 1),
			new Item(20, 1),
			new Item(2, 6),	
			new Item(2, 10),	
			new Item(3, 12)
		};
		
		System.out.println(knapsack(items, 5));
		System.out.println(knapsackDP(items, 5));
	}
	
	public static class Item {
		int weight;
		int value;
		Item(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
	}
	
	// Naive brute force solution. Recursively // include or exclude each item
	// to try every // possible combination
	public static int knapsack(Item[] items, int W) {
		return knapsack(items, W, 0);
	}
	
	// Overloaded recursive function
	public static int knapsack(Item[] items, int W, int i) {
		System.out.println(W + ", " + i);
		
		// If we've gone through all the items, // return
		if (i == items.length)
			return 0;
		// If the item is too big to ll the
		// remaining space, skip it
		if (W - items[i].weight < 0)
			return knapsack(items, W, i + 1);
		// Find the maximum of including and not // including the current item
		int val1 = knapsack(items, W - items[i].weight, i + 1) + items[i].value;
		int val2 = knapsack(items, W, i + 1);
		///System.out.println(val1 + " " + val2);
		
		int result = Math.max(val1, val2);
		return result;
	}
	
	// Iterative bottom up solution.
	public static int knapsackDP(Item[] items, int W) {
		// Initialize cache
		int[][] cache = new int[items.length + 1][W + 1];
		// For each item and weight, compute the max
		// value of the items up to that item that
		// doesn't go over W weight
		for (int i = 1; i <= items.length; i++) {
			for (int j = 0; j <= W; j++) {
				if (items[i - 1].weight > j) {
					cache[i][j] = cache[i - 1][j];
				} else {
					cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - items[i - 1].weight] + items[i - 1].value);
				}
			}
		}
		return cache[items.length][W];
	}
	/*
	 	 0	1	2	3	4	5

		[0, 0, 0,   0,  0,  0], 
(6)2	[0, 0, 6,   6,  6,  6], 
(10)2	[0, 0, 10,  10, 16, 16],
(12)3	[0, 0, 10,  12, 16, 22]]

22 = max(16 (not including), 10+12 (including))

	
	/*
	 * It is now easy to reason through how to solve our problem iteratively (
	 * g. 20). 
	 * 
	 * For any pair where i or W is 0, we get a max value of 0, because
	 * if i == 0 there are no items included. If W == 0, then no items may be
	 * included, because they will overflow the capacity. 
	 * 
	 * When i and W do not
	 * equal 0, we can determine our solution by looking at the previously
	 * computed subproblems. i tells us which item to consider and W tells us
	 * the remaining weight that we have available to us. For each cell, we need
	 * to decide whether we get a greater value at that weight by including or
	 * excluding item i - 1. 
	 * 
	 * We can get the value of not including the item by
	 * looking at the solution for W = W and i = i - 1, since the value is the same
	 * as it was before. We can get the value of including the item by looking
	 * at the max value we could get for W = W - item.weight. 
	 * 
	 * This tells us the
	 * maximum value for the first i items, while still leaving sufficient empty
	 * space to include the current item. 
	 * 
	 * This solution will be O(n * W) for
	 * both space and time complexity, which is identical in space and time
	 * complexity to our previous solution. We create an nxW array and iterate
	 * over the entire array.
	 * 
	 * 
	 * maxEndingHere = 0;
	 * maxSoFar=3;
	 * 
	 * 0+1 = 1
	 * 1+-2 = -1 
	 * 0+2 = 2
	 * 2+1 = 3
	 * 3+-1 = 2 
	 * 
	 * 
	 */
	
}
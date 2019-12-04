package com.data.divideAndConquer;

public class ZeroOneKnapsack {
	
	public static void main(String args[]) {
		int profits[] = {31,26,72,17};
		int weights[] = {3,1,5,2};          
		int capacity =7;
		
		System.out.println(findMaxProfit(profits,weights,capacity,0));
	}

	private static int findMaxProfit(int[] profits, int[] weights, int capacity, int i) {
		// TODO Auto-generated method stub
		if(capacity <= 0 || i > profits.length-1)
			return 0;
		int profit1 = 0;
		if(weights[i]<=capacity) 
		 profit1 = profits[i] + findMaxProfit(profits,weights,capacity-weights[i],i+1);
		int profit2 = findMaxProfit(profits,weights,capacity,i+1);
		
		return Math.max(profit1,profit2);
		
	}

}

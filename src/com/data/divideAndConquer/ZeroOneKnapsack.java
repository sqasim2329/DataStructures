package com.data.divideAndConquer;

public class ZeroOneKnapsack {
	
	public static void main(String args[]) {
		int profits[] = {31,26,72,17};
		int weights[] = {3,1,5,2};          
		int capacity =7;
		
		System.out.println(findMaxProfit(profits,weights,capacity,0));
		System.out.println(findMaxProfitDP(profits,weights,capacity));
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
	
	private static int findMaxProfitDP(int[] profits, int[] weights, int capacity) {
		int[][] dp = new int[weights.length+1][capacity+1];
		for(int i=1;i<=weights.length;i++) {
			for(int j=1;j<=capacity;j++) {
				if(weights[i-1]<=j) {
					dp[i][j]=Math.max(dp[i-1][j-weights[i-1]]+profits[i-1], dp[i-1][j]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[weights.length][capacity];
	}

}

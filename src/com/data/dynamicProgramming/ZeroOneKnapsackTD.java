package com.data.dynamicProgramming;

public class ZeroOneKnapsackTD {
	
	public static void main(String args[]) {
		int profits[] = {31,26,72,17};
		int weights[] = {3,1,5,2};
		int capacity =7;
		Integer dp[][] = new Integer[profits.length][capacity+1];
		
		System.out.println(findMaxProfit(dp,profits,weights,capacity,0));
	}

	private static int findMaxProfit(Integer [][] dp, int[] profits, int[] weights, int capacity, int i) {
		// TODO Auto-generated method stub
		if(i > profits.length-1 || capacity <=0) {
			return 0;
		}
		
		if(dp[i][capacity]==null) {
		int profit1 = 0;
		if(capacity >= weights[i])
			profit1 = profits[i]+findMaxProfit(dp,profits,weights,capacity-weights[i],i+1);
		int profit2 = findMaxProfit(dp,profits,weights,capacity,i+1);
		dp[i][capacity] = Math.max(profit1, profit2);
		}
		
		return dp[i][capacity];
			
	}

}

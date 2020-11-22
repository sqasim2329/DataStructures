package com.data.dynamicProgramming;

public class ZeroOneKnapsackBU {
	
	public static void main(String args[]) {
		int profits[] = {31,26,72,17};
		int weights[] = {3,1,5,2};
		int capacity =7;
		
		System.out.println(solve(profits,weights,capacity));
	}

	private static int findMaxProfit(int[] profits, int[] weights, int capacity) {
		// TODO Auto-generated method stub
		if(capacity <= 0) {
			return 0;
		}
		Integer dp[][] = new Integer[profits.length+1][capacity+1];
		
		for (int i = 0; i < profits.length+1; i++) { // Insert 0 in 1st column as it is dummy column to avoid array index issues
			dp[i][0] = 0;
		}
		
		for (int i = 0; i <= capacity; i++) {// Insert 0 in last row as it is dummy column to avoid array index issues
			dp[profits.length][i] = 0;
		}

		
		for(int i =profits.length-1; i >=0 ; i-- ) {
			for(int j = 1; j <= capacity; j++) {
				int profit1=0, profit2=0;
				if(weights[i]<=j)
				 profit1= profits[i] + dp[i+1][j-weights[i]];
				 profit2= dp[i+1][j];
				 dp[i][j] = Math.max(profit1,profit2);
			}
		}
		return dp[0][capacity];
	}
	
	private static int solve(int []profits,int weights[],int capacity) {
		int dp[][]= new int[weights.length+1][capacity+1];
		for(int i=1;i<=weights.length;i++) {
			for(int j=1;j<=capacity;j++) {
				if(j >= weights[i-1]) {
					dp[i][j]=Math.max(dp[i-1][j], profits[i-1]+dp[i-1][j-weights[i-1]]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[weights.length][capacity];
		
	}

}

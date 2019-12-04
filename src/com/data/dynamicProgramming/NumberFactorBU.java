package com.data.dynamicProgramming;

public class NumberFactorBU {
	public static void main(String args[]) {
		int n = 8 ;
		System.out.println(waysToGetN(n));
	}

	private static int waysToGetN(int n) {
		// TODO Auto-generated method stub
		int dp[] = new int[n+1];
			dp[0]=dp[1]=dp[2]=1;	
			dp[3] = 2;
		
		
		for(int i = 4; i<= n; i++) {
			dp[i] = dp[i-1]+dp[i-3]+dp[i-4];
		}
		
		return dp[n];
	}

}

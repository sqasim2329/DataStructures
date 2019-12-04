package com.data.dynamicProgramming;

public class NumberFactorTD {
	
	public static void main(String args[]) {
		int n = 8;
		int dp[] = new int[n+1];
		System.out.println(waysToGetN(dp,n));
	}

	private static int waysToGetN(int dp[],int n) {
		if(n < 0)
			return 0;
		if(n==0 || n==1 || n==2) {
			dp[0]=dp[1]=dp[2]=1;
			return dp[n];
		}
		if(dp[n]==0) {
		int x = waysToGetN(dp,n-1);
		int y = waysToGetN(dp,n-3);
		int z = waysToGetN(dp,n-4);
		dp[n] = x+y+z;
		}
		
		return dp[n];
		
		
	}

}

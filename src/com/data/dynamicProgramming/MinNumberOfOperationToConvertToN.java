package com.data.dynamicProgramming;

import java.util.Arrays;

// +1 ,*2, *3
public class MinNumberOfOperationToConvertToN {
	
	public static int solve(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE/10);
		dp[0]=0;
		dp[1]=0;// need to achive 1 from n 
		
		for(int i=2;i<=n;i++) {
			if(i%2==0) {
				int x = dp[i/2];//dp -> min operations to obtains i/2
				dp[i] = Math.min(x+1, dp[i]);
			}
			
			if(i%3==0) {
				int x = dp[i/3];//dp -> min operations to obtains i/2
				dp[i] = Math.min(x+1, dp[i]);
			}
			
			
				int x = dp[i-1];//dp -> min operations to obtains i/2
				dp[i] = Math.min(x+1, dp[i]);
			
		}
		return dp[n];
		
	}
	
	public static void main(String args[]) {
		System.out.println(solve(5));
	}

}

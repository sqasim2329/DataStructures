package com.data.dynamicProgramming;

public class RodCutting {
	
	private static int solve(int n, int[] price) {
		int[][] dp = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i<=j) {
					dp[i][j] = Math.max(dp[i][j-i]+price[i-1],dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][n];
		
	}
	
	public static void main(String args[]) {
		int arr[] = new int[] {3  ,5 ,8  ,9 ,10 ,17 ,17 ,20}; 
        int size = arr.length; 
        System.out.println(solve(size,arr));
        
	}

}

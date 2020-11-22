package com.data.dynamicProgramming;

public class DicEThrow {
	
	public static void main(String args[]) {
		int m=6,n=3,x=12;
		System.out.println(solve(x,m,n));
	}

	private static int solve(int sum, int m, int n) {
		if(n==0 && sum==0)
			return 1;

			if(n==0)
			return 0;
			
			int x=0;

			for(int i=1;i<=m;i++) {
				if(sum >= i)
			x+=solve(sum-i,m,n-1);
			}
			return x;
		
	}
	
	private static int solveDP(int sum,int m, int n) {
		int dp[][]=new int[n+1][sum+1];
		dp[0][0]=1;
		for(int j=1;j<=sum;j++) {
			dp[0][j]=0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				for(int k=1;k<=m;k++) {
					if(j>=k)
					dp[i][j]+=dp[i-1][j-k];
				}
			}
		}
		return dp[n][sum];
	}
	
	

}

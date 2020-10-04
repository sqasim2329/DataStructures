package com.data.arrays;

public class RecursiveStairCase {
	
	public static void main(String args[]) {
		int m=2;// 1 step or 2 step or 3 steps at a time;
		int n = 4;
		
		System.out.println(countways(m,n));
		
	}

	private static int countways(int m, int n) {
		int dp[]=new int[n+1];//inclusive of nth step
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=0;
			for(int j=1;j<=m && j<=i;j++) {
				dp[i]+=dp[i-j];
			}
		}
		
		return dp[n];
		
	}

}

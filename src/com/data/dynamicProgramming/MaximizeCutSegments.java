package com.data.dynamicProgramming;

public class MaximizeCutSegments {
	
	public static void main(String args[]) {
		int N = 7;
		int nums[]= {2,5,5};
		
		System.out.println(backTrack(nums,N));
		System.out.println(solve(nums,N,0));
		System.out.println(solve(nums,N));
	}

	private static int backTrack(int[] nums, int n) {
			if(n < 0)
				return Integer.MIN_VALUE;
			
			if(n==0)
				return 0;
			
			int max = Integer.MIN_VALUE;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]<=n)
					max =  Math.max(max, 1+backTrack(nums,n-nums[i]));
			}
			
			return max;
	}
	
	private static int solve(int nums[], int n, int indx) {
		if(n < 0 || indx>=nums.length)
			return Integer.MIN_VALUE;
		
		
		if(n == 0)
			return 0;
		
		int x =Integer.MIN_VALUE;
		int y =Integer.MIN_VALUE;
		
		if(nums[indx] <=n)
			x = 1+solve(nums,n-nums[indx],indx);
		y = solve(nums,n,indx+1);
		return Math.max(x, y);
		
		
	}
	//wrong solution
	private static int solve(int nums[],int n) {
		int dp[][] = new int[nums.length+1][n+1];
		for(int i=0;i<=nums.length;i++)
			dp[i][0]=Integer.MIN_VALUE;
		
		for(int i=0;i<=n;i++)
			dp[0][i]=Integer.MIN_VALUE;
		
		for(int i =1;i<=nums.length;i++) {
			for(int j=1;j<=n;j++) {
				if(nums[i-1]<=j)
					dp[i][j]=Math.max(1+dp[i][j-nums[i-1]], dp[i-1][j]);
				else
					dp[i][j]=dp[i-1][j];
			}
		}
	
	return dp[nums.length][n];
		
	}

}

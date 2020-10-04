package com.data.dynamicProgramming;

public class MaxLengthChain {
	
	public static void main(String args[]) {
		int [][]nums= {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
		
		System.out.println(dp(nums));
	}

	private static int dp(int[][] nums) {
		int n = nums.length;
		int []dp= new int[n];
		for(int i=0;i<n;i++) {
			dp[i]=1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				
				if(nums[j][1] <= nums[i][0]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max =0;
		for(int i=0;i<n;i++) {
			max = Math.max(dp[i], max);
		}
		
		return max;
	}

}

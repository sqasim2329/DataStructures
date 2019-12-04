package com.data.dynamicProgramming;

public class MinCostToReachEndOf2DArr {
	public static void main(String args[]) {
	int arr[][]= {
			{ 4, 7, 8, 6, 4 },
			{ 6, 7, 3, 9, 2 },
			{ 3, 8, 1, 2, 4 },
			{ 7, 1, 7, 3, 7 },
			{ 2, 9, 8, 9, 3 }
		};
	int row = arr.length-1;
	int col = arr[0].length-1;
	System.out.println(findMinCost(arr));
	}

	private static int findMinCost(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] dp = new int[arr.length+1][arr[0].length+1];
		
		for(int i =1 ; i <= arr.length; i++)
			dp[i][0] = Integer.MAX_VALUE; // cannot store in dp[i][-1] array index exception
		for(int j=1; j <= arr[0].length; j+r+)
			dp[0][j] = Integer.MAX_VALUE;
		
		dp[0][1] = 0;
		for(int i =1 ; i <= arr.length; i++) {
			for(int j=1; j <= arr[0].length; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+arr[i-1][j-1];
				
			}
		}
		return dp[arr.length][arr[0].length];
		
	}
}

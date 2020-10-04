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
//horizontal,diagonally,vertically
	private static int findMinCost(int[][] nums) {
		int m= nums.length;
		int n= nums.length;
		int dp[][] = new int [m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 && j==0)
					dp[i][j]=nums[i][j];
				else if(i==0 && j> 0)
					dp[i][j]+=dp[i][j-1]+nums[i][j];
				else if(i>0 && j==0)
					dp[i][j]+=dp[i-1][j]+nums[i][j];
				else
					dp[i][j]=nums[i][j]+Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
				
			}
		}
		return dp[m-1][n-1];
		
		
	}
}


//check https://www.geeksforgeeks.org/min-cost-path-dp-6/ for different conditions

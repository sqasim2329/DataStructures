package com.data.divideAndConquer;

public class MinCostToReachEndOf2DArray {
	
	public static void main(String args[]) {
		
		int arr[][]= {
				{ 4, 7, 8, 6, 4 },
				{ 6, 7, 3, 9, 2 },
				{ 3, 8, 1, 2, 4 },
				{ 7, 1, 7, 3, 10 },
				{ 2, 9, 8, 9, 3 }
			};
		int row = arr.length-1;
		int col = arr[0].length-1;
		System.out.println(findMinCost(arr,row, col));
		System.out.println(findMinCost2(arr,row, col));
	}
//horizontally , vertically
	private static int findMinCost(int[][] arr, int i, int j) {
		if(i == -1 || j == -1)
			return Integer.MAX_VALUE;
		
		if(i== 0 && j == 0)
			return arr[i][j];
		
		int y = findMinCost(arr,i-1,j);
		int x = findMinCost(arr,i,j-1);
				
		int min = Integer.min(x, y);
		int currentCost =arr[i][j]; 
		
		return min+currentCost;
		
	}
	
	private static int findMinCost2(int[][] arr, int i, int j) {
		
		if(i== 0 && j == 0)
			return arr[i][j];
		
		if(i==0 && j > 0)
			return findMinCost(arr,0,j-1);
		
		if(i>0 && j == 0)
			return findMinCost(arr,i-1,0);
		
		int y = findMinCost(arr,i-1,j);
		int x = findMinCost(arr,i,j-1);
				
		int min = Integer.min(x, y);
		int currentCost =arr[i][j]; 
		
		return min+currentCost;
		
	}
	
	class Solution {
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	        int[][] dp = new int[m][n];
	        for(int[] d:dp )
	            Arrays.fill(d,-1);
	        return solve(m-1,n-1,obstacleGrid,dp);
	    }
	    
	    private int solve(int row,int col,int[][] grid,int[][] dp){
	        if(dp[row][col]!=-1)
	            return dp[row][col];
	        
	        if(grid[row][col]==1)
	            return 0;
	        
	        if(row ==0 && col == 0)
	            return 1;
	        
	        if(row == 0 && col > 0 )
	            return solve(0,col-1,grid,dp);
	        
	        if(row > 0 && col ==  0)
	            return solve(row-1,0,grid,dp);
	        
	        int x = solve(row-1,col,grid,dp);
	        int y = solve(row,col-1,grid,dp);
	        dp[row][col]=x+y;
	        return dp[row][col];
	    }
	}
	
	
	
	

}

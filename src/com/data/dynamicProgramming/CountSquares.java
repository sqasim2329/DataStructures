package com.data.dynamicProgramming;

public class CountSquares {
	
	class Solution {
	    public int countSquares(int[][] matrix) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        int[][] dp = new int[rows+1][cols+1];
	        int count =0;
	        for(int i=1;i<=rows;i++){
	            for(int j =1;j<=cols;j++){
	                if(matrix[i-1][j-1]==0)
	                dp[i][j] = 0;
	                else
	                dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
	                
	                count+=dp[i][j];
	            }
	        }
	        return count;
	    }
	}

}

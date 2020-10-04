package com.data.graphs;

import java.util.Arrays;

//use dp for perfromance
public class LongestIncresingPath {
	
	
	    public int longestIncreasingPath(int[][] matrix) {
	        int max = 0;
	        int row = matrix.length;
	        if(row == 0)
	            return 0;
	        int col = matrix[0].length;
	        int dp[][]=new int[row][col];
	        for(int[] i:dp)
	            Arrays.fill(i,-1);
	        for(int i=0;i<matrix.length;i++){
	            for(int j=0;j<matrix[i].length;j++){
	                if(dp[i][j]==-1)
	                dp[i][j]=backTrack(matrix,i,j,dp);
	                max = Math.max(dp[i][j],max);
	            }
	        }
	        return max+1;
	        
	    }
	    
	    
	    private int backTrack(int[][] arr,int row, int col, int[][] dp){
	        
	        if(dp[row][col]!=-1)
	            return dp[row][col];
	        
	        int n= arr.length;
	        int w=0,x=0,y=0,z=0;
	        if(isSafe(row+1,col,arr) && arr[row][col] > arr[row+1][col])
	            w =1+ backTrack(arr,row+1,col,dp);
	        
	        if(isSafe(row-1,col,arr) && arr[row][col] > arr[row-1][col])
	            x =1+ backTrack(arr,row-1,col,dp);
	        
	        if(isSafe(row,col+1,arr) && arr[row][col] > arr[row][col+1])
	            y=1+ backTrack(arr,row,col+1,dp);
	        
	        if(isSafe(row,col-1,arr) && arr[row][col] > arr[row][col-1])
	            z =1+ backTrack(arr,row,col-1,dp);
	        
	        return dp[row][col]= Math.max(w,Math.max(x,Math.max(y,z)));
	    }
	    
	    private boolean isSafe(int row, int col, int[][]arr){
	        return (row >=0 && col >= 0 && row < arr.length && col < arr[row].length);
	    }
	
	
	
	public static void main(String args[]) {
		int [][]nums = 
				{
				  {3,4,5},
				  {3,2,6},
				  {2,2,1}
	}; 
		
//		int [][]nums={
//		  {9,9,4},
//		  {6,6,8},
//		  {2,1,1}
//		}; 
		
//		int[][]nums= {
//				{1,2}
//		};
		LongestIncresingPath p=new LongestIncresingPath();
		System.out.println(p.longestIncreasingPath(nums));
		
	}

}

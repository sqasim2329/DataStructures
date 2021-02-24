package com.data.interviewBit;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
	
	class Solution {
	    public int numDistinctIslands(int[][] grid) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        Set<String> seen = new HashSet<>();
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                if(grid[i][j]==1){
	                    StringBuilder sb = new StringBuilder("O");
	                    dfs(i,j,grid,sb);
	                    System.out.println(sb.toString());
	                    seen.add(sb.toString());
	                }
	            }
	        }
	        return seen.size();
	    }
	    
	    
	    private void dfs(int row, int col, int[][] grid, StringBuilder sb){
	        if(row >= grid.length || row <0 || col >= grid[0].length || col < 0 || grid[row][col]==0)
	            return;
	        grid[row][col]=0;
	        dfs(row-1,col,grid,sb.append("U"));
	        dfs(row+1,col,grid,sb.append("D"));
	        dfs(row,col-1,grid,sb.append("L"));
	        dfs(row,col+1,grid,sb.append("R"));
	        
	    }
	}

	    
	    
	   

}

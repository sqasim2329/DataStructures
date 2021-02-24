package com.data.graphs;

public class NumberOfClosedIslands {
	
	class Solution {
	    
	    private  final int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
	    public int closedIsland(int[][] grid) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        for(int i=0;i<cols;i++){
	            if(grid[0][i]==0){
	                dfs(0,i,grid);
	            }
	            if(grid[rows-1][i]==0){
	                dfs(rows-1,i,grid);
	            }
	        }
	        
	        for(int i=0;i<rows;i++){
	            if(grid[i][0]==0){
	                dfs(i,0,grid);
	            }
	            if(grid[i][cols-1]==0){
	                dfs(i,cols-1,grid);
	            }
	        }
	        
	        int count =0;
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                if(grid[i][j]==0){
	                    dfs(i,j,grid);
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	    
	    private void dfs(int r, int c, int[][] grid){
	        grid[r][c]=-1;
	        for(int i=0;i<dir.length;i++){
	            int nr = r+dir[i][0];
	            int nc = c+dir[i][1];
	            if(isSafe(nr,nc,grid) && grid[nr][nc]==0)
	                dfs(nr,nc,grid);
	        }
	    }
	    
	    private boolean isSafe(int r, int c, int [][]grid){
	        return r>=0 && r<grid.length && c>=0 && c<grid[r].length;
	    }
	}

}

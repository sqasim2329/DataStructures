package com.data.graphs;

public class IslandPerimeter {
	
	class Solution {
	    public int islandPerimeter(int[][] grid) {
	        int total = 0;
	        for(int i=0;i<grid.length;i++){
	            for(int j =0;j<grid[i].length;j++){
	                if(grid[i][j]==1){
	                    total+=4;
	                    
	                    if(i>0 && grid[i-1][j]==1)
	                        total-=2;
	                    if(j>0 && grid[i][j-1]==1)
	                        total-=2;
	                }
	            }
	        }
	        
	        return total;
	        
	        
	    }

}

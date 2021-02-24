package com.data.google;

public class PathWithMaxGold {
	
	private int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    public int getMaximumGold(int[][] grid) {
        
        int max =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0){
                   int curr = dfs(i,j,grid); 
                    max = Math.max(curr,max);
                }
            }
        }
        return max;
    }
    
    private int dfs(int r, int c, int[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c]==0)
            return 0;
        
        int amount = grid[r][c];
        grid[r][c]=0;
        int max =0;
        for(int i=0;i<dir.length;i++){
            int curr = dfs(r+dir[i][0],c+dir[i][1],grid);
            max = Math.max(curr,max);
        }
        grid[r][c]=amount;
        return max+amount;
    }

}

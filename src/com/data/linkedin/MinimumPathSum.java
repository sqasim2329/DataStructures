package com.data.linkedin;

public class MinimumPathSum {
	
	class Solution {
	    
	    private static final int dir[][]={{-1,0},{0,-1}};
	    public int minPathSum(int[][] grid) {
	        
	        int rows = grid.length;
	        int cols = grid[0].length;
	        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
	        boolean[][] vis= new boolean[rows][cols];
	        q.add(new int[]{rows-1,cols-1,grid[rows-1][cols-1]});
	        vis[rows-1][cols-1]=true;
	        while(!q.isEmpty()){
	            int[] tmp = q.poll();
	            int row = tmp[0];
	            int col = tmp[1];
	            int cost = tmp[2];
	            if(row == 0 && col == 0)
	                return cost;
	            for(int i=0;i<dir.length;i++){
	                int nr = row+dir[i][0];
	                int nc = col+dir[i][1];
	                if(isSafe(nr,nc,grid) && !vis[nr][nc]){
	                    vis[nr][nc] = true;
	                    q.add(new int[]{nr,nc,cost+grid[nr][nc]});
	                }
	            }
	        }
	        
	        return -1;
	    }
	    
	    private boolean isSafe(int r, int c, int[][] grid){
	        return r >=0 && r<grid.length && c >=0 && c < grid[r].length;
	    }
	    
	    
	}

}

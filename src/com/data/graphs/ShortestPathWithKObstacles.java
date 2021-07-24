package com.data.graphs;
//working for 44 test cases failing for 2 more need to check later.
public class ShortestPathWithKObstacles {
	
	class Solution {
	    
	    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	    
	    public int shortestPath(int[][] grid, int k) {
	        int row = grid.length;
	        int col = grid[0].length;
	        boolean[][] vis = new boolean[row][col];
	        Queue<int[]> q = new LinkedList<>();
	        int shortestPath = 0;
	        q.add(new int[]{0,0,k});
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int j=0;j<size;j++){
	                int[] pos = q.poll();
	                if(pos[0]==row-1 && pos[1]==col-1)
	                    return shortestPath;
	                for(int i=0;i<dir.length;i++){
	                    int nx = pos[0]+dir[i][0];
	                    int ny = pos[1]+dir[i][1];
	                    
	                    if(isSafe(nx,ny,grid)&& !vis[nx][ny]){
	                        vis[nx][ny]=true;
	                        if(grid[nx][ny]==0 )
	                            q.add(new int[]{nx,ny,pos[2]});
	                         else if(grid[nx][ny]==1 && pos[2]>0)
	                            q.add(new int[]{nx,ny,pos[2]-1});
	                    }
	                }     
	            }
	            shortestPath++;
	            }
	        return -1;
	        }
	    
	    private boolean isSafe(int r, int c, int[][] grid){
	        return r>=0 && r< grid.length && c>=0 && c<grid[0].length;
	    }
	    }



}



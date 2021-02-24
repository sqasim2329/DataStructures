package com.data.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDsiatnceFromAllbuilding {
	
	class Solution {
	    public int shortestDistance(int[][] grid) {
	        int r = grid.length;
	        int c = grid[0].length;
	        int[][] distance = new int[r][c];// distance from all buildings
	        int[][] reached = new int[r][c];// number of building reached
	        int building=0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid.length;j++){
	                if(grid[i][j]==1){
	                        building++;
	                        bfs(i,j,distance,reached,grid);
	                }
	            }
	        }
	        
	        
	        int min = Integer.MAX_VALUE;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid.length;j++){
	                if(grid[i][j]==0 && reached[i][j]==building){
	                    min = Math.min(min,distance[i][j]);
	                }
	            }
	        }
	        
	        return min;
	    }
	    
	    private void bfs(int i, int j, int[][] distance,int[][] reached,int[][] grid){
	        Queue<int[]> q = new LinkedList<>();
	        boolean[][] visited = new boolean[grid.length][grid[0].length];
	        q.add(new int[]{i,j});
	        int dist = 1;
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int k=0;k<size;k++){
	                int[] b = q.poll();
	                int r =b[0];
	                int c =b[1];
	                visited[r][c]=true;
	                if(isSafe(r+1,c,grid) && grid[r+1][c]==0 && !visited[r+1][c]){
	                    distance[r+1][c]+=dist;
	                    reached[r+1][c]++;  
	                    q.add(new int[]{r+1,c});
	                }
	                if(isSafe(r-1,c,grid) && grid[r-1][c]==0 && !visited[r-1][c]){
	                    distance[r-1][c]+=dist;
	                    reached[r-1][c]++;                     
	                    q.add(new int[]{r-1,c});
	                }
	                if(isSafe(r,c+1,grid) && grid[r][c+1]==0 && !visited[r][c+1]){
	                    distance[r][c+1]+=dist;
	                    reached[r][c+1]++;
	                    q.add(new int[]{r,c+1});
	                }
	                if(isSafe(r,c-1,grid) && grid[r][c-1]==0 && !visited[r][c-1]){
	                    distance[r][c-1]+=dist;
	                    reached[r][c-1]++;
	                    q.add(new int[]{r,c-1});
	                }
	                
	            }
	               dist++; 
	            
	        }
	    }
	    
	    private boolean isSafe(int r, int c, int[][] grid){
	        return r>=0 && c>=0 && r < grid.length && c < grid[r].length ;
	    }
	}

}

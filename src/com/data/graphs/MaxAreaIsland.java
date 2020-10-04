package com.data.graphs;
//https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s/0
//https://leetcode.com/problems/max-area-of-island/ -- variation 
//https://practice.geeksforgeeks.org/problems/flood-fill-algorithm/0 -- similar
//https://practice.geeksforgeeks.org/problems/find-whether-path-exist/0--similar
//Google-or-Onsite-interview-or-Knight's-Shortest-Path-on-an-Infinite-Chessboard--https://ide.geeksforgeeks.org/STnkM6zJj7--to be done
//https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem/0 -- to be done -- https://leetcode.com/problems/snakes-and-ladders/discuss/173682/Java-concise-solution-easy-to-understand
//https://practice.geeksforgeeks.org/problems/circle-of-strings/0--simple in degree outdegree
public class MaxAreaIsland {
	
	
	 public int maxAreaOfIsland(int[][] grid) {
	        int max_area = 0;
	        for(int i = 0; i < grid.length; i++)
	            for(int j = 0; j < grid[0].length; j++)
	                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
	        return max_area;
	    }
	    
	    public int AreaOfIsland(int[][] grid, int i, int j){
	        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
	            grid[i][j] = 0;
	            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1) +
	            		AreaOfIsland(grid, i+1, j-1) + AreaOfIsland(grid, i-1, j+1) + AreaOfIsland(grid, i+1, j+1) + AreaOfIsland(grid, i-1, j-1);
	        }
	        return 0;
	    }
	    
	    
	    public static void main(String args[]) {
	    	int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
	    			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
	    			 {0,1,1,0,1,0,0,0,0,0,0,0,0},
	    			 {0,1,0,0,1,1,0,0,1,0,1,0,0},
	    			 {0,1,0,0,1,1,0,0,1,1,1,0,0},
	    			 {0,0,0,0,0,0,0,0,0,0,1,0,0},
	    			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
	    			 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
	    	MaxAreaIsland m= new MaxAreaIsland();
	    	System.out.println(m.maxAreaOfIsland(grid));
	    }

}




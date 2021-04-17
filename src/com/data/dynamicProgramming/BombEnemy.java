package com.data.dynamicProgramming;

public class BombEnemy {
	
	class Solution {
	    public int maxKilledEnemies(char[][] grid) {
	        if(grid.length == 0 || grid[0].length==0)
	            return 0;
	        int m = grid.length;
	        int n = grid[0].length;
	        int rowHits = 0;
	        int[] colHits = new int[n];
	        int max = 0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[i].length;j++){
	                if(j==0 || grid[i][j-1]=='W'){// first scan thru the row starting at 0 col;
	                    rowHits = 0;
	                    for(int k=j;k<n && grid[i][k]!='W';k++){
	                        rowHits+=grid[i][k]=='E'?1:0;
	                    }
	                }
	                if(i == 0 || grid[i-1][j]=='W'){// first scan thru the col starting at 0 row;
	                    colHits[j]=0;
	                    for(int k=i;k<m && grid[k][j]!='W';k++){
	                        colHits[j]+=grid[k][j]=='E'?1:0;
	                    }
	                }
	                
	                if(grid[i][j]=='0'){//so at ith row and jth col, we have scanned already the number of enemies
	                    max = Math.max(max,rowHits+colHits[j]);
	                }
	            }
	        }
	        return max;
	    }
	}

	// ["0","E","0","0"],
	// ["E","0","W","E"],
	// ["0","E","0","0"]



}

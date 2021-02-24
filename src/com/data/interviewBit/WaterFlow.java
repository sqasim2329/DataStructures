package com.data.interviewBit;

public class WaterFlow {
	
	public class Solution {
	    public int solve(int[][] A) {
	        
	        if(A.length==0 || A[0].length==0)
	        return 0;
	        
	        boolean[][] blueVisited = new boolean[A.length][A[0].length];
	        boolean[][] redVisited = new boolean[A.length][A[0].length];
	        int rows = A.length;
	        int cols = A[0].length;
	        for(int i=0;i<rows;i++){
	                dfs(i,0,blueVisited,A);
	        }
	        
	        for(int i=0;i<cols;i++){
	                dfs(0,i,blueVisited,A);
	        }
	        
	        for(int i=0;i<rows;i++){
	                dfs(i,cols-1,redVisited,A);
	        }
	        
	        for(int i=0;i<cols;i++){
	                dfs(rows-1,i,redVisited,A);
	        }
	        
	        int count = 0;
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                if(blueVisited[i][j] && redVisited[i][j])
	                    count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private void dfs(int r, int c,boolean[][] vis,int[][] A){
	        
	        vis[r][c]= true;
	        if(isSafe(r+1,c,A) && A[r][c] <= A[r+1][c] && !vis[r+1][c])
	            dfs(r+1,c,vis,A);
	        if(isSafe(r,c+1,A) && A[r][c] <= A[r][c+1] && !vis[r][c+1])
	            dfs(r,c+1,vis,A);
	        if(isSafe(r,c-1,A) && A[r][c] <= A[r][c-1] && !vis[r][c-1])
	            dfs(r,c-1,vis,A);
	        if(isSafe(r-1,c,A) && A[r][c] <= A[r-1][c] && !vis[r-1][c])
	            dfs(r-1,c,vis,A);    
	    }
	    
	    private boolean isSafe(int r, int c, int[][]A){
	        return r>=0 && c>=0 && r<A.length && c<A[r].length;
	    }
	}

}

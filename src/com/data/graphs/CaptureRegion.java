package com.data.graphs;

import java.util.HashSet;
import java.util.Set;
//M*N solution to be done O(N*M)
public class CaptureRegion {
	    private void solve(char[][] board) {
	        int m = board.length;
	        Set<Point> edge= new HashSet<>();
	        for(int i=0;i<m;i++){
	            if(board[0][i]=='O')
	                dfs(0,i,board);
	            if(board[i][0]=='O')
	            	dfs(i,0,board);
	            if(board[m-1][i]=='O')
	            	dfs(m-1,i,board);
	            if(board[i][m-1]=='O')
	            	dfs(i,m-1,board);
	        }
	        
	        for(int i=0;i<m;i++){
	            for(int j=0;j<m;j++){
	                if(board[i][j]=='O')
	                    board[i][j]='X';
	                else if(board[i][j]=='-')
	                	 board[i][j]='O';
	            }
	        }
	        
	         for(int i=0;i<m;i++){
	            for(int j=0;j<m;j++){
	                
	                  System.out.print(board[i][j]);
	            }
	             System.out.println("");
	        }
	    }
	    
	    private void dfs(int r, int c, char[][] board) {
			board[r][c]='-';
			if(isSafe(r-1,c,board) && board[r-1][c]=='O')
				dfs(r-1,c,board);
            if(isSafe(r+1,c,board) && board[r+1][c]=='O')
            	dfs(r+1,c,board);
            if(isSafe(r,c-1,board) && board[r][c-1]=='O')
            	dfs(r,c-1,board);
            if(isSafe(r,c+1,board) && board[r][c+1]=='O')
            	dfs(r,c+1,board);
			
			
		}

		private boolean isSafe(int a, int b,char[][] board){
	        return (a>=0 && a<board.length && b>0 && b<board.length );
	    }
	    
	    public static void main(String args[]) {
	    	char[][]board= {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
	    	CaptureRegion c= new CaptureRegion();
	    	c.solve(board);
	    }
	

}

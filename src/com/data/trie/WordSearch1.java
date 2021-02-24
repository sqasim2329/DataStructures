package com.data.trie;
//O(N * 3 ^ L) O(L)
public class WordSearch1 {
	
	class Solution {
	    public boolean exist(char[][] board, String word) {
	        
	        if(word.length()==0 || board.length==0 && board[0].length==0)
	            return false;
	        boolean [][]visited = new boolean[board.length][board[0].length];
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[i].length;j++){
	                if(board[i][j]==word.charAt(0)){
	                    if(backTrack(word,board,i,j,1,visited))
	                        return true;
	                }
	            }
	            
	        }
	        
	        return false;
	        
	    }
	    
	    
	    private boolean backTrack(String word,char[][] board,int r, int c, int indx,boolean [][]visited){
	        
	        if(indx == word.length())
	            return true;
	        
	        visited[r][c]=true;
	        
	        if(isSafe(r+1,c,board) && board[r+1][c]==word.charAt(indx) && !visited[r+1][c])
	            if(backTrack(word,board,r+1,c,indx+1,visited))
	                return true;
	        
	        if(isSafe(r-1,c,board) && board[r-1][c]==word.charAt(indx) && !visited[r-1][c])
	            if(backTrack(word,board,r-1,c,indx+1,visited))
	                return true;
	        
	        if(isSafe(r,c+1,board) && board[r][c+1]==word.charAt(indx) && !visited[r][c+1])
	            if(backTrack(word,board,r,c+1,indx+1,visited))
	                return true;
	        
	        if(isSafe(r,c-1,board) && board[r][c-1]==word.charAt(indx) && !visited[r][c-1])
	            if(backTrack(word,board,r,c-1,indx+1,visited))
	                return true;
	        
	        visited[r][c]=false;
	        
	        return false;
	            
	    }
	    
	    private boolean isSafe(int r,int c,char[][]board){
	        return r>=0 && r<board.length && c>=0 && c<board[r].length;
	    }
	    
	}

}

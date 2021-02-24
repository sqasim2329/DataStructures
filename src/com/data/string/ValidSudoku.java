package com.data.string;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	
	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        if(board.length==0 || board[0].length==0)
	            return false;
	        Set<String> seen = new HashSet<>();
	        int row = board.length;
	        int col = board[0].length;
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                if(board[i][j]!='.' && isAlreadyAvailable(seen,i,j,board)){
	                   return false; 
	                }
	            }
	        }
	        for(String str:seen)
	            System.out.println(str);
	        return true;
	    }
	    
	    private boolean isAlreadyAvailable(Set<String> seen,int row, int col,char[][] board){
	        return !seen.add(board[row][col] +" in row "+row)||
	               !seen.add(board[row][col] +" in col "+col)||
	               !seen.add(board[row][col]+" in row "+row/3+" - "+" in col "+col/3);
	    }
	}

}

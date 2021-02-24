package com.data.interviewBit;

public class DesignTicTacToe {
	
	class TicTacToe {
	    
	    int[] row;
	    int[] col;
	    int diagonal;
	    int antiDiagonal;
	    int size;

	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        row= new int[n];
	        col= new int[n];
	        diagonal = 0;
	        antiDiagonal = 0;
	        size = n; 
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int r, int c, int player) {
	        int val = player==1?1:-1;
	        row[r]+=val;
	        col[c]+=val;
	        if(r == c)
	            diagonal+=val;
	        if(r+c == size-1){
	            antiDiagonal+=val;
	        }
	        
	        if(Math.abs(row[r]) == size || Math.abs(col[c])==size || Math.abs(diagonal)==size || Math.abs(antiDiagonal) == size)
	            return player;
	        return 0;
	    }
	}

	// [3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]

	// [1 0 -1]
	// [-1 -1 0]
	// [1 1 1]
	/**
	 * Your TicTacToe object will be instantiated and called as such:
	 * TicTacToe obj = new TicTacToe(n);
	 * int param_1 = obj.move(row,col,player);
	 */



}

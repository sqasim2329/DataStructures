package backTracking;

public class SodukuSolver {
	class Solution {
	    public void solveSudoku(char[][] board) {
	        
	        solve(board,0);
	    }
	    
	    private boolean solve(char[][] board,int curr){
	        while(curr < 81 && board[curr/9][curr%9]!='.')
	            curr++;
	        if(curr == 81)
	            return true;
	        int row = curr/9;
	        int col = curr%9;
	        
	        for(char c='1'; c<='9';c++){
	            if(!isValid(board,row,col,c))continue;
	            board[row][col] = c;
	            if(solve(board,curr+1))
	                return true;
	            else
	                board[row][col]='.';
	        }
	        
	        return false;
	       
	    }
	    
	    private boolean isValid(char[][] board,int row,int col, char c){
	         for(int i = 0; i < 9; i++) {
	            if(board[i][col] == c) return false; //check row
	            if(board[row][i] == c) return false; //check column
	            if( board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
	        }
	        return true;
	    }

}

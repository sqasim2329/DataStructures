package com.data.dynamicProgramming;

public class RangeSum2DMutable {
	
	public class NumMatrix {
	    private int[][] arrs;
	    private int[][] Bindex;

	    public NumMatrix(int[][] matrix) {
	        if (matrix == null || matrix.length == 0) return;
	        int row = matrix.length, col = matrix[0].length;
	        this.arrs = new int[row][col];
	        this.Bindex = new int[row + 1][col + 1];
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                update(i, j, matrix[i][j]);
	                arrs[i][j] = matrix[i][j];
	            }
	        }
	    }
	    public void update(int row, int col, int val) {
	        int diff = val - arrs[row][col];
	        arrs[row][col] = val;
	        row ++;
	        col ++;
	        for (;row < Bindex.length; row += (row & -row)) {//need to understand 
	            for (int j = col; j < Bindex[0].length; j += (j & -j)) {
	                Bindex[row][j] += diff;
	            }
	        }
	    }
	    public int getSum(int row, int col) {
	        int sum = 0;
	        row++;
	        col++;
	        for (; row > 0; row -= (row & -row)) {
	            for (int j = col; j > 0; j -= (j & -j)) {
	                sum += Bindex[row][j];
	            }
	        }
	        return sum;
	    }
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        return getSum(row2,col2) - getSum(row1-1, col2) - getSum(row2, col1-1) + getSum(row1-1, col1-1);
	    }
	}
	
	class NumbMatrix {
	    
	    int[][] BIT;
	    int[][] matrix;

	    public NumbMatrix(int[][] matrix) {
	        int r = matrix.length;
	        int c = matrix[0].length;
	        BIT = new int[r+1][c+1];
	        this.matrix = matrix;
	        for(int i=1;i<=r;i++){
	            for(int j=1;j<=c;j++){
	                updateBIT(i,j,matrix[i-1][j-1]);
	            }
	        }
	        
	    }
	    
	    private void updateBIT(int row, int col, int val){
	        while(row < BIT.length){
	            while(col < BIT[0].length){
	                BIT[row][col] +=val;
	                col = getNext(col);
	            }
	            row = getNext(row);
	        }
	    }
	    
	    public void update(int row, int col, int val) {
	        row = row+1;
	        col = col+1;
	        int incre = val-matrix[row-1][col-1];
	        matrix[row-1][col-1] = val;
	        updateBIT(row,col,incre);
	    }
	    
	    private int getNext(int index){
	        return index+(index & -index);
	    }
	    
	    private int getParent(int index){
	        return index-(index & -index);
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	       return sum(row2+1,col2+1)-sum(row1,col2+1)-sum(row2+1,col1)+sum(row1,col1);
	    }
	    
	    private int sum(int r, int c){
	        int sum =0;
	        while(r > 0){
	            while(c > 0){
	                sum+=BIT[r][c];
	                c = getParent(c);
	            }
	            r = getParent(r);
	        }
	        return sum;
	    }
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * NumMatrix obj = new NumMatrix(matrix);
	 * obj.update(row,col,val);
	 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
	 */

}

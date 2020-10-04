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

}

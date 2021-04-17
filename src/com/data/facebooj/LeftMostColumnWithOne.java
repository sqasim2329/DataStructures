package com.data.facebooj;

public class LeftMostColumnWithOne {
	
	/**
	 * // This is the BinaryMatrix's API interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface BinaryMatrix {
	 *     public int get(int row, int col) {}
	 *     public List<Integer> dimensions {}
	 * };
	 */

	class Solution {
	    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
	        
	        List<Integer> dimension = binaryMatrix.dimensions();
	        int rows = dimension.get(0);
	        int cols = dimension.get(1);
	        int row = 0;
	        int col = cols-1;
	        int indx =-1;
	        while(row < rows && col >=0){
	            if(binaryMatrix.get(row,col)==1){
	                indx = col;
	                col = col-1;
	            }
	            else{
	                row = row+1;
	            }
	        }
	        return indx;
	        
	    }
	}






}

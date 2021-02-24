package com.data.interviewBit;

public class SpiralMatrix {
	
	class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        
	        List<Integer> result = new ArrayList<>();
	        int rowEnd = matrix.length-1;
	        int colEnd = matrix[0].length-1;
	        int rowBegin = 0;
	        int colBegin = 0;
	        while(rowBegin <= rowEnd && colBegin <= colEnd){
	            for(int i=colBegin;i<=colEnd;i++)
	                result.add(matrix[rowBegin][i]);
	            rowBegin++;
	        
	            for(int i=rowBegin;i<=rowEnd;i++)
	                result.add(matrix[i][colEnd]);
	            colEnd--;
	        
	            if(rowBegin <= rowEnd){
	            for(int i=colEnd;i>=colBegin;i--)
	                result.add(matrix[rowEnd][i]);    
	            }    
	            rowEnd--;
	        
	            if(colBegin <= colEnd){
	            for(int i=rowEnd;i>=rowBegin;i--)
	                result.add(matrix[i][colBegin]);
	            
	            }
	            colBegin++;    
	        
	        }
	        
	        return result;
	        
	    }
	}

}
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


class Solution {
    public int[][] generateMatrix(int n) {
        
        
        int[][] mat = new int[n][n];
        int rb = 0;
        int re = n-1;
        int cb = 0;
        int ce = n-1;
        int value = n*n;
        int j=1;
        while(j<=value){
            for(int i=cb; i <=ce;i++ ){
                mat[rb][i]=j++;
            }
            rb++;
            
            for(int i=rb; i <=re;i++ ){
                mat[i][ce]=j++;
            }
            ce--;
            
            
            for(int i=ce; i >=cb;i-- ){
                mat[re][i]=j++;
            }
            re--;
            
            
            for(int i=re;i >=rb;i--){
                mat[i][cb]=j++;
            }
            cb++;
            
            
        }
        
        return mat;
        
    }
}

// colBegin=0;
// colEnd=n-1;

// rowBegin=0;
// rowEnd=n-1;


// rowBegin ->(colBegin to colend)
// rowBegin++;
// colEnd -> rowBeign to rowEnd
// colEnd--;
// rowEnd-> colEnd to colBegin
// rowEnd--;
// colEbgin->rowEnd to rowBegin
// colBegin++;


// 1 2 3
// 8 9  4
// 7  6  5
    

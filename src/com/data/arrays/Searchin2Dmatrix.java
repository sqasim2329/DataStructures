package com.data.arrays;

public class Searchin2Dmatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int rowToFind = -1;
        for(int i=0;i<m;i++){
            int col = matrix[i].length;
            if(col!=0 && target <= matrix[i][col-1]){
                rowToFind =i;
                break;
            }
        }
        
        if(rowToFind!=-1){
            return binarySearch(rowToFind,matrix,target);
        }
        return false;
    }
    
    private boolean binarySearch(int row,int [][]mat,int target){
        int l =0;
        int r=mat[row].length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(mat[row][mid] < target){
                l =mid+1;
            }else{
                r=mid;
            }
        }
        return mat[row][l]==target;
        
    }

}
//search-a-2d-matrix-ii
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0)
            return false;
        
        int row =0;
        int col =matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        
        return false;
        
    }
}

package com.data.interviewBit;
//can also use priority queue
public class KthShortestElementInSortedMatrix {
	

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][m-1];
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            int count = countOfSmaller(mid,matrix);
            
            if(count < k)
                lo = mid+1;
            else
                hi = mid-1;
        }
        
        return lo;
        
    }
    
    private int countOfSmaller(int mid, int[][] matrix){
        int i=matrix.length-1;
        int j=0;
        int count =0;
        while(i >=0 && j < matrix[0].length){
            if( matrix[i][j] > mid){
                i--;
            }else{
                count+= i+1;
                j++;
            }
            
        }
        return count;
    }

}

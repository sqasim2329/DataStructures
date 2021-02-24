package com.data.heap;

public class SquaresofSortedArray {
	
	class Solution {
	    public int[] sortedSquares(int[] A) {
	        
	        int i =0;
	        int j = 0;
	        int n= A.length;
	        while(j<n && A[j]<0)
	            j++;
	        i=j-1;
	         int[] ans = new int[n];
	        int indx =0;
	        while(i >= 0 && j < n){
	            if(A[i]*A[i] <= A[j]*A[j]){
	                ans[indx++] = A[i]*A[i];
	                i--;
	                }
	                else{
	                ans[indx++] = A[j]*A[j];
	                j++;
	                }
	            }
	        
	        while(i>=0){
	            ans[indx++]=A[i]*A[i];
	                i--;
	        }
	        
	        while(j < n){
	            ans[indx++]=A[j]*A[j];
	                j++;
	        }
	        
	        return ans;
	        }
	    
	    
	    
	        
	    
	}

}

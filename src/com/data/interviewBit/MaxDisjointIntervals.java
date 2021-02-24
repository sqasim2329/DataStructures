package com.data.interviewBit;

import java.util.Arrays;
import java.util.Comparator;

public class MaxDisjointIntervals {
	
	public class Solution {
	    public int solve(int[][] A) {
	        Arrays.sort(A,new Comparator<int[]>(){
	            public int compare(int[] a,int[] b ){
	                return a[1]-b[1];
	            }
	            
	        });
	        int prevEnd = A[0][1];
	        int cnt =1;
	        for(int i=1;i<A.length;i++){
	            if(prevEnd < A[i][0])
	            {
	                prevEnd = A[i][1];
	                cnt++;
	            }
	        }
	        
	        return cnt;
	        
	        
	        
	    }
	}


}

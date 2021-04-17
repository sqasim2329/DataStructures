package com.data.google.microsoft;

public class PartitionArrayIntoDisjointntervals {
	
	class Solution {
	    public int partitionDisjoint(int[] A) {
	        int part = 1;
	        int prevMax = A[0];
	        int currMax = 0;
	        
	        for(int i=0;i<A.length;i++){
	            currMax = Math.max(A[i],currMax);
	            if(A[i] < prevMax){
	                prevMax = currMax;
	                part = i+1;
	            }
	        }
	        
	        return part;
	    }
	}


	// [1,1,1,0,6,12]

	    

}

package com.data.linkedin;

public class MaximumCircularSubarraySum {
	
	class Solution {
	    public int maxSubarraySumCircular(int[] A) {
	        int nonCircularSum = kadane(A);
	        int totalSum = 0;
	        for(int i = 0;i<A.length;i++){
	            totalSum+=A[i];
	            A[i] = -A[i];
	        }
	        
	        int circularSum = totalSum + kadane(A);
	        if(circularSum == 0)// if minSubarray sum equals totalSum;
	            return nonCircularSum;
	        return Math.max(nonCircularSum,circularSum);
	        
	    }
	    
	    private int kadane(int[] A){
	        int curr = A[0];
	        int msf = A[0];
	        for(int i=1;i<A.length;i++){
	            if(curr < 0 )
	                curr = 0;
	            curr+=A[i];
	            msf = Math.max(curr,msf);
	            
	        }
	        
	        return msf;
	    }
	}


	// circular subarray sum = totalSum - MinSumSubarray;



	// 5,-3,5
	    
	// -5,3,-5
	    
	// totalSum+    
	    
	    
	// 10,7    

}

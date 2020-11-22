package com.data.arrays;
//kadane algo
public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSumSoFar = Integer.MIN_VALUE;
        for(int i:nums){
            currSum = currSum+i;
            maxSumSoFar = Math.max(maxSumSoFar,currSum);
            currSum = Math.max(currSum,0);
            
        }
        return maxSumSoFar;
    }

}

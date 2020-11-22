package com.data.arrays;

public class MaxProductSubarray {
	
	 public int maxProduct(int[] nums) {
	        
	        int maxSF = nums[0];
	        int minSF = nums[0];
	        int res = maxSF;
	        for(int i =1; i<nums.length;i++ ){
	            int curr = nums[i];
	            int tmp  = Math.max(curr,Math.max(maxSF*curr,minSF*curr));
	            minSF = Math.min(curr,Math.min(maxSF*curr,minSF*curr));
	            maxSF = tmp;
	            res = Math.max(res,maxSF);
	            
	        }
	        
	        return res;
	        
	    }

}

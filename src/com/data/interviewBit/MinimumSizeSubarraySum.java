package com.data.interviewBit;

public class MinimumSizeSubarraySum {
	
	class Solution {
	    public int minSubArrayLen(int s, int[] nums) {
	        
	        
	        int ans = nums.length+1;
	        int sum =0;
	        int left = 0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            while(sum >= s){
	                    ans = Math.min(ans,i-left+1);
	                    sum-=nums[left++];
	            }
	        }
	        
	        return ans ==nums.length+1?0:ans;
	        
	    }

	}

}

//Maximum Length of Repeated Subarray//longest common substring

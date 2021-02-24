package com.data.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions.
public class TargetSum {
	
	class Solution {
	    public int findTargetSumWays(int[] nums, int S) {
	        Map<String,Integer> dp = new HashMap<>();
	        return dp(nums,S,0,dp);
	        
	    }
	    
	    private int dp(int[] nums,int s, int i,Map<String,Integer> dp){
	        String key = String.valueOf(s)+"*"+String.valueOf(i);
	            if(dp.containsKey(key))
	                return dp.get(key);
	        if(i==nums.length){
	            if(s == 0)
	            return 1;
	        else
	            return 0;
	        }
	        
	        int pos = dp(nums,s+nums[i],i+1,dp);
	        int neg = dp(nums,s-nums[i],i+1,dp);
	        
	        dp.put(key,pos+neg);
	        return dp.get(key);
	    }
	    
	    class Solution2{
	    	public int countOfSubsetsWithSum(int s,int nums[], int i) {
	    		
	    		if(s == 0)
	    			return 1;
	    		if(i >= nums.length || s<0)
	    			return 0;
	    		
	    		return countOfSubsetsWithSum(s-nums[i],nums,i+1)
	    				+ countOfSubsetsWithSum(s,nums,i+1);
	    		
	    	}
	    	}
	    }

}
	
	

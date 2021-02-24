package com.data.dynamicProgramming;

public class MinimumSubsetSumDifference {
	
	public class Solution {
	    public int solve(int[] A) {
	        int sum =0;
	        for(int i:A)
	            sum+=i;
	        return subset(sum,A);
	    }
	    
	    private int subset(int target, int[] nums){
	        int  n = nums.length;
	        boolean [][] dp = new boolean[n+1][target+1];
	        for(int i=0;i<=n;i++)
	            dp[i][0]=true;
	            
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=target;j++){
	                if(nums[i-1]<=j)
	                    dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
	                else
	                    dp[i][j]=dp[i-1][j];
	            }
	        }
	        //s1+s2=sum
	        //s1 = sum-s2;
	        //
	        
	        int diff = Integer.MAX_VALUE;
	        for(int i=0;i<=target/2;i++){
	            int first = i;
	            int second = target-i;
	            if(dp[n][i])
	            diff= Math.min(diff,Math.abs(first-second));
	        }
	        return diff;
	    }
	}


}

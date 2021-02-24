package com.data.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

//min jumps to reach end of 2d array
public class JumpGame2 {
	
	public int jump(int[] nums) {
        int n= nums.length;
        if(n == 0)
            return 0;
        int []dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(nums[j]>=(i-j))
                dp[i] = Math.min(dp[i],1+dp[j]);
            }
        }
        return dp[n-1];
        
        
    }
	//Jump Game 3
	class Solution {
	    
	    public boolean canReach(int[] arr, int start) {
	        Set<Integer> set = new HashSet<>();
	        return canReach(arr,start,set);
	    }
	    
	    private boolean canReach(int[] arr, int start, Set<Integer> set){
	        if(start >= arr.length || start < 0)
	            return false;
	        
	        if(arr[start] == 0)
	            return true;
	       
	        if(!set.contains(start)){
	            set.add(start);
	            return canReach(arr,start+arr[start],set)||canReach(arr,start-arr[start],set);
	        }
	       
	        
	        return false;
	    }
     

}

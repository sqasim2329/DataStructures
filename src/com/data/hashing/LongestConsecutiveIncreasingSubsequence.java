package com.data.hashing;

public class LongestConsecutiveIncreasingSubsequence {
	
public int findLengthOfLCIS(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        int count =1;
        int prev=nums[0];
        int max =1;
        for(int i=1;i<nums.length;i++){
            if(prev < nums[i]){
                count++;
                max = Math.max(max,count);
            }else{
                count=1;
            }
            prev = nums[i];
        }
        
        return max;
        
    }

}

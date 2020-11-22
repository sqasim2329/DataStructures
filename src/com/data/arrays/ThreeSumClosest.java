package com.data.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans =-1;
        int diff =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(diff > Math.abs(sum-target) && diff!=0){
                    diff = Math.abs(sum-target);
                    ans = sum;
                }
                if(sum > target){
                    k--;
                }else
                    j++;
            }
        }
        return ans;

	}
}
	
	/******
	 * 
	 * 
	 * Input: nums = [-1,2,1,-4], target = 1
		Output: 2
		Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * 
	 * 
	 * *******/

package com.data.arrays;

import java.util.Arrays;

public class ThreeSumSmaller {
	
	public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length-2;i++){
            while(i>0 && nums[i]==nums[i-1])continue;
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target){
                    while(j<k && nums[j]==nums[j+1])j++;
                    while(j<k && nums[k]==nums[k-1])k--;
                    j++;
                    k--;
                }
                else if(sum < target){
                    count+=k-j;
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        return count;
        
    }
	
	public static void main(String args[]) {
		ThreeSumSmaller t = new ThreeSumSmaller();
		int nums[]= {0,0,0,0};
		int target =0;
		System.out.println(t.threeSumSmaller(nums, target));
	}

}

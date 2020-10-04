package com.data.dynamicProgramming;

public class coinChnageTotalWays {
	
	public static void main(String args[]) {
		int nums[]= {1,2,3};
		int target = 5;
		
		System.out.println(backTrack(nums,target,0,0));
	}
	
	private static int backTrack(int[] nums,int target, int sum, int ind) {
		if(sum == target)
			return 1;
		
		if(sum > target || ind >= nums.length)
			return 0;
		int count=0;
		for(int i=ind;i<nums.length;i++) {
			count+=backTrack(nums,target,sum+nums[i],i);
		}
		
		return count;
	}
	
	

}

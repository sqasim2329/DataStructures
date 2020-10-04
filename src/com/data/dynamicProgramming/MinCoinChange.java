package com.data.dynamicProgramming;

public class MinCoinChange {
	
	public static void main(String args[]) {
		int nums[]= {1,2,3};
		int target = 5;
		
		System.out.println(backTrack(nums,target,0,0));
	}
	
	private static int backTrack(int[] nums,int target, int sum, int ind) {
		if(sum == target)
			return 0;
		
		if(ind >= nums.length || sum > target)
			return Integer.MAX_VALUE/10;
		
		int minCount = Integer.MAX_VALUE/10;//removing the division will cause integer to over flow and give negative number
		for(int i=ind;i<nums.length;i++) {
			minCount = Math.min(1+backTrack(nums,target,sum+nums[i],i), minCount);
		}
		
		return minCount;
	}

}

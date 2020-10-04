package com.data.dynamicProgramming;

public class MaximizeCutSegments {
	
	public static void main(String args[]) {
		int N = 4;
		int nums[]= {2,1,1};
		
		System.out.println(backTrack(nums,N));
	}

	private static int backTrack(int[] nums, int n) {
			if(n < 0)
				return Integer.MIN_VALUE;
			
			if(n==0)
				return 0;
			
			int max = Integer.MIN_VALUE;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]<=n)
					max =  Math.max(max, 1+backTrack(nums,n-nums[i]));
			}
			
			return max;
	}

}

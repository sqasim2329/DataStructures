package com.data.dynamicProgramming;

public class CountofSubsetsSum {
	
	public static int subsetsum(int[]nums,int target) {
		int n=nums.length;
		
		int count[][] = new int[n+1][target+1];
		
		for(int i=0;i<=n;i++) {
		
			count[i][0]=1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=target;j++) {
				if(nums[i-1]<=j)
				{
		
					count[i][j]=count[i-1][j]+count[i-1][j-nums[i-1]];
				}
				else {
		
					count[i][j]=count[i-1][j];
				}
				
			}
		
	}
		return count[n][target];

	}
	
	public static void main(String args[]) {
		int target=5;
		int[] nums= {1, 2, 3, 4, 5};
		System.out.println(subsetsum(nums,target));
	}
}
		

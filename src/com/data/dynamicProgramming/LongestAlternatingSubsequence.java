package com.data.dynamicProgramming;

import java.util.Arrays;

public class LongestAlternatingSubsequence {
	
	public static int dp(int[]nums) {
		int n = nums.length;
		int[][] seq=new int[n][2];
		int max =1;
		for(int[] s:seq) {
			Arrays.fill(s, 1);
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++) {
				if(nums[j]<nums[i] && seq[i][0]<seq[j][1]+1) 
					seq[i][0]=seq[j][1]+1;
				
				if(nums[j]>nums[i] && seq[i][1]<seq[j][0]+1)
					seq[i][1]=seq[j][0]+1;
				
				max = Math.max(seq[i][0], seq[i][1]);
	
			}
			
		}
		return max;
	}
	
	public static void main(String args[]) {
		int [] arr={ 10, 22, 9, 33, 49, 
                50, 31, 60 };
		System.out.println(dp(arr));
	}

}

package com.data.dynamicProgramming;

public class CutRibbonIntoEqualLengths {
	
	public static int cutRibbon(int[]nums, int k) {
		int max =0;
		for(int i:nums)
			max = Math.max(i, max);
		
		int l = 1;
		int r = max;
		while(l<r) {
			int mid = l+(r-l)/2;
			int noOfRibbonWithLenMid = getCount(nums,mid);
			if(noOfRibbonWithLenMid > k)
				l=mid+1;
			else
				r=mid-1;
			
		}
		return l;
		
	}
	
	private static int getCount(int[] arr, int mid) {
		int res =0;
		for(int i:arr)
			res+=i/mid;
		return res;
	}



public static void main(String args[]) {
	int[]arr = {1, 2, 3, 4, 9};
	int k = 5;
	System.out.println(cutRibbon(arr,k));
	
	}
}
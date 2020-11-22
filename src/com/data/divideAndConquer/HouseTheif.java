package com.data.divideAndConquer;

public class HouseTheif {
	
	public static void main(String args[]) {
		int arr[] = {6,7,1,30,2,4};
		System.out.println(getMaxStealth(arr,0));
		System.out.println(dp(arr));
	}

	private static int getMaxStealth(int[] arr, int index) {
		// TODO Auto-generated method stub
		if(index > arr.length-1) {
			return 0;
		}
		int currentHouseStealth = arr[index]+ getMaxStealth(arr,index+2);
		int skipCurrentHouseStealth = getMaxStealth(arr,index+1);
		return Math.max(currentHouseStealth, skipCurrentHouseStealth);
	}
	
	private static int dp(int []nums) {
		int dp[]=new int[nums.length+1];
		dp[0]=0;
		dp[1]=nums[0];
		for(int i=2;i<=nums.length;i++) {
			dp[i]= Math.max(nums[i-1]+dp[i-2],dp[i-1]);
		}
		
		return dp[nums.length];
	}
	
	
	
	



}

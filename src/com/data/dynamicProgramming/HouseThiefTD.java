package com.data.dynamicProgramming;

public class HouseThiefTD {
	
	public static void main(String args[]) {
		int arr[] = {6,7,1,30,2,4};
		int dp[] = new int[arr.length+2];
		System.out.println(getMaxStealth(dp,arr,0));
	}

	private static int getMaxStealth(int dp[],int[] arr, int i) {
		
		if(i > arr.length-1) {
			return 0;
		}
		if(dp[i]==0) {
		int currentHouseStealth = arr[i] + getMaxStealth(dp,arr,i+2);
		int skipCurrentHouseStealth = getMaxStealth(dp,arr,i+1);
		dp[i]=Math.max(currentHouseStealth,skipCurrentHouseStealth); 
		}
		
		return dp[i];
		
		
	}

}

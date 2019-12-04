package com.data.dynamicProgramming;

public class HouseThiefBU {
	
	public static void main(String args[]) {
		int arr[] = {6,7,1,30,2,4};
		System.out.println(getMaxStealth(arr,0));
		
	}

	private static int getMaxStealth(int[] arr, int n) {
		// TODO Auto-generated method stub''''
		int dp[] = new int[arr.length+2];
		dp[arr.length] = 0;
		for(int i =arr.length-1 ; i >=0 ; i-- ) {
			dp[i] = Math.max(arr[i]+dp[i+2], dp[i+1]);
		}
		
		return dp[0];
	}

}

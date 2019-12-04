package com.data.divideAndConquer;

public class WaysToReachLastCellInArray {
	
	public static void main(String args[]) {
		int arr[] = {10, 30, 40, 50, 20};
		int k = 3;
		int dp[] = new int[arr.length];
		System.out.println(findMinCostToReachEnd(dp,arr,0,k));
	}

	private static int findMinCostToReachEnd(int dp[],int[] arr, int i, int k) {
		// TODO Auto-generated method stub
		if(i >= arr.length-1)
			return 0;
		if(dp[i]==0) {
		int x = Integer.MAX_VALUE;
		for(int j=1;j<=k;j++) {
		if(i+j <= arr.length-1)
		 x = Math.min(x, Math.abs(arr[i]-arr[i+j]) + findMinCostToReachEnd(dp,arr,i+j,k));
		else break;
		}
		dp[i] =  x;
		}
		return dp[arr.length-1];
		
	}

}

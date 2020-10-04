package com.data.dynamicProgramming;

public class HouseThiefBU {
	
	public static void main(String args[]) {
		int arr[] = {6,7,1,30,2,4};
		System.out.println(dp(arr));
		
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
	
	
	private static int dp(int[] arr) {
		int arrr []= {2,7,9,3,1};
		arr =arrr;
		int n= arr.length;
		int dp[]= new int [n];
		dp[0]=arr[0];
		dp[1]=arr[1];
		for(int i=2;i<n;i++) {
			dp[i]=Math.max(dp[i-1], dp[i-2]+arr[i]);
		}
		return dp[n-1];
	}
	

}

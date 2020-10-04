package com.data.arrays;
//given an array with broken staircase find ways to reach nth step--broken stair case means skip counting for that step 
public class BrokenStairCaseProbelm {
	public static void main(String args[]) {
//		int []arr={3, 4};
		int []arr={3};
		int K = 6;
		
		System.out.println(countways(arr,K));
	}

	private static int countways(int[] arr, int k) {
		int dp[]= new int[k+1];
		dp[0]=1;//only one way to reach 0th step i.e 1
		for(int i=1;i<=k;i++) {
			dp[i]=-1;
		}
		
		for(int i=0;i<arr.length;i++) {
			dp[arr[i]]=0;
		}
		
		dp[1]=dp[1]==-1?1:dp[1];//1 step may be broken
		
		for(int i=2;i<=k;i++) {
			if(dp[i]==0)
				continue;
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		return dp[k];
	}

}

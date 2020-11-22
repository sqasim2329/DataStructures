package com.data.dynamicProgramming;

public class MaxSumIncreasingSUbsequence {
	public static void main(String args[]) {
	
//	int arr[]= {1,101,2,3,100,4,5};
	int arr[]= {4,6,1,3,8,4,6};
	System.out.println(findMaxSum(arr));
	}

	private static int findMaxSum(int[] a) {
		int T[]=new int[a.length];
		for(int i=0;i<a.length;i++) {
			T[i]=a[i];
		}
		
		for(int i=1; i<a.length; i++) {
			for(int j=0; j<i;j++) {
				if(a[j]<a[i]) {
					T[i]
							=Math.max(T[j]+a[i],T[i]);
				}
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			if(max < T[i]) {
				max = T[i];
			}
		}
		
		return max;
	}
	
	public int maxSumIS(int arr[], int n)  
	{  
	    int dp[]= new int[n];
	    for(int i =0;i < n;i++)
	    dp[i]=arr[i];
	    int max =dp[0];
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(arr[j]<arr[i])
	            dp[i]=Math.max(dp[j]+arr[i],dp[i]);
	            max = Math.max(dp[i],max);
	        }
	    }
	    
	    return max;
	}  

}

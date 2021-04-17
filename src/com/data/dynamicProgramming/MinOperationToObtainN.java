package com.data.dynamicProgramming;

public class MinOperationToObtainN {
	
	public static void main(String args[]) {
		MinOperationToObtainN m = new MinOperationToObtainN();
		int n=5;
		System.out.println(m.minOperation(n));
	}
    
    public int minOperation(int n)
    {
     
     int dp[] = new int[n+1];
     dp[0]=0;
     dp[1]=0;//starting at hence no ops required.
     for(int i=2;i<=n;i++) {
    	 if(i%2==0) {
    		 dp[i]=Math.max(dp[i], 1+dp[i/2]);
    	 }
    	 
    	 if(i%3==0) {
    		 dp[i]=Math.max(dp[i], 1+dp[i/3]);
    	 }
    	 
    	 if(i%3==0) {
    		 dp[i]=Math.max(dp[i], 1+dp[i/3]);
    	 }
    	 
    	  dp[i]=Math.max(dp[i], 1+dp[i-1]);
     	}
     return dp[n];
    }

}

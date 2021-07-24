package com.data.divideAndConquer;

public class CountOfPalindromicSubsequences {
	
	class Solution
	{
	    long countPS(String str)
	    {
	        int n = str.length();
	        
	        int [][] dp = new int[n][n];
	        for(int i=0;i<n;i++){
	            dp[i][i]=1;
	        }
	        
	        // for(int i=0;i<n-1;i++){
	        //     if(str.charAt(i)==str.charAt(i+1)){
	        //         dp[i][i+1]=1+dp[i+1][j]+dp[i][j-1];
	        //     }else{
	        //         dp[i][i+1]=dp[i+1][i+1]+dp[i][i+1]-dp[i+1][j-1];
	        //     }
	        // }
	        
	        for(int k=2;k<=n;k++){
	            for(int i=0;i<=n-k;i++){
	                int j = i+k-1;
	                if(str.charAt(i) == str.charAt(j)){
	                    dp[i][j]=1+dp[i+1][j]+dp[i][j-1];
	                }else{
	                    dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
	                }
	            }
	        }
	        
	        return dp[0][n-1];
	    }
	}
}

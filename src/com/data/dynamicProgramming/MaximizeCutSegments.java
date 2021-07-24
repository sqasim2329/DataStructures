package com.data.dynamicProgramming;

import java.util.Arrays;

public class MaximizeCutSegments {
	
	public int maximizeCuts(int n, int x, int y, int z)
    {
       
       int[] dp = new int[n+1];//dp[state] state--->holds the length dp[state]= number of cuts
       
       dp[0]=0;
       
       for(int i=1;i<=n;i++){
           dp[i]=-1;
           if(i-x>=0)
                dp[i]=Math.max(dp[i-x],dp[i]);
            
            if(i-y>=0)
                dp[i]=Math.max(dp[i-y],dp[i]);
            
            if(i-z>=0)
                dp[i]=Math.max(dp[i-z],dp[i]);
            
            if(dp[i]!=-1)    
                dp[i]++;//since if you keep updating 1 before all values will increase by 1
       }
       
       return Math.max(dp[n],0);
}

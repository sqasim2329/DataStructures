package com.data.dynamicProgramming;

public class MinOperationToObtainN {
	
	public static void main(String args[]) {
		MinOperationToObtainN m = new MinOperationToObtainN();
		int n=5;
		System.out.println(m.minOperation(n));
	}
	
	public int minOperation(int n)
    {
        return solve(n,0);
    }
    
    private int solve(int n,int cnt){
        if(n==0)
        return cnt;
        
        if(n<0)
        return 0;

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        if(n%2 == 0)
        x = solve(n/2,cnt+1);
        else
        y = solve(n-1,cnt+1);
        return Math.min(x,y);
    }
    
    public int minOperationDp(int n)
    {
     
     int[]dp= new int[n+1];
     dp[0]=1;
     dp[1]=1;
     for(int i=2;i<=n;i++){
         if(i%2==0)
//         dp[i] = Math.min(dp[i-i/2],dp[i-1])+1;
        	 dp[i] = dp[i-i/2]+1;//this will also work
         else
         dp[i] = dp[i-1]+1;
         
     }
     
     return dp[n];
    }

}

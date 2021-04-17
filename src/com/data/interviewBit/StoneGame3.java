package com.data.interviewBit;

public class StoneGame3 {
	
	
	public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int diff = solve(stoneValue,0,dp);
        if(diff > 0) return "Alice";
        if(diff == 0) return "Tie";
        return "Bob";
        
    }
    
    private int solve(int[] stoneValue,int indx, int[]dp){
        if(indx >= stoneValue.length)
            return 0;
        
        if(dp[indx]!=-1) return dp[indx];
        
        int ans = stoneValue[indx] - solve(stoneValue,indx+1,dp);
        if(indx+1 < stoneValue.length) ans = Math.max(ans,stoneValue[indx]+stoneValue[indx+1]-solve(stoneValue,indx+2,dp));
        if(indx+2 < stoneValue.length) ans = Math.max(ans,stoneValue[indx]+stoneValue[indx+1]+stoneValue[indx+2]-solve(stoneValue,indx+3,dp));
        
        return dp[indx]=ans;
        
        
    }
    
    
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        for(int indx=n-1;indx>=0;indx--){
            int ans = stoneValue[indx] - dp[indx+1];
            if(indx+1 < stoneValue.length) ans = Math.max(ans,stoneValue[indx]+stoneValue[indx+1]-dp[indx+2]);
            if(indx+2 < stoneValue.length) ans = Math.max(ans,stoneValue[indx]+stoneValue[indx+1]+stoneValue[indx+2]-dp[indx+3]);
            dp[indx] = ans;
        }
        int diff = dp[0];
        if(diff > 0) return "Alice";
        if(diff == 0) return "Tie";
        return "Bob";
        
    }
    
    
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        int prev_prev = 0;
        int prev = 0;
        int curr = 0;
        for(int indx=n-1;indx>=0;indx--){
            int ans = stoneValue[indx] - curr;
            if(indx+1 < stoneValue.length) ans = Math.max(ans,stoneValue[indx]+stoneValue[indx+1]-prev);
            if(indx+2 < stoneValue.length) ans = Math.max(ans,stoneValue[indx]+stoneValue[indx+1]+stoneValue[indx+2]-prev_prev);
            prev_prev = prev;
            prev = curr;
            curr = ans;
        }
        int diff = curr;
        if(diff > 0) return "Alice";
        if(diff == 0) return "Tie";
        return "Bob";
        
    }

}

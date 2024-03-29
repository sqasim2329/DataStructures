package com.data.dynamicProgramming;

public class CoinChangeinMinCoins {
	
public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=0;
        }
        
        for(int i=1;i<=amount;i++){
            dp[0][i]=Integer.MAX_VALUE/10;//1+Integer.MAX_VALUE --> Integer.MIN_VALUE
        }
        
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[coins.length][amount]==Integer.MAX_VALUE/10?-1:dp[coins.length][amount];
        
    }

}

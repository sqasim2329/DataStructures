package com.data.dynamicProgramming;

public class LPSodStringBU {
	
	public static void main(String args[]) {
		String s = "meadbm,";
		System.out.println(findLPSOfString(s));
	}

	private static int findLPSOfString(String s) {
		// TODO Auto-generated method stub
		
		int dp[][] = new int[s.length()][s.length()];
		
		for(int j =0; j <= s.length()-1; j++) {
			for(int i=s.length()-1; i >=0 ; i--) {
				
				if(i > j) {
					dp[i][j] = 0;
				}
				else if(i == j) {
					dp[i][j] = 1;
				}else {
				int x =0;
				if(s.charAt(i)==s.charAt(j))
					x = 2 + dp[i+1][j-1]; 
				int	y = dp[i+1][j];
				int	z = dp[i][j-1];
				dp[i][j] = Math.max(x, Math.max(y, z));
			}
		  }
		}
		return dp[0][s.length()-1];
	}
	
	public int longestPalindromeSubseq(String s) {
        int n= s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=2;
            }else{
                dp[i][i+1]=1;
            }
        }
        
        
        for(int k=3;k<=n;k++){// i+k-1 = if K<n then i+4-1 =3
            for(int i=0;i<n-k+1;i++){
                int j = i+k-1;
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j] = 2+dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        
        return dp[0][n-1];
    }
	

}

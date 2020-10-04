package com.data.dynamicProgramming;

public class LCSOfTwoStringsBU {
 
	public static void main(String args[]) {
		String s1 =  "huind";
		String s2 = "houdini";
		
		System.out.println(dp(s1,s2));
	}

	private static int findLCSofTheStrings(String s1, String s2) {
		// TODO Auto-generated method stub
		Integer dp[][] = new Integer[s2.length()+1][s1.length()+1];
		
		for(int i = 0; i <= s1.length(); i++) {
			dp[s2.length()][i] =0 ;
		}
		
		for(int i = 0; i <= s2.length(); i++) {
			dp[i][s1.length()] = 0 ;
		}
		
		for(int i = s2.length()-1 ; i >= 0 ;i--) {
			for(int j=s1.length()-1; j>=0;j--) {
				int x = 0;
				if(s1.charAt(j) == s2.charAt(i))
					x =1 + dp[i+1][j+1];
					int y = dp[i+1][j];
					int z = dp[i][j+1];
					int max1 = Math.max(x, y);
					dp[i][j] = Math.max(max1, z);
			}
		}
		return dp[0][0];
	}
	
	
	public static int dp(String s1,String s2) {
		int n= s1.length();
		int m= s2.length();
		int dp[][]= new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
		return dp[n][m];
	}

}

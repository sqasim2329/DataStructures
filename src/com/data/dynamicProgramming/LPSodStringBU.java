package com.data.dynamicProgramming;

public class LPSodStringBU {
	
	public static void main(String args[]) {
		String s = "ISMADAMIS";
		System.out.println(findLPSOfString(s));
	}

	private static int findLPSOfString(String s) {
		// TODO Auto-generated method stub
		
		int dp[][] = new int[s.length()][s.length()];
		
		
			for(int i=s.length()-1; i >=0 ; i--) {
				for(int j =0; j <= s.length()-1; j++) {
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
	

}

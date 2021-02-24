package com.data.divideAndConquer;

public class LongestCommonSubstringOftwoString {
	
	public static void main(String args[]) {
		String s1="abcdefg";
		String s2="bcrcdefg";
		
		System.out.println(dp(s1,s2));
	}

	private static int lcs(String s1, String s2, int i, int j) {
		if(i>s1.length()-1 || j>s2.length()-1)
		return 0;
		
		int x=0;
		while((                              ))  {
			x=1+lcs(s1,s2,i+1,j+1);
			if(i >= s1.length() && j >= s2.length()) {
				break;
			}
		}
		int y=lcs(s1,s2,i+1,j);
		int z=lcs(s1,s2,i,j+1);
		return Math.max(x,Math.max(y, z));
	}
	
	
	private static int dp(String s1,String s2) {
		int n = s1.length();
		int m =s2.length();
		int dp[][] = new int [n+1][m+1];
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1))
					max = Math.max(max, dp[i][j]=1+dp[i-1][j-1]);
			}
		}
		
		return max;
	}

}

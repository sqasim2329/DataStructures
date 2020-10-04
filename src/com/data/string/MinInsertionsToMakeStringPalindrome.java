package com.data.string;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinInsertionsToMakeStringPalindrome {
	
	public static void main(String args[]) {
		String s = "leetcode";
		int[][] dp = new int[s.length()][s.length()];
		for(int[] d:dp) {
			Arrays.fill(d, -1);
		}
		System.out.println(makePalindrome(s,0,s.length()-1,dp));
	}

	private static int makePalindrome(String s,int i, int j) {
		if(i>=j)
			return 0;
		
		int a=0,b=0,c=0;
		if(s.charAt(i)==s.charAt(j))
			return makePalindrome(s,i+1,j-1);
			b = 1+makePalindrome(s,i+1,j);
			c = 1+makePalindrome(s,i,j-1);
		
		return  Math.min(c, b);
		
	}
	
	
	private static int makePalindrome(String s,int i, int j,int[][]dp) {
		if(i>=j)
			return dp[i][j]=0;

		if(dp[i][j]!=-1)
			return dp[i][j];

		if(s.charAt(i)==s.charAt(j))
			return dp[i][j]=makePalindrome(s,i+1,j-1,dp);
			int a = 1+makePalindrome(s,i+1,j,dp);
			int b = 1+makePalindrome(s,i,j-1,dp);
		
		return  dp[i][j]=Math.min(a, b);
		
	}

}

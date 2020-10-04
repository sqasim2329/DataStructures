package com.data.divideAndConquer;

public class LongestPalindromicSubstring {
	
	public static void main(String args[]) {
		String s= "MkEAEkM";
//		System.out.println(findLCSOfString(s,0,s.length()-1));
		System.out.println(dp(s));
	}

	private static int findLPSOfString(String s, int i, int j) {
		
		if(i > j) {
			return 0;
		}
		
		if(i == j) {
			return 1;
		}
		int x = 0;
		if(s.charAt(i)==s.charAt(j)) {
			int remainingLength = j-i-1;
			if(remainingLength == findLPSOfString(s,i+1,j-1) )
			 x = remainingLength+2;
		}
		int y = findLPSOfString(s,i+1,j);
		int z = findLPSOfString(s,i,j-1);
		int max1 = Math.max(x, y);
		return Math.max(max1, z);
	}
	
	private static int dp(String st) {
	int[][] dp = new int[st.length()][st.length()];
	for (int col = 0; col < st.length(); col++) {
		for (int row = st.length()-1; row >= 0; row--) {
			if (row > col) { 
				dp[row][col] = 0;
			} else if (row == col) {
				dp[row][col] = 1;
			} else {
				if (st.charAt(row) == st.charAt(col)) {
					dp[row][col] = Math.max(2+dp[row + 1][col - 1], Math.max(dp[row][col - 1], dp[row + 1][col]));
				} else {
					dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
				}
			}
		} 
	}
	return dp[0][st.length()-1];
	}
	

}




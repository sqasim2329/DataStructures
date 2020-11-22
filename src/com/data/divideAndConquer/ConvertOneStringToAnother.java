package com.data.divideAndConquer;

public class ConvertOneStringToAnother {
	
	public static void main(String args[]) {
		String s1="table";
		String s2="tabcd gble";
		System.out.println(solve(s1,s2));
	}

	private static int findMinOperations(String s1, String s2, int i, int j) {
		
		if(i==s1.length()) {
			return s2.length()-j;
		}
		
		if(j==s2.length()) {
			return s1.length()-i;
		}
		
		if(s1.charAt(i)==s2.charAt(j))
			return findMinOperations(s1,s2,i+1,j+1);

		int insert = 1 + findMinOperations(s1,s2,i+1,j);
		int delete = 1 + findMinOperations(s1,s2,i,j+1);
		int replace = 1 + findMinOperations(s1,s2,i+1,j+1);
		
		int min1 = Math.min(insert, replace);
		int min2 = Math.min(delete, min1);
		
		return min2;
		
	}
	
	private static int solve(String s1,String s2) {
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i<= s1.length();i++)
			dp[i][0]=i;
		
		for(int i = 0; i<= s2.length();i++)
			dp[0][i]=i;
		
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++){
				
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=0;
				else {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
			}

		}
		return dp[s1.length()][s2.length()];
	}

}

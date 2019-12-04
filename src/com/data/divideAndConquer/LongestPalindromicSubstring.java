package com.data.divideAndConquer;

public class LongestPalindromicSubstring {
	
	public static void main(String args[]) {
		String s= "MADAMS";
		System.out.println(findLCSOfString(s,0,s.length()-1));
	}

	private static int findLCSOfString(String s, int i, int j) {
		
		if(i > j) {
			return 0;
		}
		
		if(i == j) {
			return 1;
		}
		int x = 0;
		if(s.charAt(i)==s.charAt(j)) {
			int remainingLength = j-i-1;
			if(remainingLength == findLCSOfString(s,i+1,j-1) )
			 x = remainingLength+2;
		}
		int y = findLCSOfString(s,i+1,j);
		int z = findLCSOfString(s,i,j-1);
		int max1 = Math.max(x, y);
		return Math.max(max1, z);
	}

}

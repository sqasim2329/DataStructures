package com.data.divideAndConquer;

public class LongestCommonSubstringOftwoString {
	
	public static void main(String args[]) {
		String s1="abcde";
		String s2="bcd";
		
		System.out.println(lcs(s1,s2,0,0));
	}

	private static int lcs(String s1, String s2, int i, int j) {
		if(i>s1.length()-1 || j>s2.length()-1)
		return 0;
		
		int x=0;
		while((s1.charAt(i)==s2.charAt(j)))  {
			x=1+lcs(s1,s2,i+1,j+1);
			if(i >= s1.length() && j >= s2.length()) {
				break;
			}
		}
		int y=lcs(s1,s2,i+1,j);
		int z=lcs(s1,s2,i,j+1);
		return Math.max(x,Math.max(y, z));
	}

}

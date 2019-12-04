package com.data.divideAndConquer;

public class LPSofString {
	
	public static void main(String args[]) {
		String s = "MADAMA";
		System.out.println(findLPSOfString(s,0,s.length()-1));
	}

	private static int findLPSOfString(String s,int i, int j) {
		// TODO Auto-generated method stub
		if(i > j) {
			return 0;
		}
		
		if(i == j) {
			return 1;
		}
		int x = 0;
		if(s.charAt(i) == s.charAt(j))
		x = 2 + findLPSOfString(s,i+1,j-1);
		int y = findLPSOfString(s,i+1,j);
		int z = findLPSOfString(s,i,j-1);
		
		int max1 = Math.max(x, y);
		return Math.max(max1, z);
	}

}

package com.data.divideAndConquer;

public class LCSOfTwoStrings {
	
	
	public static void main(String args[]) {
		String s1 =  "elephant";
		String s2 = "eretpat";
		
		System.out.println(findLCSofTheStrings(s1,s2,0,0));
	}

	private static int findLCSofTheStrings(String s1, String s2, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i >= s1.length() || j >=s2.length() )
			return 0;
		int x = 0;
		if(s1.charAt(i) == s2.charAt(j))
		x =1 + findLCSofTheStrings(s1,s2,i+1,j+1);
		int y = findLCSofTheStrings(s1,s2,i+1,j);
		int z = findLCSofTheStrings(s1,s2,i,j+1);
		
		int max1 = Math.max(x, y);
		return Math.max(max1, z);
		
	}

}

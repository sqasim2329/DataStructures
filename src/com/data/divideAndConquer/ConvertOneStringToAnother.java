package com.data.divideAndConquer;

public class ConvertOneStringToAnother {
	
	public static void main(String args[]) {
		String s1="table";
		String s2="tabcd gble";
		System.out.println(findMinOperations(s1,s2,0,0));
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

}

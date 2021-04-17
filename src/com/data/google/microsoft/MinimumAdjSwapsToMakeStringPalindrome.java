package com.data.google.microsoft;

import java.util.HashSet;
import java.util.Set;

public class MinimumAdjSwapsToMakeStringPalindrome {
	
	public static void main(String args[]) {
		String s =  "ntiin";
		if(!isPalindromic(s)) System.out.println(-1);
		else
		System.out.println(minSwaps(s));
	}

	private static boolean isPalindromic(String s) {
		// TODO Auto-generated method stub
		Set<Character> seen = new HashSet<>();
		for(char c:s.toCharArray()) {
			if(seen.contains(c))
				seen.remove(c);
			else 
				seen.add(c);
		}
		return seen.size()<=1;
	}

	private static int minSwaps(String s) {
		int n = s.length();
		char[] sch = s.toCharArray();
		int count = 0;
		for(int i=0;i<n/2;i++) {
			int j = n-i-1;// palindromes are at same distance from end .
			while(sch[i]!=sch[j]) {
				j--;
			}
			
			if(j == i)
			{
				swap(i,i+1,sch);
				count++;
			}
			else {
				while(j < n-i-1 ) {
					char tmp = sch[j];
					sch[j] = sch[j+1];
					sch[j+1]=tmp;
					j++;
					count++;
				}	
			}
			
			
			
		}
		
		return count;
	}
	
	private static void swap(int i, int j, char[] c) {
		char tmp = c[i];
		c[i] = c[j];
		c[j]=tmp;
	}

}

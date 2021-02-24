package com.data.string;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromePossible {
	
	public static void main(String args[]) {
		String s =  "abccccdd";
		System.out.println(longestPalindrome(s));
	}

	private static int longestPalindrome(String s) {
		Set<Character> set = new HashSet<>();
		int count =0;// is used to maintain the repeating characters
		for(char c:s.toCharArray()) {
			if(set.contains(c)) {
				count++;
				set.remove(c);
			}else {
				set.add(c);
			}
		}
		if(!set.isEmpty())
			return count*2+1;
		return count*2;
		
		
	}

}

/***
 * 				
 * 				b - 5
 * 				a - 3
 * 				c - 4
 * 	countOfPairs += 5/2;
 * 	countOfSingle += 5%2;
 * 
 * return countOfPairs*2+countOfSingle>0?1:0;
 * 
 * O(1) space and O(n) time
 * 
 * 
 * 
 * 
 * ****/

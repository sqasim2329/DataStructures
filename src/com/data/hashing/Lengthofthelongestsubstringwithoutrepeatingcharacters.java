package com.data.hashing;

import java.util.HashSet;
import java.util.Set;

public class Lengthofthelongestsubstringwithoutrepeatingcharacters {
	
	public static void main(String args[]) {
		String str = "GEEKKSFORGEEKS";
//		str = "APPLE";
		Set<Character> set= new HashSet<>();
		int max = 0;// if non empty string, else to 0
		
		for(char c: str.toCharArray()) {
			if(set.contains(c))
				set.clear();
			
				set.add(c);
				max = Math.max(max, set.size());
		}
		System.out.println(max);
		System.out.println(solve(str));
	}
	
	
	private static String solve(String s) {
		int left =0;
		int right =0;
		int len = 0;
		int minLeft = 0;
		Set<Character> set = new HashSet<>();
		while(right < s.length()) {
			if(!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				if(set.size() > len) {
					len = set.size();
					minLeft = left;
				}
				right++;
			}else {
				while(set.contains(s.charAt(right))) {
					set.remove(s.charAt(left));
					left++;
				}
			}
		}
		
		return s.substring(minLeft,minLeft+len);
	}

}





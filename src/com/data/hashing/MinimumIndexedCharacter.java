package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexedCharacter {
	
	public static void main(String args[]) {
//		String str = "adcffaet";
//		String patt = "onkl";
		
		String str = "geeksforgeeks";
		String patt = "set";
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++)
		map.putIfAbsent(str.charAt(i),i);
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<patt.length();i++) {
			if(map.containsKey(patt.charAt(i))) {
				min = Math.min(min, map.get(patt.charAt(i)));
			}
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

}

//https://www.geeksforgeeks.org/check-if-two-arrays-are-equal-or-not/

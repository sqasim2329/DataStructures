package com.data.google.microsoft;

import java.util.HashSet;
import java.util.Set;

public class LargestAlphabeticCharacterPresntInString {
	
	public static void main(String args[]) {
		String s = "dAeB";
		Set<Character> seen = new HashSet<>();
		for(char c:s.toCharArray()) {
			seen.add(c);
		}
		
		Character maxLowerCase = null;
		Character maxUpperCase = null;
		
		for(char c:s.toCharArray()) {
			if(Character.isLowerCase(c) && seen.contains(Character.toUpperCase(c))) {
				if(maxLowerCase == null)
					maxLowerCase = c;
				else
					maxLowerCase = (maxLowerCase-'a')<(c-'a')?c:maxLowerCase;
			}else if(Character.isUpperCase(c) && seen.contains(Character.toLowerCase(c))) {
				if(maxUpperCase == null)
					maxUpperCase = c;
				else
					maxUpperCase = (maxUpperCase-'a')<(c-'a')?c:maxUpperCase;
			}
		}
		
		if(maxUpperCase!=null && maxLowerCase!=null) {
			char val = Character.toUpperCase(maxLowerCase);
			System.out.println(maxUpperCase>val?maxUpperCase:val);
		}else if(maxUpperCase!=null)
			System.out.println(maxUpperCase);
		else if(maxLowerCase!=null) {
			char val = Character.toUpperCase(maxLowerCase);
			System.out.println(val);
		}else
			System.out.println(-1);
			
	}

}

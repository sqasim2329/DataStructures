package com.data.string;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {
	
	public static void main(String args[]) {
		
		String []words = {"aa","bb","cd"};
		String patt = "cc";
		
		
		for(int i =0; i< words.length;i++) {
			if(words[i].length()!=patt.length())
				continue;
			if(checkifPatternMatches(words[i],patt)) {
				System.out.println(words[i]);
				
			}
		}
		
	}

	private static boolean checkifPatternMatches(String word, String patt) {
		Map<Character,Character> map = new HashMap<>();
		for(int i=0;i<patt.length();i++) {
			if(map.containsKey(patt.charAt(i))) {
				if(map.get(patt.charAt(i)) != word.charAt(i))
					return false;
			}else {
				if(map.containsValue(word.charAt(i)))
					return false;
				map.put(patt.charAt(i),word.charAt(i));
			}
		}
		
		return true;
		
	}

}

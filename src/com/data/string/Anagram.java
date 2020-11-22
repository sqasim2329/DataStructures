package com.data.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
	
	
	static class Aangram{
		int index;
		String str;
		Aangram(int index,String str){
			this.index=index;
			this.str = str;
		}
	}
	
	static class StrComp implements Comparator<Aangram>{
		public int compare(Aangram a, Aangram b) {
			return a.str.compareTo(b.str);
		}
	}
	
	
	public static void main(String args[]) {
		String[] strArr = {"cat", "dog", "tac", "god", "act"};
		Map<String,List<String>> map = new HashMap<>();
		for(String word:strArr) {
			char[] ch = new char[26];
			for(char c:word.toCharArray()) {
				ch[c-'a']++;
			}
			String key = new String(ch);
			if(map.containsKey(key)) {
				map.get(key).add(word);
			}else {
				List<String> ls = new ArrayList<>();
				ls.add(word);
				map.put(key, ls);
			}
			
		}
		
		System.out.println(map.values());
	}

}

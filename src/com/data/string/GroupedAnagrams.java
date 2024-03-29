package com.data.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// can also use int arr to store the occurrence of the characters and then for int arr as the key in the map
public class GroupedAnagrams {
	
	private  static List<List<String>> groupAnagrams(List<String> words){
		Map<String, List<String>> res = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		for(String word:words) {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String str = new String(ch);
			if(!res.containsKey(str)) {
				res.put(str,new ArrayList<>());
			}
			res.get(str).add(word);			
		}
		for(Map.Entry<String,List<String>> e:res.entrySet()) {
			result.add(e.getValue());
		}
		
		return result;
	}
	
	//char / int arr cannot form a key in map, hence use char array instead of string array since it is easier to do 
	//String.valueOf(ca);, Integer[] will have null inside and can null pointer hence first update integrer array value to 0;
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs == null || strs.length == 0) return new ArrayList<>();
	        Map<String, List<String>> map = new HashMap<>();
	        for (String s : strs) {
	            char[] ca = new char[26];
	            for (char c : s.toCharArray()) ca[c - 'a']++;
	            String keyStr = String.valueOf(ca);
	            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
	            map.get(keyStr).add(s);
	        }
	        return new ArrayList<>(map.values());
	    }
	 
	 public static void main(String args[]) {
		 String s[] = {"eat","tea","tan","ate","nat","bat","tt","t"};
		 System.out.println(groupAnagrams(s));
	 }

}

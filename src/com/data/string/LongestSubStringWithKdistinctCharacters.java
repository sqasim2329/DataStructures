package com.data.string;

import java.util.HashMap;
import java.util.Map;
//use map instead of Set since set wont have count of duplicate characters  
public class LongestSubStringWithKdistinctCharacters {
	
	private static int longestSubStringWithKCharacterDsitinct(String s,int k) {
		int index =0;
		int len =0;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
			if(map.size()==k)
				len = Math.max(len, i-index+1);
			while(map.size()>k) {
				int count = map.get(s.charAt(index));
				if(count==1)
					map.remove(s.charAt(index));
				else
					map.put(s.charAt(index), map.get(s.charAt(index))-1);
				index++;
			}
		}
		
		return map.size()==k?len:-1;
	}
	
	public static void main(String args[]) {
		String s = "abcbbbbcccbdddadacb";
		int k=2;
		System.out.println(longestSubStringWithKCharacterDsitinct(s,k));
	}

}

// Explnation- increament the map until the condition is satisfied , once the conidition is satified get the 
//length, if the length > K then make the map size to K (i.e try to satify teh condition)
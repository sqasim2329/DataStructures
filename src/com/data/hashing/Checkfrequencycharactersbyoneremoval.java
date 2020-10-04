package com.data.hashing;
//https://www.geeksforgeeks.org/check-if-frequency-of-all-characters-can-become-same-by-one-removal/
public class Checkfrequencycharactersbyoneremoval {
	
	public static void main(String args[]) {
		String str="xxyyzz";
		int freq[]= new int[26];
		boolean flag =false;;
		for(char c:str.toCharArray()) {
			freq[c-'a']++;
		}
		if(allSame(freq,str))
			flag=true;
		for(char c:str.toCharArray()) {
			freq[c-'a']--;
			if(allSame(freq,str)) {
				flag = true;
				break;
			}
			freq[c-'a']++;
		}
		System.out.println(flag);
	}

	private static boolean allSame(int[] freq, String str) {
		int fr = 0;
		for(char c:str.toCharArray()) {
			if(freq[c-'a']>0) {
				fr = freq[c-'a'];
				break;
			}
		}
		for(char c:str.toCharArray()) {
			if(freq[c-'a']>0 && freq[c-'a']!=fr)
				return false;
		}
		return true;
	}

}

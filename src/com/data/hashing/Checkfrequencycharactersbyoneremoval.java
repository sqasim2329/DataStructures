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
		int fr = -1;
		for(int i =0;i<26;i++) {
			if(fr!=-1 && freq[i]!=0 && fr !=freq[i])
				return false;
			
			if(fr == -1 && freq[i]!=0) fr= freq[i];
		}
		
		return true;
	}
}
//Map<Freq,List>}

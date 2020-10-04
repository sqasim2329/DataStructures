package com.data.hashing;

public class UnCommonCharacterOfTwoStrings {
	
	public static void main(String args[]) {
		String str1 = "characters";
		String str2 = "alphabets";
		
		int[] freq =new int[26];
		
		for(char c:str1.toCharArray()){
			freq[c-'a']=1;//indicates that it is available in first string only
		}
		
		for(char c:str2.toCharArray()){
			if(freq[c-'a']==1 || freq[c-'a']==-1)// check if availble in 1st or already present in both
				freq[c-'a']=-1;//indicates that it is available in both the strings
			else 
				freq[c-'a']=2;//indicates that is available in secodn string only
		}
		
		for(int i=0;i<26;i++) {
			if(freq[i]==1 || freq[i]==2)
			System.out.println((char)(i+'a'));
		}
		
		
		
	}

}

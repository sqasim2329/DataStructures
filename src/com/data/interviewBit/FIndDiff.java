package com.data.interviewBit;

public class FIndDiff {
	

	class Solution {
	    public char findTheDifference(String s, String t) {
	        
	        int freq[] = new int[26];
	        for(char c:s.toCharArray()){
	            freq[c-'a']++;
	        }
	        
	        for(char c:t.toCharArray()){
	            freq[c-'a']--;
	        }
	        char res = 'a';
	        for(int i=0;i<26;i++){
	            if(freq[i]!=0){
	                res = (char)(i+'a');
	            }
	        }
	        
	        return res;
	        
	        
	        
	    }
	}
	
	 public char findTheDifference(String s, String t) {
	        
	        char c =0;
	        for(char ch:s.toCharArray()){
	            c ^= ch;
	        }
	        
	        for(char ch:t.toCharArray()){
	            c ^= ch;
	        }
	        
	        
	        return c;
	        
	        
	    }

}

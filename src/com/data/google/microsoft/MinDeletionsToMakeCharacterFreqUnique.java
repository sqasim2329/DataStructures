package com.data.google.microsoft;

public class MinDeletionsToMakeCharacterFreqUnique {
	
	class Solution {
	    public int minDeletions(String s) {
	        int[] freq = new int[26];
	        for(char c:s.toCharArray()){
	            freq[c-'a']++;
	        }
	        Arrays.sort(freq);
	        int expected = freq[25];
	        int res = 0;
	        for(int i=25; i>=0; i--){
	            if(freq[i]==0) continue;
	            if(freq[i] > expected){
	                res+=freq[i]-expected;
	            }else{
	                expected = freq[i];
	            }
	            if(expected > 0) expected--;
	        }
	        return res;
	    }
	}

}

package com.data.string;

import java.util.List;
//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class LongestSubsequenceofGivenWords {
	
	class Solution {
	    public String findLongestWord(String s, List<String> d) {
	        
	        String ans ="";
	        for(String word:d){
	            int i=0;
	            for(char c : s.toCharArray())
	                if(i < word.length() && c == word.charAt(i))i++;//if i reaches end it means  word is subsequence
	                if(i == word.length() && (word.length() > ans.length() ||( word.length() == ans.length() && word.compareTo(ans) < 0)))
	                    ans = word;
	            
	            
	        }
	        return ans;
	        
	    }
	}

}

//for contanct space appraoch


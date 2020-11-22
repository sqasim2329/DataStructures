package com.data.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
	
	class Solution {
	    Map<String,List<String>> dp = new HashMap<>();
	    public List<String> wordBreak(String s, List<String> wordDict) {
	        if(dp.containsKey(s)){
	            return dp.get(s);
	        }
	        List<String> result = new ArrayList<>();
	        if(s.length() == 0){
	            result.add("");
	            return result;
	        }
	        
	        for(String word:wordDict){
	            if(s.startsWith(word)){
	                List<String> substrings = wordBreak(s.substring(word.length()),wordDict);
	                for(String substring:substrings){
	                    String optionalSpace = substring.length()!=0?" ":"";
	                        result.add(word + optionalSpace+ substring);
	                    
	                }
	                
	            }
	        }
	        dp.put(s,result);
	        return result;
	        
	        
	    }
	}

	/*
	cat + all other substrings
	cat + sand + all other substrings
	cat + sand + dog + ""--1


	cats + all other substrings
	cats + and + all other substring
	cats + and + dog + ""--2 */

}

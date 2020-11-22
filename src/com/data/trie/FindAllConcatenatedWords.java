package com.data.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllConcatenatedWords {
	
	class Solution {
	    
	    public List<String> findAllConcatenatedWordsInADict(String[] words) {
	        
	        List<String> result = new ArrayList<>();
	        Set<String> seen= new HashSet<>();
	        int minLength = Integer.MAX_VALUE;
	        //Set<String> dp = new HashSet<>();
	        
	        for(String word:words){
	            minLength = Math.min(word.length(),minLength);
	            if(word.length()!=0)
	            seen.add(word);
	        }
	        
	        for(String word:words){
	            if(isFormedFromWords(word,seen,minLength)){
	                result.add(word);
	            }
	        }
	    
	        
	        return result;
	    }
	    
	    private boolean isFormedFromWords(String word,Set<String> seen,int min){
	        //dp.conatains(word)--> return true;
	        for(int i=min;i<=word.length()-min;i++){
	            String left = word.substring(0,i);
	            String right = word.substring(i);
	            if(seen.contains(left)){
	                if(seen.contains(right)|| isFormedFromWords(right,seen,min)){
	                	//dp.add(word);
	                    return true;
	                }
	            }
	        }
	        
	        return false;
	    }
	    
	    
	}
	

}

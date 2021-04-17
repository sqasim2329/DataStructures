package com.data.google;

public class MaxScoreWords {
	
	class Solution {
	    public int maxScoreWords(String[] words, char[] letters, int[] score) {
	        
	        int[] count = new int[100];
	        for(char c:letters)
	            count[c-'a']++;
	        
	        return backTrack(words,count,score,0);

	    }
	    
	    private int backTrack(String[] words,int[] count,int[] score,int index){
	        if(index >= words.length)
	            return 0;
	        int max =0;
	        
	        for(int i=index;i<words.length;i++){
	        	int res = 0;
	            boolean isValid = true;
	            for(char c:words[i].toCharArray()){
	                if(count[c-'a']<1) isValid = false;
	                count[c-'a']--;
	                res +=score[c-'a'];
	            }
	            
	            if(isValid){
	               res+=backTrack(words,count,score,i+1);
	                max = Math.max(res,max);
	            }
	            
	            for(char c:words[i].toCharArray())
	                count[c-'a']++;
	        }
	        
	        return max;
	    }
	} 
	  


}

/////****
//
//		//
//
//
//
//
//
//**////

package com.data.google.microsoft;

public class MaximumLengthOfConcatenatedStringWithUnqueCharacters {
	
	class Solution {
	    public int maxLength(List<String> arr) {
	            int[] freq = new int[26];
	        return backTrack(arr,0,freq);
	    }
	    
	    
	    private int backTrack(List<String> arr, int index, int[]freq){
	        if(index >= arr.size())
	            return 0;
	        int max =0;
	        for(int i=index;i<arr.size();i++){
	            int len = 0;
	            boolean isValid = true;
	            for(char c:arr.get(i).toCharArray()){
	                freq[c-'a']++;
	                if(freq[c-'a']==2){
	                    isValid = false;
	                }
	            }
	            len = arr.get(i).length();
	            if(isValid){
	             len+= backTrack(arr,i+1,freq); 
	             max = Math.max(max,len);
	            }
	            
	            for(char c:arr.get(i).toCharArray()){
	                freq[c-'a']--;
	            }
	        }
	        return max;
	    }
	}



	              

}

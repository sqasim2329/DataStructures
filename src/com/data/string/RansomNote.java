package com.data.string;

public class RansomNote {
	
	 public boolean canConstruct(String ransomNote, String magazine) {
	        
	        if(ransomNote == null && magazine==null)
	            return true;
	        
	        if(ransomNote == null || magazine==null)
	            return true;
	        
	        int ranfreq[] = new int[26];
	        
	        
	        for(char c:ransomNote.toCharArray()){
	            ranfreq[c-'a']--;
	        }
	        
	        for(char c:magazine.toCharArray()){
	            ranfreq[c-'a']++;
	        }
	        
	        for(int i=0;i<26;i++){
	            if(ranfreq[i]<0){
	                return false;
	            }
	        }
	        
	        return true;
	        
	    }

}

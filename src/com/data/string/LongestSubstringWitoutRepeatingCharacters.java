package com.data.string;

import java.util.HashSet;
import java.util.Set;
//sliding window texhnique
//example dvdf
public class LongestSubstringWitoutRepeatingCharacters {
	
	 public static int lengthOfLongestSubstring(String s) {
	        
	        int i=0;
	        int j=0;
	        int len=0;
	        Set<Character> set = new HashSet<>();
	        if(s.isEmpty())
	            return 0;
	        while(i<=j && j<s.length()){
	            if(!set.contains(s.charAt(j))){
	                set.add(s.charAt(j));
	                len = Math.max(len,j-i+1);
	                j++;
	                
	            }else{
	                while(set.contains(s.charAt(j))){
	                    set.remove(s.charAt(i));
	                    i++;
	                }
	            }
	        }
	        return len;
	        
	 }
	 
	 public static void main(String args[]) {
		 String s = "dvdf";
		 System.out.println(lengthOfLongestSubstring(s));
	 }
}

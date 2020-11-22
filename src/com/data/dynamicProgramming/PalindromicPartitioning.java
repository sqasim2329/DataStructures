package com.data.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PalindromicPartitioning {
	
	 public List<List<String>> partition(String s) {
	        
	        List<List<String>> res = new ArrayList<>();
	        List<String> ls = new ArrayList<>();
	        backTrack(res,ls,s,0);
	        return res;
	    }
	    
	    
	    private void backTrack(List<List<String>> res, List<String> ls,String s, int start){
	        
	        if(start >= s.length()){
	            res.add(new LinkedList<>(ls));
	            return;
	        }
	        
	        for(int end=start;end<s.length();end++){
	            if(isPalindrome(s,start,end)){
	                ls.add(s.substring(start,end+1));
	                backTrack(res,ls,s,end+1);
	                ls.remove(ls.size()-1);
	            }
	        }
	    }
	    
	    public boolean isPalindrome(String s, int low, int high){
	        while(low < high)
	         if(s.charAt(low++) != s.charAt(high--)) return false;
	        return true;
	} 
	    //count can be removed
	    public boolean canPermutePalindrome(String s) {
	        
	        if(s == null)
	            return true;
	        
	        int count=0;
	        Set<Character> set = new HashSet<>();
	        
	        for(char c:s.toCharArray())
	        {
	            if(set.contains(c)){
	                count++;
	                set.remove(c);
	            }else{
	                set.add(c);
	            }
	        }
	        
	        if(set.size()<=1){
	            return true;
	        }
	        return false;
	        
	    }
	        

}

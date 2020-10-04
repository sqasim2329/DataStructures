package com.data.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	        
	        for(int i=start;i<s.length();i++){
	            if(isPalindrome(s,start,i)){
	                ls.add(s.substring(start,i+1));
	                backTrack(res,ls,s,i+1);
	                ls.remove(ls.size()-1);
	            }
	        }
	    }
	    
	    public boolean isPalindrome(String s, int low, int high){
	        while(low < high)
	         if(s.charAt(low++) != s.charAt(high--)) return false;
	        return true;
	} 

}

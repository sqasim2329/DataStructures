package com.data.greedy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	 public boolean isIsomorphic(String s, String t) {
	        boolean flag = false;
	        if(s == null && t == null)
	            return true;
	        
	        if((s!=null && t== null) ||(s==null && t!=null))
	            return false;
	        
	        if(s.length()!=t.length())
	            return false;
	        Map<Character,Character> freq = new HashMap<>();
	        for(int i = 0 ;i< s.length();i++){
	            char a = s.charAt(i);
	            char b = t.charAt(i);
	            
	            if(freq.containsKey(a)){
	                if(freq.get(a) != b){
	                    return false;
	                }
	            }else{
	                if(freq.containsValue(b)){
	                    return false;
	                }
	                freq.put(a,b);
	            }
	        }
	        
	        return true;
	        
	    }
	 
		    public boolean wordPattern(String pattern, String s) {
		        
		        if(pattern == null && s == null)
		            return true;
		        
		        if(pattern == null || s == null)
		            return false;
		        String[] words = s.split("\\s+");
		        
		        if(pattern.length() != words.length)
		            return false;
		        Map<Character,String> map = new HashMap<>();
		        for(int i=0;i<pattern.length();i++){
		            char a = pattern.charAt(i);
		            String b = words[i];
		            if(map.containsKey(a)){
		                if(!map.get(a).equals(b))
		                    return false;
		            }else{
		                if(map.containsValue(b))
		                    return false;
		                map.put(a,b);
		            }
		        }
		        
		        return true;
		        
		        
		        
		    }

}

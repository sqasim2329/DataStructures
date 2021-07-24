package com.data.linkedin;

public class DistinctSubStrings {
	
	class Solution 
	{ 
	    int fun(String s) 
	    {
	        Set<String> seen = new HashSet<>();
	        for(int i=1;i<s.length();i++){
	            StringBuilder tmp = new StringBuilder();
	            tmp.append(s.charAt(i-1));
	            tmp.append(s.charAt(i));
	            seen.add(tmp);
	        }
	        return seen.size();
	    }
	} 


}

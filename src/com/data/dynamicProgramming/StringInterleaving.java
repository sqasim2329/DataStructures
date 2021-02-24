package com.data.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class StringInterleaving {
	
	public boolean isInterleave(String s1, String s2, String s3) {
        Map<String,Boolean> map = new HashMap<>();
        return isInterleavingHelper(s1,s2,s3,map);
        
    }
    
    
    private boolean isInterleavingHelper(String s1, String s2, String s3,Map<String,Boolean> map){
        String key = s1+"*"+s2+"*"+s3;
        if(map.containsKey(key))
            return map.get(key);
        if(s1 == null && s2== null && s3 == null)
            return true;
        
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
            return true;
        
        if(s1.length() + s2.length() !=s3.length())
            return false;
        
        boolean x = false;
        boolean y = false;
        if((!s1.isEmpty() && s1.charAt(0)==s3.charAt(0)))
            x = isInterleavingHelper(s1.substring(1),s2,s3.substring(1),map);
        if((!s2.isEmpty() && s2.charAt(0)==s3.charAt(0)))
            y = isInterleavingHelper(s1,s2.substring(1),s3.substring(1),map);
        
        map.put(key,x||y);
        return map.get(key);
         
    }

}

package com.data.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {
	
	 Map<String, Boolean> map = new HashMap<>();
	    public boolean isMatch(String s, String p) {
	        if(p.isEmpty()) return s.isEmpty();
	       String key = s+"|"+p; 
	        if(map.containsKey(key)) return map.get(key);
	        
	        boolean firstChr = (!s.isEmpty() &&
	                         (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'));
	        
	        if(p.length()>=2 && p.charAt(1)=='*'){
	            boolean restChrs = isMatch(s,p.substring(2)) ||//zero characters "" .*
	                firstChr && isMatch(s.substring(1),p);//more chracters aa a*
	            map.put(key,restChrs);
	            return restChrs;
	        }else{
	            boolean restChrs = firstChr && isMatch(s.substring(1),p.substring(1));
	            map.put(key,restChrs);
	            return restChrs;
	        }
	    }

}

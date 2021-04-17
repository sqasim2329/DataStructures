package com.data.google;

public class RpleaceALLAvoidConsequitive {
	
	class Solution {
	    public String modifyString(String s) {
	        char[] schar = s.toCharArray();
	         char c='a';
	        for(int i=0;i<schar.length;i++){
	            if(schar[i] =='?'){
	                while((i>0 && c == schar[i-1]) || (i < schar.length-1 && c == schar[i+1])){
	                    c++;
	                    if(c > 'z')
	                        c='a';
	                }
	                schar[i]=c;
	            }
	        }
	        
	        return new String(schar);
	        
	    }
	}

}

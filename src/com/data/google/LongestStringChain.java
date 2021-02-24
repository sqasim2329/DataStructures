package com.data.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
	
	 public int longestStrChain(String[] words) {
	        
	        Map<String,Integer> map = new HashMap<>();
	        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
	        int len = 0;
	        int res = 0;
	        for(String word:words){
	            int max =0;
	            for(int i=0;i<word.length();i++){
	                String prev = word.substring(0,i)+word.substring(i+1);
	                max = Math.max(max,map.getOrDefault(prev,0)+1);
	            }
	            map.put(word,max);
	            res = Math.max(max,res);
	        }
	        
	        return res;
	        
	    }
	}


//	"bc,bd,bcd,bde,bdf,bef,bcde,bdef,bcdef"

}

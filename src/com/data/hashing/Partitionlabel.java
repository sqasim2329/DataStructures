package com.data.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partitionlabel {
	
	class Solution {
	    public List<Integer> partitionLabels(String s) {
	        
	        Map<Character,Integer> map = new HashMap<>();
	        for(int i =0;i<s.length();i++){
	            map.put(s.charAt(i),i);
	        }
	        List<Integer> ls = new ArrayList<>();
	        int max=0;
	        int left =0;
	        for(int i=0;i<s.length();i++){
	            if(max < map.get(s.charAt(i))){
	                max = map.get(s.charAt(i));
	            }
	            if(max == i){
	                ls.add(max -left+1);
	                left = max+1;
	                max =0;
	            }
	            
	        }
	        return ls;
	        
	    }
	}

}

/***
 * "a b a b c b a c a d e  f  e  g  d  e  h  i  j  h  k  l  i  j"
 *  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
 *  calculate the max index for each character.
 *  traverse the string again, keep max index and when index == i add length (left-max+1) to ls and update 
 *  left=max+1;
 * **/
 
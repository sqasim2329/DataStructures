package com.data.interviewBit;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class DistinctSubsequences {
	
	
	public int numDistinct(String s, String t) {
        Map<Pair<Integer,Integer>,Integer> map = new HashMap<>();
        return numDistinct(s,t,0,0,map);
        
    }
    
    private int numDistinct(String s, String t, int i, int j,Map<Pair<Integer,Integer>,Integer> map){
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(i, j);
        if(map.containsKey(key))
            return map.get(key);
        if(j == t.length())
            return 1;
        
        if(i == s.length())
            return 0;
        int count = 0;
        if(s.charAt(i)==t.charAt(j)){
             count+= numDistinct(s,t,i+1,j,map)+ numDistinct(s,t,i+1,j+1,map);
        }else{
             count+= numDistinct(s,t,i+1,j,map);
        }
        map.put(key,count);
        return count;
    }

}

ssap,sa
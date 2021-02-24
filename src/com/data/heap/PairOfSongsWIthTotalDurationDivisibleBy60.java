package com.data.heap;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongsWIthTotalDurationDivisibleBy60 {
	
	class Solution {
	    public int numPairsDivisibleBy60(int[] time) {
	        Map<Integer,Integer> pairMap = new HashMap<>();
	        int count = 0;
	        for(int i=0;i<time.length;i++){
	            int rem = time[i]%60;
	            count+=pairMap.getOrDefault((60-rem)%60,0);//complement find && %60 is used in case 60%60 happens in previous step then 60-0=60 will not be available in map;
	            pairMap.put(rem,pairMap.getOrDefault(rem,0)+1);
	        }
	        return count;
	        
	    }
	}  
	    

}

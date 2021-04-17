package com.data.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountbalancing {
	
	class Solution {
	    public int minTransfers(int[][] transactions) {
	         Map<Integer, Integer> m = new HashMap<>();
	        for (int[] t : transactions) {
	            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
	            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
	        }
	        return settle(0, new ArrayList<>(m.values()));
	    }
	    
	    
	    int settle(int start, List<Integer> debt) {
	        while (start < debt.size() && debt.get(start) == 0)
	            start++;
	        if (start == debt.size()) return 0;
	        int r = Integer.MAX_VALUE;
	        for (int i = start + 1; i < debt.size(); i++)
	            if (debt.get(start) * debt.get(i) < 0) {
	                debt.set(i, debt.get(i) + debt.get(start));
	                r = Math.min(r, 1 + settle(start + 1, debt));
	                debt.set(i, debt.get(i) - debt.get(start));
	            }
	        return r;
	    }
	}


	// if a person is giving his debt decreases;
	// if a preson is taking his debt increases;

	// we start at 1st debt and check if it can give us negative value(pos * negative  < 0 and debt can be reduced)
//	     hence compare i+1 with start then try to check if debt of next can be reduced

	  
//
//	[0,1,10], [2,0,5]
//
//
//
//
//	0 gives 10 to 1 hence        0-> -10
//	1 takes 10 from 1 hence.     1->  10
//	2 gives 5 to 0 hence         2->-5
//	0 takes 5 from 2 hence       0->-5
//	    
//	    
//	    
//	    [-5,10,-5]
//	    -5 * 10 -> <0 hence add them up
//	    [-5 5 -5]
//	    -5 * 5 < 0 hence add them up
//	    [-5,5,0]
//	    since we have reached end return 0;
//	so if we keep doing this at the end value becomes 0 and hence we can dertmine the trnsactions;
	    
	    
	          
	        
	        
	        
	        
	    


	    

}

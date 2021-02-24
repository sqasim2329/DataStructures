package com.data.interviewBit;

public class PaintHouse {
	
	class Solution {
	    public int minCost(int[][] costs) {
	        
	        if(costs.length == 0 || costs[0].length==0)
	            return 0;
	        Map<String,Integer> dp = new HashMap<>();
	        return Math.min(paintCost(0,0,costs,dp),
	                Math.min(paintCost(0,1,costs,dp),paintCost(0,2,costs,dp)));
	    }
	    
	    
	    private int paintCost(int index, int color,int[][] costs,Map<String,Integer> dp){
	        String key = index+"*"+color;
	        if(dp.containsKey(key))
	            return dp.get(key);
	        if(index >= costs.length)
	            return 0;
	        int totalCost = costs[index][color];
	        
	        if(color == 0)
	             totalCost+=Math.min(paintCost(index+1,1,costs,dp),
	                           paintCost(index+1,2,costs,dp));
	        
	        else if(color == 1)
	             totalCost+=Math.min(paintCost(index+1,0,costs,dp),
	                           paintCost(index+1,2,costs,dp));
	        
	        else if(color == 2)
	             totalCost+=Math.min(paintCost(index+1,1,costs,dp),
	                           paintCost(index+1,0,costs,dp));
	        dp.put(key,totalCost);
	        return totalCost;
	        
	    }
	}

}

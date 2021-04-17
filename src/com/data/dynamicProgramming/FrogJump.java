package com.data.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrogJump {
	
	class Solution {
	    public boolean canCross(int[] stones) {
	        Map<String, Boolean> dp = new HashMap<>();
	        return solve(stones,0,0,dp);
	    }
	    
	    private boolean solve(int[] stones, int indx,int jumpSize,Map<String, Boolean> dp){
	        String key = indx+"|"+jumpSize;
	        if(dp.containsKey(key))
	            return dp.get(key);
	        if(indx == stones.length-1)
	            return true;
	        
	        
	        int indx1 = Arrays.binarySearch(stones,indx+1,stones.length,stones[indx]+jumpSize);
	            if(indx1>=0){
	                if(solve(stones,indx1,jumpSize,dp)){
	                    dp.put(key,true);
	                    return true;
	                }
	                    
	            }
	        
	        int indx2 = Arrays.binarySearch(stones,indx+1,stones.length,stones[indx]+jumpSize-1);
	            if(indx2>=0){
	                if(solve(stones,indx2,jumpSize-1,dp)){
	                    dp.put(key,true);
	                    return true;
	                }
	                    
	            }
	        
	        int indx3 = Arrays.binarySearch(stones,indx+1,stones.length,stones[indx]+jumpSize+1);
	            if(indx3>=0){
	                if(solve(stones,indx3,jumpSize+1,dp)){
	                    dp.put(key,true);
	                    return true;
	                }
	            }
	        dp.put(key,false);
	        return dp.get(key);
	        
	    }
	}

}

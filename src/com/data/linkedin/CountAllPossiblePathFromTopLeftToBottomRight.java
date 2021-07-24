package com.data.linkedin;

public class CountAllPossiblePathFromTopLeftToBottomRight {
	
	class Solution
	{
	    long numberOfPaths(int m, int n)
	    {   Map<String, Integer> dp = new HashMap<>();
	        return solve(m-1,n-1,dp);
	    }
	    
	    private static int solve(int r, int c,Map<String, Integer> dp){
	        
	        String key = String.valueOf(r)+"*"+String.valueOf(c);
	        if(dp.containsKey(key))
	            return dp.get(key);        
	        if(r==0 && c==0)
	            return 1;
	        
	        if(r == 0 && c > 0)
	            return solve(0,c-1,dp);
	            
	        if(r > 0 && c == 0)
	            return solve(r-1,c,dp);
	            
	        int total = 0;
	        total+=solve(r,c-1,dp);
	        total+=solve(r-1,c,dp);
	        dp.put(key,total);
	        return total;
	    }
	}
}

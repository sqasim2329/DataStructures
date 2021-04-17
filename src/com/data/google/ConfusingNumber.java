package com.data.google;

public class ConfusingNumber {
	
	class Solution {
	    public int confusingNumberII(int N) {
	        Map<Integer,Integer> map = new HashMap<>();
	        map.put(0, 0);
			map.put(1, 1);
			map.put(6, 9);
			map.put(8, 8);
			map.put(9, 6);
	        return solve(N,0,map);
	    }
	    
	    private int solve(int N, int curr, Map<Integer, Integer> map){
	        int res = 0;
	        if(isConfusingNumber(curr,map)){
	            res++;
	        }
	        
	        for(int key:map.keySet()){
	            int next = curr * 10 + key;
	            if(next != 0 && next <= N){
	                res+=solve(N,next,map);
	            }
	        }
	        
	        return res;
	    }
	    
	    private boolean isConfusingNumber(int n,Map<Integer,Integer> map) {
	        int src = n;
	        int res = 0;
	        while (n > 0) {
	            res = res * 10 + map.get( n % 10)==null?0:map.get( n % 10); 
	            n /= 10;
	        }
	        return res != src;
	    }
	}


	// 0 * 10 +1 = 1
//	         --- 1 * 10 + 1
//	                     --- 11 * 10 + 1
//	             1* 10 + 6
//	     0 * 10 +6 =6
//	     0 * 10 +8=8   
//	     0 * 10 +9=9
	    
	    

}

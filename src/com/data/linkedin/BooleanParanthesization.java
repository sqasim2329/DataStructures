package com.data.linkedin;

public class BooleanParanthesization {
	
	public class Solution {
	    public int cnttrue(String A) {
	        
	        Map<String,Integer> dp = new HashMap<>();
	        return solve(A,0,A.length()-1,true,dp);
	    }
	    
	    private int solve(String s, int i,int j,boolean isTrue,Map<String,Integer> dp){
	        String key = i+"*"+j+"*"+isTrue;
	        if(dp.containsKey(key))
	           return dp.get(key);
	        if(i>j)
	            return 0;
	            
	        if(i == j){
	            if(isTrue)
	                return s.charAt(i)=='T'?1:0;
	            else
	                return s.charAt(i)=='F'?1:0;
	        }
	        int count = 0;
	        for(int k=i+1;k<j;k+=2){
	            int lt = solve(s,i,k-1,true,dp);
	            int lf = solve(s,i,k-1,false,dp);
	            int rt = solve(s,k+1,j,true,dp);
	            int rf = solve(s,k+1,j,false,dp);
	            
	            if(s.charAt(k) == '^'){
	                if(isTrue)
	                    count+=lt*rf + lf*rt;
	                else
	                    count+=lt*rt + lf*rf;
	            }else if(s.charAt(k) =='|'){
	                if(isTrue)
	                    count+=lt*rt+lt*rf+lf*rt;
	                else
	                    count+=lf*rf;
	            }else {
	                if(isTrue)
	                    count+=lt*rt;
	                else
	                    count+=lf*rf+lt*rf+rt*lf;
	            }
	        }
	        dp.put(key,count);
	        return count%1003;
	    }
	}


}

package com.data.google.microsoft;

public class NumberOfWaysToSplitString {
	
	class Solution {
	    
	    private static final int m = 1_000_000_007;
	    
	    public int numWays(String s) {
	        int n= s.length();
	        int noOfOnes = 0;
	        for(int i=0;i<s.length();i++)
	           noOfOnes+=s.charAt(i)-'0';
	        
	        if(noOfOnes>0 && noOfOnes%3!=0)
	            return 0;
	        
	        if(noOfOnes == 0)
	            return (int)((n-2L)*(n-1L)/2)%m;
	        
	        
	        
	        // we can 2 cuts to get 3 non empty string;
	        int nofirstCut = 0;
	        int noSecondCut = 0;
	        int noOfOnesInEachString = noOfOnes/3;
	        int ones = 0;
	        for(int i=0;i<s.length();i++){
	            ones += s.charAt(i)-'0';
	            if(noOfOnesInEachString == ones )
	                nofirstCut++;
	            else if(noOfOnesInEachString*2 == ones)
	                noSecondCut++;
	        }
	        
	        return (nofirstCut*noSecondCut)%m;
	        
	        
	        
	        
	        
	    }
	}

}

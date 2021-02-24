package com.data.interviewBit;

public class NumberOf1Bits {
	
	public class Solution {
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	        
	        int cnt =0;
	        while(n!=0){
	            cnt +=(n & 1);
	            n=n>>>1;//unsigned right shift
	        }
	        
	        return cnt;
	        
	    }
	}

}

package com.data.interviewBit;

public class CountingBits {
	
	class Solution {
	    public int[] countBits(int num) {
	        int[] res = new int[num+1];
	        for(int i=1;i<=num;i++){
	            if(i%2 == 0)
	                res[i] = res[i/2];
	            else
	                res[i] = 1+res[i/2];
	        }
	        return res;
	        
	    }
	}
	 
	     
	     
	     
//	      5 -> 101
//	      5/2 -> 2 -> 010 division is right shift, hence 1 bit moved to right, hence for odd number it 1+ x/2 number of bits
//	      6/2 -> 3-> 011 division is right shift , hence 1 bit is moved to right, since even number it remains same as x/2 number of bits;
	    

}

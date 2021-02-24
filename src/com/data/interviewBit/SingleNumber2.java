package com.data.interviewBit;

public class SingleNumber2 {
	
	 public int singleNumber(int[] nums) {
	        
	        
	        int result = 0;
	        for(int i=0;i<32;i++){
	            int count = 0;
	            for(int j=0;j<nums.length;j++){
	                if((nums[j] & (1 << i))!=0){
	                    count++;
	                }
	            }
	           result = result | ((count%3)<<i); 
	        }
	        return result;
	    }

}


/***
 * 
 * how to check if bit is set at i th position for a number
 * num & (1<<i)!=0 
 * 
 * how to set bit at ith position
 * nums | (1 << i)
 * 1<<i is 2 to the power i
 * 
 * why divide by mod 3 since every other number will appear thrice except one number
 * ***/

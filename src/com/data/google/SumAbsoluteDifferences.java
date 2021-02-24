package com.data.google;

public class SumAbsoluteDifferences {
	
	  public int[] getSumAbsoluteDifferences(int[] nums) {
	        int n = nums.length;
	        int prefix[]= new int[n+1];
	        for(int i=0;i<n;i++){
	            prefix[i+1]=prefix[i]+nums[i];
	        }
	        
	        int[] res= new int[n];
	        for(int i=0;i<n;i++){
	            res[i]=((i*nums[i])-prefix[i])+((prefix[n]-prefix[i])-(n-i)*nums[i]);
	        }
	        return res;
	    }
	}


	// num[i]-num[0]....nums[i]-nums[i-1];
	// nums[i]-num[i] nums[i+1]-nums[i]....nums[n-1]-nums[i]

	// (i*nums[i])-prefix[i]+(prefix[n]-prefix[i])-(n-i)*nums[i]

}

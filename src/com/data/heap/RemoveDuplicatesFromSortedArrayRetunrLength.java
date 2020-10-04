package com.data.heap;

public class RemoveDuplicatesFromSortedArrayRetunrLength {
	
	 public int removeDuplicates(int[] nums) {
	        
	        if(nums.length==0 || nums.length==1)
	            return nums.length;
	        
	        int i=1;
	        int indx=0;
	        
	        while(i<nums.length){
	            if(nums[i]==nums[i-1]){
	                i++;
	            }else{
	                indx++;
	                nums[indx] = nums[i++];
	            }
	        }
	        return indx+1;
	        
	    }

}

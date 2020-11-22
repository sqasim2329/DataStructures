package com.data.heap;
//same can be used for find peak element
public class PeakIndexInMountainArray {
	
	 public int peakIndexInMountainArray(int[] nums) {
	        int low = 0;
	        int hi = nums.length-1;
	        while(low<hi){
	            int mid = low+(hi-low)/2;
	            if(nums[mid]<nums[mid+1]){
	                low =mid+1;
	            }else{
	                hi=mid;
	            }
	        }
	        
	        return low;
	        
	        
	    }

}

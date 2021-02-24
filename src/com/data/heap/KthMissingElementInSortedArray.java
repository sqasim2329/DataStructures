package com.data.heap;

public class KthMissingElementInSortedArray {
	
	class Solution {
	    public int missingElement(int[] nums, int k) {
	        int i=0;
	        for(i=0;i<nums.length-1;i++){
	            int diff = nums[i+1]-nums[i]-1;
	            if(k>diff)
	                k=k-diff;
	            else
	                break;
	        }
	        return nums[i]+k;
	    }
	}
	
	
	class Solution {
	    public int findKthPositive(int[] nums, int k) {
	        int l =0;
	        int r =nums.length-1;
	        while(l<=r){
	            int mid = l+(r-l)/2;
	            if(nums[mid]-mid-1 < k)
	                l =mid+1;
	            else
	                r =mid-1;
	        }
	        return l+k;
	    }
	    
	}

}

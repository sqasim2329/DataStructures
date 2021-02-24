package com.data.google;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/solution/
public class RemoveDuplicatesFromSortedArray2 {
	
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        
	        int len = 1;
	        int num = nums[0];
	        int cnt =1;
	        for(int i=1;i<nums.length;i++){
	            if(num==nums[i]){
	                cnt++;
	                if(cnt<=2)
	                len++;
	            }else{
	                num = nums[i];
	                cnt =1;
	                len++;
	            }
	            nums[len-1]= nums[i];
	        }
	        return len;
	        
	    }
	}


	 
	    
	    


}

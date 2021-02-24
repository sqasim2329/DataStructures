package com.data.interviewBit;

public class FindDuplicateNumber {
	
	class Solution {
	    public int findDuplicate(int[] nums) {
	        
	        int slow = 0;
	        int fast = 0;
	        
	        while(fast < nums.length && nums[fast] < nums.length){
	            fast = nums[nums[fast]];
	            slow = nums[slow];
	            if(fast == slow){
	                fast = 0;
	                while(slow!=fast){
	                    fast = nums[fast];
	                    slow = nums[slow];
	                }
	                return slow;
	            }
	        }
	        return -1;
	        
	    }
	}



}

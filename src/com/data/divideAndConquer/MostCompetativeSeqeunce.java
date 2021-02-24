package com.data.divideAndConquer;

import java.util.Stack;

public class MostCompetativeSeqeunce {
	
	class Solution {
	    public int[] mostCompetitive(int[] nums, int k) {
	        
	        Deque<Integer> stk = new ArrayDeque<>();
	        int numberOfElementsDropped = nums.length-k;
	        for(int i=0;i<nums.length;i++){
	            while(!stk.isEmpty() && stk.peekLast() > nums[i] && numberOfElementsDropped-- > 0){
	                stk.pollLast();
	            }
	            stk.addLast(nums[i]);
	        }
	        int[] num = new int[k];
	        for(int i=0;i<k;i++){
	            num[i]=stk.pollFirst();
	        }
	        
	        return num;
	       
	    }
	}
	    
//if K elements subsequences have to be made then some elements need to be dropped.
//	that os n-k;
	//and it should be increasin stack ,since first non matchign character should be less than other subsequence 

}

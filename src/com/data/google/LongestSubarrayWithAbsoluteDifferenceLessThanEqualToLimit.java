package com.data.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class LongestSubarrayWithAbsoluteDifferenceLessThanEqualToLimit {
	
	class Solution {
	    public int longestSubarray(int[] nums, int limit) {
	        
	        TreeMap<Integer,Integer> map = new TreeMap<>();
	        int i=0;
	        int max = 0;
	        for(int j=0;j<nums.length;j++ ){
	            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
	            while(map.lastEntry().getKey() - map.firstEntry().getKey() > limit){
	                map.put(nums[i], map.get(nums[i])-1);
	                if(map.get(nums[i])==0)map.remove(nums[i]);
	                i++;
	            }
	            max = Math.max(max,j-i+1);
	        }
	        return max;
	        
	    }
	}

}

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        Deque<Integer> max = new ArrayDeque();
        Deque<Integer> min = new ArrayDeque();
        int s = 0;
        int e = 0;
        int maxLen = 0;
        while(e < nums.length){
            while(!max.isEmpty() && nums[max.peekLast()] < nums[e] ){
                max.pollLast();
            }
            max.addLast(e);
            while(!min.isEmpty() && nums[min.peekLast()] > nums[e] ){
                min.pollLast();
            }
            min.addLast(e);
            
            int maxi = nums[max.peekFirst()];
            int mini = nums[min.peekFirst()];
            
            if(Math.abs(maxi-mini) > limit){
                s++;
                if(max.peekFirst() < s) max.pollFirst();
                if(min.peekFirst() < s) min.pollFirst();
            }
            maxLen = Math.max(maxLen,e-s+1);
            e++;
        }
        
        return maxLen;
        
        
        
    }
}


    
    
    
    

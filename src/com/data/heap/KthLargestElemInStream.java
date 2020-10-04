package com.data.heap;

import java.util.PriorityQueue;

public class KthLargestElemInStream {
	class KthLargest {
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	    int k;
	    public KthLargest(int k, int[] nums) {
	        this.k= k;
	        int res[] = new int[nums.length];
	        for(int i:nums){
	            add(i,res);
	        }
	        for(int i=0;i<nums.length;i++)
	        	System.out.println(res[i]);
	    }
	    
	    public int add(int val,int[] res) {
	        int i=0;
	        if(pq.size() < k){
	            pq.add(val);
	            res[i++] = -1;
	        }else{
	            if(pq.peek() < val){
	                res[i++]=pq.poll();
	                pq.add(val);
	            }
	                
	        }
	        return pq.peek();
	        
	    }
	}

	/**
	 * Your KthLargest object will be instantiated and called as such:
	 * KthLargest obj = new KthLargest(k, nums);
	 * int param_1 = obj.add(val);
	 */

}


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        
        for(int i=k;i<n;i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        return pq.peek();
        
    }
}


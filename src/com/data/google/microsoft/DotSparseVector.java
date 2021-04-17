package com.data.google.microsoft;

public class DotSparseVector {
	
	class SparseVector {
	    Map<Integer,Integer> map;
	    SparseVector(int[] nums) {
	        this.map = new HashMap<>();
	        this.nums = nums;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]!=0)
	                map.put(i,nums[i]);        
	        }
	        
	    }
	    
		// Return the dotProduct of two sparse vectors
	    public int dotProduct(SparseVector vec) {
	        int sum = 0;
	        if(this.map.size() > vec.map.size())
	            return vec.dotProduct(this);
	        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
	            int index = entry.getKey();
	            int val = entry.getValue();
	            sum+=vec.map.getOrDefault(index,0)*val;
	        }
	        return sum;
	    }
	}

	// Your SparseVector object will be instantiated and called as such:
	// SparseVector v1 = new SparseVector(nums1);
	// SparseVector v2 = new SparseVector(nums2);
	// int ans = v1.dotProduct(v2);

}

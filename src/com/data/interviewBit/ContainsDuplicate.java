package com.data.interviewBit;

import java.util.Set;

public class ContainsDuplicate {
	
public boolean containsNearbyDuplicate(int[] nums, int k) {
        
	 Set<Integer> seen = new HashSet<>();
     for(int i=0;i<nums.length;i++){
         if(seen.contains(nums[i])) return true;
             seen.add(nums[i]);
         if(seen.size())
             seen.remove(nums[i-k]);
     }
     
     return false;
     
 }

}

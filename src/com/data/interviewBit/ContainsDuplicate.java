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

//treeset is good if you have window of size k of previous values that can be queries
//
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0 || k <= 0) {
         return false;
     }

     final TreeSet<Integer> values = new TreeSet<>();//O(nlogk)
     for (int ind = 0; ind < nums.length; ind++) {

         final Integer floor = values.floor(nums[ind] + t);//logK
         final Integer ceil = values.ceiling(nums[ind] - t);
         if ((floor != null && floor >= nums[ind])
                 || (ceil != null && ceil <= nums[ind])) {
             return true;
         }

         values.add(nums[ind]);
         if (ind >= k) {
             values.remove(nums[ind - k]);
         }
     }

     return false;
 }

}

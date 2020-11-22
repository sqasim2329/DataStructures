package com.data.greedy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	
public int majorityElement(int[] nums) {
        
        int n = nums.length;
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
            if(freq.get(i)>n/2)
                return i;
        }
        
        return -1;
        
    }

class Solution {
    public int majorityElement(int[] nums) {
        
        int elem = 0;
        int count = 0;
        
        for(int i:nums){
            if(count == 0){
                elem = i;
                count++;
            }else{
                if(elem == i)
                    count++;
                else
                    count--;
            }
        }
        return elem;
        
    }
}

}

package com.data.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0;
        map.put(sum,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(k!=0)//k=0
                sum = sum%k;
            
            if(map.containsKey(sum)){
                if(i-map.get(sum)>1)
                return true;
            }
            else{//{0,0} 0 [0,-1]->[0,0] hence i-map.get(sum)>1 is not possible hence else 
            map.put(sum,i);
            }
                
        }
        
        return false;
    }
}
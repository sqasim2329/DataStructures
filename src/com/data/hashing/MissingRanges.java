package com.data.hashing;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	
public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> res = new ArrayList<>();
        
        if(nums.length==0){
            res.add(formString(lower,upper));
            return res;
        }
        
        if(nums[0]!=lower){
            res.add(formString(lower,nums[0]-1));
        }
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]!=nums[i] && nums[i]+1!=nums[i+1]){
                res.add(formString(nums[i]+1,nums[i+1]-1));
            }
        }
        
        
        if(nums[nums.length-1]!=upper){
            res.add(formString(nums[nums.length-1]+1,upper));
        }
        return res;
        
    }
    
    private String formString(int lower,int upper){
        return lower==upper?lower+"":lower+"->"+upper;
    }

}

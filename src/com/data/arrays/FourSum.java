package com.data.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j-1]==nums[j]) continue;
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while(k<l && nums[k]==nums[k+1])k++;
                        while(k<l && nums[l]==nums[l-1])l--;
                        k++;
                        l--;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l] < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return res;
        
    }
	
	class Solution {
	    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	        //a+b = -(c+d)
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int a:A){
	            for(int b:B){
	                map.put((a+b),map.getOrDefault(a+b,0)+1);
	            }
	        }
	        
	        int count =0;
	        for(int c:C){
	            for(int d:D){
	                if(map.containsKey(-(c+d))){
	                    count+=map.get(-(c+d));
	                }
	            }
	        }
	        
	        return count;
	        
	    }

}

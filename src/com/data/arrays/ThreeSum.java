package com.data.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//failing for few cases
public class ThreeSum {
	
	    public List<List<Integer>> threeSum(int[] nums) {
	        int n= nums.length;
	        List<List<Integer>> res = new ArrayList<>();
	        if(n<3)
	        	return res;
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<nums.length;i++)
	            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	        
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                int p=-(nums[i]+nums[j]);
	                if(map.getOrDefault(p,0)>0 ){
	                    map.put(nums[i],map.get(nums[i])-1);
	                    map.put(nums[j],map.get(nums[j])-1);
	                    map.put(p,map.get(p)-1);
	                    List<Integer> r= new ArrayList<>();
	                    r.add(nums[i]);
	                    r.add(nums[j]);
	                    r.add(p);
	                    res.add(r);
	                }
	            }
	        }
	        return  res;
	        
	    }
	    
	    public static void main(String args[]) {
//	    	int arr[] = {-1, 0, 1, 2, -1, -4};
//	    	int arr[] = {0,0};
	    	int arr[] = {0,0,0,0};
	    	ThreeSum t=  new ThreeSum();
	    	System.out.println(t.threeSum(arr));
	    }
	}



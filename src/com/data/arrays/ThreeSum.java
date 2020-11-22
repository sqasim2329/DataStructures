package com.data.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
	
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(nums);
	        int sum =0;
	        for(int i =0 ; i<nums.length-2;i++){
	            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
	            int j =i+1;
	            int k =nums.length-1;
	            sum =-nums[i];
	            while(j<k){
	                if(nums[j]+nums[k]==sum){
	                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
	                    while(j<k && nums[j]==nums[j+1])j++;
	                    while(j<k && nums[k]==nums[k-1])k--;
	                    j++;k--;
	                }else if(nums[j]+nums[k]>sum){
	                    k--;
	                }else
	                    j++;
	            }
	         
	          }
	            
	        }
	        
	        return res;
	        
	        
	    }
	    
	    public static void main(String args[]) {
//	    	int arr[] = {-1, 0, 1, 2, -1, -4};
//	    	int arr[] = {0,0};
	    	int arr[] = {0,0,0,0};
	    	ThreeSum t=  new ThreeSum();
	    	System.out.println(t.threeSum(arr));
	    }
	}



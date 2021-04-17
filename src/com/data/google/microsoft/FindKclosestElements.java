package com.data.google.microsoft;

public class FindKclosestElements {
	
	
	class Solution {
	    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        
	        int lo = 0;
	        int hi = arr.length-1;
	        
	        while(hi -lo >=k){
	            if(x - arr[lo] > arr[hi]-x){
	                lo++;
	            }else{
	                hi--;
	            }
	        }
	        List<Integer> res = new ArrayList<>();
	        for(int i=lo;i<=hi && k>0;i++){
	            res.add(arr[i]);
	            k--;
	        }
	        return res;
	        
	    }
	}



	// 1 2 3 4 5
	// lo      hi





}

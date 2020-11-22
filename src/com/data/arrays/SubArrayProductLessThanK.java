package com.data.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrayProductLessThanK {
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int left = 0;
        int right =0;
        int prod = 1;
        int res = 0;
        while(right < nums.length){
            prod *=nums[right];
            while(prod >= k){
                prod/=nums[left++];
            }
            res += right-left+1;
            right++;
        }
        
        return res;
        
        
    }
	//wrong but have to figure out
	public static void backTrack(int[] arr,int ind, int prod,List<List<Integer>> res,List<Integer> ls, int target) {
		if(prod >=target)
		{	
			return;
		}
		
		res.add(new ArrayList<>(ls));
		
		for(int i=ind;i<arr.length;i++) {
			ls.add(arr[i]);
			backTrack(arr,i+1,prod*arr[i],res,ls,target);
			ls.remove(ls.size()-1);
		}
	}
	
	public static void main(String args[]) {
		int arr[]= {10,5,2,6};
		int k=100;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> ls = new ArrayList<>();
		backTrack(arr,0,1,res,ls,k);
		System.out.println(res);
	}

}

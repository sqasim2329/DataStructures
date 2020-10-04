package com.data.stack;
//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
public class SearchInSortedRotatedArray {
	
public int search(int[] nums, int target) {
        
        int n = nums.length;
        if(n==0)
            return -1;
        int l = 0;
        int r = n-1;
        int first = nums[0];
        while(l <= r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target)
                return mid;
            
            boolean valBig = nums[mid] >= first;// check if mid is on big side wrt first
            boolean targetBig = target >= first;// check if target is on big side wrt first
            if(valBig == targetBig){//if both are same side then check if it at before or after mid
                if(nums[mid] > target)
                    r = mid-1;
                else
                    l=mid+1;
            }else{// else not on same side so check on opposite side of where mid is wrt to first
                if(valBig){
                    l= mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            
            
        }
        return -1;
        
    }

}

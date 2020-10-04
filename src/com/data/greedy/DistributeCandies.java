package com.data.greedy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
	//O(nlogn) O(1)
	public static void main(String args[]) {
		int nums[]= {1,1,2,2,3,3};
		int cnt=1;
		int n = nums.length;
		for(int i=1; i< n && cnt < n;i++) {
			if(nums[i]>nums[i-1]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		//2 Solution 
		Set<Integer> set= new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			set.add(nums[i]);
		}
		
		System.out.println(Math.min(set.size(),nums.length/2));
	}
	
	
	

}

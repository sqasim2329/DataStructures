package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDsitinctEleminEveryWindowOfSizeK {
	
	public static void main(String args[]) {
		int nums[]={1, 2, 1, 3, 4, 2, 3};
		int k=4;
		int n = nums.length;
		Map<Integer,Integer> map= new HashMap<>();
		for(int i=0;i<k;i++) {
			map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
		}
		System.out.println(map.size());
		for(int i=1;i<=n-k;i++) {
			
			int e = i+k-1;
			if(map.get(nums[i-1])==1) {
				map.remove(nums[i-1]);
			}else {
				map.put(nums[i-1], map.get(nums[i-1])-1);
			}
			
			map.put(nums[e], map.getOrDefault(nums[e], 0)+1);
			System.out.println(map.size());
		}
	}

}


/*
 * 
 * 
 * o/p array size is n-k+1; if o/p has to be stored in array 
 * 
 * **/
 
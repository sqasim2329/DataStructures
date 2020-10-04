package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class AllSubArraysWithSumZero {
	
	public static void main(String args[]) {
		int nums[]= {6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7};
		int sum =0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			
			if(nums[i]==0)
				System.out.println(i);
			
			if(sum==0) {
				System.out.println(0+" "+i);
			}
			
			if(map.containsKey(sum-0)) {
				System.out.println(map.get(sum)+1+" "+i);
			}
			map.put(sum,i);
		}
	}

}

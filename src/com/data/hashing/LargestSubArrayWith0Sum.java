package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0Sum {
	
	public static void main(String args[]) {
		int [] nums ={ 12, -2, 2, -8, 1, 7, 10, 23 }; ;
		int sum=0;
		int max =0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if(sum == 0)
				max = Math.max(max, i+1);// 0 based index so max elem having 0 sum
			if(nums[i]==0) {
				max = Math.max(1, max);
			}
			
			if(map.containsKey(sum))
				max = Math.max(max, i-map.get(sum));
			else
				map.put(sum,i);
		}
		System.out.println(max);
	}
	
	

}

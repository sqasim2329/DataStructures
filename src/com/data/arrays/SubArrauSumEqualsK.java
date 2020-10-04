package com.data.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrauSumEqualsK {
	
	public static void main(String args[]) {
		int []nums= {1,1,1};
		Map<Integer,Integer> map = new HashMap<>();
		int sum =0;
		int k=2;
		int res = 0;
		map.put(sum,1);//since we have seen 0 once
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if(map.containsKey(sum-k)) {
				res+=map.get(sum-k)     ;
			}
			map.put(sum,map.getOrDefault(sum, 0)+1);
		}
		
		System.out.println(res);
	}

}

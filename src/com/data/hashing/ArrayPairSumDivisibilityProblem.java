package com.data.hashing;

import java.util.HashMap;
import java.util.Map;
//https://www.youtube.com/watch?v=uVLp1tkT4NU--look for negative cases also
public class ArrayPairSumDivisibilityProblem {
	
	public static void main(String args[]) {
//		int nums[]= {9,7,5,3};
		int nums[]= {91, 74, 66, 48};
		int k = 10;
		boolean flag =true;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++)
			map.put(nums[i]%k,map.getOrDefault(nums[i]%k, 0)+1);
		
		if(map.containsKey(0) && map.get(0)%2==1)flag = false;// if there are elements in array completely divisible then total elements must be divisble completley by 2 to form pairs
		for(Map.Entry<Integer, Integer> e:map.entrySet()) {
			if(map.get(e.getKey())!=map.get(k-e.getKey())) {
				flag = false;
			break;
			}
		}
		
		System.out.println(flag);
		
	}

}

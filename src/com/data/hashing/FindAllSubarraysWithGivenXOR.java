package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindAllSubarraysWithGivenXOR {
	
	public static void main(String args[]) {
		int nums[]= {4, 2, 2, 6, 4};
//		int nums[]= {5, 6, 7, 8, 9};
		int m=6;
//		int m=5;
		int n= nums.length;
		int count = 0;
		int []xor = new int[n];
		Map<Integer,Integer> map = new HashMap<>();
		xor[0]=nums[0];
		for(int i=1;i<n;i++)
			xor[i]=nums[i]^xor[i-1];
		
		for(int i=0;i<n;i++) {
			if(xor[i]==m)
				count++;
			if(map.containsKey(m^xor[i])) {
				count += map.get(m^xor[i]);
			}
			map.put(xor[i], map.getOrDefault(xor[i], 0)+1);
		}
		
		System.out.println(count);
	}

}

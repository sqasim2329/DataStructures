package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindFourElemtoaSum {
	
	static class Pair{
		int a;
		int b;
		
		public Pair(int a, int b) {
			this.a =a;
			this.b=b;
		}
	}
	
	public static void main(String args[]) {
		int nums[]= {10, 2, 3, 4, 5, 9, 7, 8} ;
		int n= nums.length;
		Map<Integer,Pair> map = new HashMap<>();
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
				map.put(nums[i]+nums[j], new Pair(i,j));
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++) {
				if(map.containsKey(nums[i]+nums[j])) {
					Pair p = map.get(nums[i]+nums[j]);
					if(i!=p.a && i!=p.b && j!=p.a && j!=p.b) {
						System.out.println(nums[i]+" "+nums[j]+" "+nums[p.a]+" "+nums[p.b]);
					}
				}
			}
				
	}

}

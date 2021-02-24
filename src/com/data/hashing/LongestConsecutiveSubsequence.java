package com.data.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
	
	public static void main(String args[]) {
//		int nums[]= { 1, 9, 3, 10, 4, 20, 2 }; 
		int nums[]= {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}; 
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			set.add(nums[i]);
		}
		int max=0;
		for(int i=0;i<nums.length;i++) {
			if(!set.contains(nums[i]-1))//if set doesnot contains the arr[i]-1 it is the first ele of sunsequence
			{ int c =0;
				int j = nums[i];
				while(set.contains(j)) {
					j++;c++;
				}
				max = Math.max(c, max);
					
			}
		}
		
		System.out.println(max);
		
	}

}


//https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
//Solution: put in a set and check if all elem of small araay are preset in the set

private boolean checkIfSubarray(int[] nums,int[] sub) {
	
}


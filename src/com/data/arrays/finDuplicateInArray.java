package com.data.arrays;
//find duplicates in O(1) only if elem are between 0 and n-1
public class finDuplicateInArray {
	
	public static void main(String args[]) {
		int nums[]= {1, 2, 3, 1, 3, 6, 6};
		int n= nums.length;
		for(int i=0;i<n;i++) {
			int index = nums[i]%n;
			nums[index] +=n;
		}
		
		for(int i=0;i<n;i++) {
			if(nums[i]/n > 1) {
				System.out.print(i+" ");
			}
		}
	}

}

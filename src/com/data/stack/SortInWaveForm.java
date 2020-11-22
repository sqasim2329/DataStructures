package com.data.stack;

import java.util.Arrays;
import java.util.Comparator;

public class SortInWaveForm {
		
		public static void main(String args[]) {
			int nums[]= {10, 5, 6, 3, 2, 20, 100, 80};
			int n= nums.length;
			for(int i=0;i<nums.length;i+=2) {
				if(i > 0 && nums[i-1]>nums[i])
					swap(nums,i,i-1);
				if(i<n-1 && nums[i]<nums[i+1])
					swap(nums,i,i+1);
			}
			
			Arrays.stream(nums).forEach(System.out::println);
		
		}

		private static void swap(int[] nums, int i, int j) {
			int tmp = nums[i];
			nums[i] =nums[j];
			nums[j] = tmp;
		}

}
/**
 * 
 * 
 * 	a>=b<=c
 * 	i  (i+1)/(i-1)  i
 * if(a[i]<a[i+1]) swap(i.i+1)
 * if(a[i-1]>a[i]) swap(i-1,i)
 * 
 */
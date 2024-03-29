package com.data.dynamicProgramming;

import java.util.Arrays;

public class Longestincreasingsubsequence {
	
	public static void main(String args[]) {
//		int arr[] = {50, 3, 10, 7, 40, 10};
		int arr[] = {5,6,2,3,4};
		int maxEh = 1;
//		for(int i=1; i< arr.length; i++) {
//			if(arr[i]>arr[i-1]) {
//				maxEh=Math.max(maxEh, maxEh+1);
//			}
//		}
		int T[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			T[i]=arr[i];
		}
		for(int i=1; i<arr.length; i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					T[i]=Math.max(T[i], T[j]+T[i]);
				}
			}
		}
		System.out.println(maxEh);
	}
	
	
	private int longestAlternatingSequence(int[] nums) {
		int inc =1;
		int dec =1;
		
		for(int i=1;i<nums.length;i++) {
			if(nums[i-1]<nums[i])
				inc=dec+1;
			else if(nums[i-1]>nums[i]) {
				dec = inc+1;
			}
		}
		
		return Math.max(inc, dec);
	}
	
	
	class Solution {
	    public int lengthOfLIS(int[] nums) {
	        int[] dp = new int[nums.length];// length of non negative numbers in dp gives the LIS.//similar to piles card
	        int len = 0;
	        for (int num : nums) {
	            int i = Arrays.binarySearch(dp, 0, len, num);//where to search,start, end, num to search, if not found put in the negatove of ith index starting from 1
	            if (i < 0) {
	                i = -(i + 1);
	            }
	            dp[i] = num;
	            if (i == len) {//create space for new piles so that new non existant element be placed
	                len++;
	            }
	        }
	        return len;
	        
	        
	    }
	}
	// len=4
	// 10   9   2
	// 5    3 
	// 7
	// 101 18    
	   
	    
	    

}

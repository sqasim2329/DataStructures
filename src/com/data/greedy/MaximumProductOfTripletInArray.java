package com.data.greedy;

public class MaximumProductOfTripletInArray {
	
	public static void main(String args[]) {
		int nums[]= {1, -4, 3, -6, 7, 0 };
		int maxA= Integer.MIN_VALUE;
		int maxB= Integer.MIN_VALUE;
		int maxC= Integer.MIN_VALUE;
		int minA= Integer.MAX_VALUE;
		int minB= Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > maxA) {
				maxC = maxB;
				maxB = maxA;
				maxA = nums[i];
			}
			
			else if(nums[i] > maxB) {
				maxC=maxB;
				maxB=nums[i];
			}
			
			else if(nums[i] > maxC) {
				maxC = nums[i];
			}
			
			if(nums[i] < minA) {
				minB= minA;
				minA = nums[i];
			}
			
			else if(nums[i] < minB) {
				minB = nums[i];
			}
			
			
		}
		System.out.println(Math.max(maxA*maxB*maxC, minA*minB*maxA));
	}

}

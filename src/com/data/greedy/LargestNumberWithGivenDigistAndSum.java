package com.data.greedy;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-the-largest-number-with-given-number-of-digits-and-sum-of-digits/
public class LargestNumberWithGivenDigistAndSum {
	
	public static void main(String args[]) {
		int s = 9;
		int d = 2;
		
		int []nums = new int[d];
		for(int i=0; i<d;i++) {
			if(s>=9) {
				nums[i]=9;
				s= s-9;
			}
			else {
				nums[i]=s;
			}
		}
		
		Arrays.stream(nums).forEach(System.out::print);
	}

}

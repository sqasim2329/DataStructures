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

}

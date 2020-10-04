package com.data.arrays;

import java.util.Arrays;
//O(nlog(n))
public class ChoclateDsitributionprobelm {
	
	public static void main(String args[]) {
		int arr[]= {12, 4, 7, 9, 2, 23, 25, 41,
				30, 40, 28, 42, 30, 44, 48,
				43, 50};
		int m=7;
		Arrays.sort(arr);
		int n=arr.length;
		int end = 0;
		int min= Integer.MAX_VALUE;
		if(m==0 || n==0)
			System.out.println("0");
		for(int i=0;i<=n-m;i++) {
			end = i+m-1;
			min = Math.min(arr[end]-arr[i],min);
		}
		System.out.println(min);
	}

}
